// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.data.appconfiguration;

import com.azure.core.credential.TokenCredential;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.rest.Response;
import com.azure.core.test.TestProxyTestBase;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.data.appconfiguration.implementation.ConfigurationClientCredentials;
import com.azure.data.appconfiguration.implementation.ConfigurationSettingHelper;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import com.azure.data.appconfiguration.models.ConfigurationSettingsFilter;
import com.azure.data.appconfiguration.models.ConfigurationSnapshot;
import com.azure.data.appconfiguration.models.ConfigurationSnapshotStatus;
import com.azure.data.appconfiguration.models.FeatureFlagConfigurationSetting;
import com.azure.data.appconfiguration.models.FeatureFlagFilter;
import com.azure.data.appconfiguration.models.SecretReferenceConfigurationSetting;
import com.azure.data.appconfiguration.models.SettingFields;
import com.azure.data.appconfiguration.models.SettingSelector;
import com.azure.data.appconfiguration.models.SnapshotComposition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class ConfigurationClientTestBase extends TestProxyTestBase {
    private static final String KEY_PREFIX = "key";
    private static final String LABEL_PREFIX = "label";
    private static final int PREFIX_LENGTH = 8;
    private static final int RESOURCE_LENGTH = 16;
    // Disable `("$.key")` and name sanitizer from the list of common sanitizers
    public static final String[] REMOVE_SANITIZER_ID = { "AZSDK3493", "AZSDK3447" };

    public static final String FAKE_CONNECTION_STRING
        = "Endpoint=https://localhost:8080;Id=0000000000000;Secret=fakeSecrePlaceholder";

    static final Duration MINIMUM_RETENTION_PERIOD = Duration.ofHours(1);

    static TokenCredential tokenCredential;

    String keyPrefix;
    String labelPrefix;

    void beforeTestSetup() {
        keyPrefix = testResourceNamer.randomName(KEY_PREFIX, PREFIX_LENGTH);
        labelPrefix = testResourceNamer.randomName(LABEL_PREFIX, PREFIX_LENGTH + 2);
    }

    <T> T clientSetup(BiFunction<TokenCredential, String, T> clientBuilder) {
        if (tokenCredential == null) {
            tokenCredential = TestHelper.getTokenCredential(interceptorManager);
        }

        String endpoint = interceptorManager.isPlaybackMode()
            ? new ConfigurationClientCredentials(FAKE_CONNECTION_STRING).getBaseUri()
            : Configuration.getGlobalConfiguration().get("AZ_CONFIG_ENDPOINT");

        Objects.requireNonNull(tokenCredential, "Token Credential expected to be set.");
        Objects.requireNonNull(endpoint, "Az Config endpoint expected to be set.");

        return Objects.requireNonNull(clientBuilder.apply(tokenCredential, endpoint));
    }

    String getKey() {
        return testResourceNamer.randomName(keyPrefix, RESOURCE_LENGTH);
    }

    String getLabel() {
        return testResourceNamer.randomName(labelPrefix, RESOURCE_LENGTH);
    }

    @Test
    public abstract void addConfigurationSetting();

    @Test
    public abstract void addConfigurationSettingConvenience();

    void addConfigurationSettingRunner(Consumer<ConfigurationSetting> testRunner) {
        final Map<String, String> tags = new HashMap<>();
        tags.put("MyTag", "TagValue");
        tags.put("AnotherTag", "AnotherTagValue");

        final ConfigurationSetting newConfiguration
            = new ConfigurationSetting().setKey(getKey()).setValue("myNewValue").setTags(tags).setContentType("text");

        testRunner.accept(newConfiguration);
        testRunner.accept(newConfiguration.setLabel(getLabel()));
    }

    ConfigurationSetting addConfigurationSettingWithTagsRunner(Consumer<ConfigurationSetting> testRunner) {
        final Map<String, String> tags = new HashMap<>();
        tags.put("MyTag", "TagValue");
        tags.put("AnotherTag", "AnotherTagValue");

        final ConfigurationSetting newConfiguration
            = new ConfigurationSetting().setKey(getKey()).setValue("myNewValue").setContentType("text");

        testRunner.accept(newConfiguration);
        testRunner.accept(newConfiguration.setLabel(getLabel()).setTags(tags));
        return newConfiguration;
    }

    @Test
    public abstract void addFeatureFlagConfigurationSettingConvenience();

    void addFeatureFlagConfigurationSettingRunner(Consumer<FeatureFlagConfigurationSetting> testRunner) {
        testRunner.accept(getFeatureFlagConfigurationSetting(getKey(), "Feature Flag X"));
    }

    @Test
    public abstract void addSecretReferenceConfigurationSettingConvenience();

    void addSecretReferenceConfigurationSettingRunner(Consumer<SecretReferenceConfigurationSetting> testRunner) {
        testRunner.accept(new SecretReferenceConfigurationSetting(getKey(), "https://localhost"));
    }

    @Test
    public abstract void addConfigurationSettingEmptyKey();

    @Test
    public abstract void addConfigurationSettingEmptyValue();

    void addConfigurationSettingEmptyValueRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();
        ConfigurationSetting setting = new ConfigurationSetting().setKey(key);
        ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key + "-1").setValue("");

        testRunner.accept(setting);
        testRunner.accept(setting2);
    }

    @Test
    public abstract void addConfigurationSettingNullKey();

    @Test
    public abstract void addExistingSetting();

    void addExistingSettingRunner(Consumer<ConfigurationSetting> testRunner) {
        final ConfigurationSetting newConfiguration
            = new ConfigurationSetting().setKey(getKey()).setValue("myNewValue");

        testRunner.accept(newConfiguration);
        testRunner.accept(newConfiguration.setLabel(getLabel()));
    }

    @Test
    public abstract void setConfigurationSetting();

    @Test
    public abstract void setConfigurationSettingConvenience();

    void setConfigurationSettingRunner(BiConsumer<ConfigurationSetting, ConfigurationSetting> testRunner) {
        String key = getKey();
        String label = getLabel();

        final ConfigurationSetting setConfiguration = new ConfigurationSetting().setKey(key).setValue("myNewValue");
        final ConfigurationSetting updateConfiguration
            = new ConfigurationSetting().setKey(key).setValue("myUpdatedValue");

        testRunner.accept(setConfiguration, updateConfiguration);
        testRunner.accept(setConfiguration.setLabel(label), updateConfiguration.setLabel(label));
    }

    @Test
    public abstract void setFeatureFlagConfigurationSettingConvenience();

    void setFeatureFlagConfigurationSettingRunner(
        BiConsumer<FeatureFlagConfigurationSetting, FeatureFlagConfigurationSetting> testRunner) {
        String key = getKey();
        testRunner.accept(getFeatureFlagConfigurationSetting(key, "Feature Flag X"),
            getFeatureFlagConfigurationSetting(key, "new Feature Flag X"));
    }

    @Test
    public abstract void featureFlagConfigurationSettingUnknownAttributesArePreserved();

    void featureFlagConfigurationSettingUnknownAttributesArePreservedRunner(
        Consumer<FeatureFlagConfigurationSetting> testRunner) {
        String key = getKey();
        FeatureFlagConfigurationSetting featureFlagX = getFeatureFlagConfigurationSetting(key, "Feature Flag X");
        String valueWithAdditionalFieldAtFirstLayer = String.format(
            "{\"id\":\"%s\",\"k1\":\"v1\",\"description\":\"%s\",\"display_name\":\"%s\",\"enabled\":%s,"
                + "\"conditions\":{\"requirement_type\":\"All\",\"client_filters\":"
                + "[{\"name\":\"Microsoft.Percentage\",\"parameters\":{\"Value\":30}}]"
                + "},\"additional_field\":\"additional_value\"}",
            featureFlagX.getFeatureId(), featureFlagX.getDescription(), featureFlagX.getDisplayName(),
            featureFlagX.isEnabled());
        featureFlagX.setValue(valueWithAdditionalFieldAtFirstLayer);
        testRunner.accept(featureFlagX);
    }

    @Test
    public abstract void setSecretReferenceConfigurationSettingConvenience();

    void setSecretReferenceConfigurationSettingRunner(
        BiConsumer<SecretReferenceConfigurationSetting, SecretReferenceConfigurationSetting> testRunner) {
        String key = getKey();
        testRunner.accept(new SecretReferenceConfigurationSetting(key, "https://localhost"),
            new SecretReferenceConfigurationSetting(key, "https://localhost/100"));
    }

    @Test
    public abstract void secretReferenceConfigurationSettingUnknownAttributesArePreserved();

    void secretReferenceConfigurationSettingUnknownAttributesArePreservedRunner(
        Consumer<SecretReferenceConfigurationSetting> testRunner) {
        String key = getKey();
        String valueWithAdditionalFields
            = "{\"uri\":\"uriValue\",\"objectFiledName\":{\"unknown\":\"unknown\",\"unknown2\":\"unknown2\"},"
                + "\"arrayFieldName\":[{\"name\":\"Microsoft.Percentage\",\"parameters\":{\"Value\":30}}]}";

        testRunner.accept(new SecretReferenceConfigurationSetting(key, valueWithAdditionalFields));
    }

    @Test
    public abstract void setConfigurationSettingIfETag();

    void setConfigurationSettingIfETagRunner(BiConsumer<ConfigurationSetting, ConfigurationSetting> testRunner) {
        String key = getKey();
        String label = getLabel();

        final ConfigurationSetting newConfiguration = new ConfigurationSetting().setKey(key).setValue("myNewValue");
        final ConfigurationSetting updateConfiguration
            = new ConfigurationSetting().setKey(key).setValue("myUpdateValue");

        testRunner.accept(newConfiguration, updateConfiguration);
        testRunner.accept(newConfiguration.setLabel(label), updateConfiguration.setLabel(label));
    }

    @Test
    public abstract void setConfigurationSettingEmptyKey();

    @Test
    public abstract void setConfigurationSettingEmptyValue();

    void setConfigurationSettingEmptyValueRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();

        ConfigurationSetting setting = new ConfigurationSetting().setKey(key);
        ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key + "-1").setValue("");

        testRunner.accept(setting);
        testRunner.accept(setting2);
    }

    @Test
    public abstract void setConfigurationSettingNullKey();

    @Test
    public abstract void getConfigurationSetting();

    @Test
    public abstract void getConfigurationSettingConvenience();

    void getConfigurationSettingRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();

        final ConfigurationSetting newConfiguration = new ConfigurationSetting().setKey(key).setValue("myNewValue");

        testRunner.accept(newConfiguration);
        testRunner.accept(newConfiguration.setLabel("myLabel"));
    }

    @Test
    public abstract void getFeatureFlagConfigurationSettingConvenience();

    void getFeatureFlagConfigurationSettingRunner(Consumer<FeatureFlagConfigurationSetting> testRunner) {
        testRunner.accept(getFeatureFlagConfigurationSetting(getKey(), "Feature Flag X"));
    }

    @Test
    public abstract void getSecretReferenceConfigurationSettingConvenience();

    void getSecretReferenceConfigurationSettingRunner(Consumer<SecretReferenceConfigurationSetting> testRunner) {
        testRunner.accept(new SecretReferenceConfigurationSetting(getKey(), "https://localhost"));
    }

    @Test
    public abstract void getConfigurationSettingNotFound();

    @Test
    public abstract void deleteConfigurationSetting();

    @Test
    public abstract void deleteConfigurationSettingConvenience();

    void deleteConfigurationSettingRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();
        String label = getLabel();

        final ConfigurationSetting deletableConfiguration = new ConfigurationSetting().setKey(key).setValue("myValue");

        testRunner.accept(deletableConfiguration);
        testRunner.accept(deletableConfiguration.setLabel(label));
    }

    @Test
    public abstract void deleteFeatureFlagConfigurationSettingConvenience();

    void deleteFeatureFlagConfigurationSettingRunner(Consumer<FeatureFlagConfigurationSetting> testRunner) {
        testRunner.accept(getFeatureFlagConfigurationSetting(getKey(), "Feature Flag X"));
    }

    @Test
    public abstract void deleteSecretReferenceConfigurationSettingConvenience();

    void deleteSecretReferenceConfigurationSettingRunner(Consumer<SecretReferenceConfigurationSetting> testRunner) {
        testRunner.accept(new SecretReferenceConfigurationSetting(getKey(), "https://localhost"));
    }

    @Test
    public abstract void deleteConfigurationSettingNotFound();

    @Test
    public abstract void deleteConfigurationSettingWithETag();

    void deleteConfigurationSettingWithETagRunner(BiConsumer<ConfigurationSetting, ConfigurationSetting> testRunner) {
        String key = getKey();
        String label = getLabel();

        final ConfigurationSetting newConfiguration = new ConfigurationSetting().setKey(key).setValue("myNewValue");
        final ConfigurationSetting updateConfiguration
            = new ConfigurationSetting().setKey(newConfiguration.getKey()).setValue("myUpdateValue");

        testRunner.accept(newConfiguration, updateConfiguration);
        testRunner.accept(newConfiguration.setLabel(label), updateConfiguration.setLabel(label));
    }

    @Test
    public abstract void deleteConfigurationSettingNullKey();

    @Test
    public abstract void clearReadOnly();

    @Test
    public abstract void clearReadOnlyWithConfigurationSetting();

    @Test
    public abstract void clearReadOnlyWithConfigurationSettingConvenience();

    void lockUnlockRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();

        final ConfigurationSetting lockConfiguration = new ConfigurationSetting().setKey(key).setValue("myValue");
        testRunner.accept(lockConfiguration);
    }

    @Test
    public abstract void clearReadOnlyWithFeatureFlagConfigurationSettingConvenience();

    void lockUnlockFeatureFlagRunner(Consumer<FeatureFlagConfigurationSetting> testRunner) {
        testRunner.accept(getFeatureFlagConfigurationSetting(getKey(), "Feature Flag X"));
    }

    @Test
    public abstract void clearReadOnlyWithSecretReferenceConfigurationSettingConvenience();

    void lockUnlockSecretReferenceRunner(Consumer<SecretReferenceConfigurationSetting> testRunner) {
        testRunner.accept(new SecretReferenceConfigurationSetting(getKey(), "https://localhost"));
    }

    @Test
    public abstract void listWithKeyAndLabel();

    @Test
    public abstract void listWithMultipleKeys();

    @Test
    public abstract void listConfigurationSettingsWithNullSelector();

    void listWithMultipleKeysRunner(String key, String key2,
        BiFunction<ConfigurationSetting, ConfigurationSetting, Iterable<ConfigurationSetting>> testRunner) {
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value");
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key2).setValue("value");
        final Set<ConfigurationSetting> expectedSelection = new HashSet<>(Arrays.asList(setting, setting2));
        testRunner.apply(setting, setting2)
            .forEach(
                actual -> expectedSelection.removeIf(expected -> equals(expected, cleanResponse(expected, actual))));
        assertTrue(expectedSelection.isEmpty());
    }

    @Test
    public abstract void listWithMultipleLabels();

    void listWithMultipleLabelsRunner(String key, String label, String label2,
        BiFunction<ConfigurationSetting, ConfigurationSetting, Iterable<ConfigurationSetting>> testRunner) {
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label);
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label2);
        final Set<ConfigurationSetting> expectedSelection = new HashSet<>(Arrays.asList(setting, setting2));

        for (ConfigurationSetting actual : testRunner.apply(setting, setting2)) {
            expectedSelection.removeIf(expected -> equals(expected, cleanResponse(expected, actual)));
        }

        assertTrue(expectedSelection.isEmpty());
    }

    @Test
    public abstract void listConfigurationSettingsSelectFields();

    void listConfigurationSettingsSelectFieldsRunner(
        BiFunction<List<ConfigurationSetting>, SettingSelector, Iterable<ConfigurationSetting>> testRunner) {
        final String label = "my-first-mylabel";
        final String label2 = "my-second-mylabel";
        final int numberToCreate = 8;
        final Map<String, String> tags = new HashMap<>();
        tags.put("tag1", "value1");
        tags.put("tag2", "value2");

        final SettingSelector selector = new SettingSelector().setLabelFilter("my-second*")
            .setKeyFilter(keyPrefix + "-fetch-*")
            .setFields(SettingFields.KEY, SettingFields.ETAG, SettingFields.CONTENT_TYPE, SettingFields.TAGS);

        List<ConfigurationSetting> settings = new ArrayList<>(numberToCreate);
        for (int value = 0; value < numberToCreate; value++) {
            String key = value % 2 == 0 ? keyPrefix + "-" + value : keyPrefix + "-fetch-" + value;
            String lbl = value / 4 == 0 ? label : label2;
            settings.add(new ConfigurationSetting().setKey(key).setValue("myValue2").setLabel(lbl).setTags(tags));
        }

        for (ConfigurationSetting setting : testRunner.apply(settings, selector)) {
            assertNotNull(setting.getETag());
            assertNotNull(setting.getKey());
            assertTrue(setting.getKey().contains(keyPrefix));
            assertNotNull(setting.getTags());
            assertEquals(tags.size(), setting.getTags().size());

            assertNull(setting.getLastModified());
            assertNull(setting.getContentType());
            assertNull(setting.getLabel());
        }
    }

    @Test
    public abstract void listConfigurationSettingsSelectFieldsWithPrefixStarKeyFilter();

    @Test
    public abstract void listConfigurationSettingsSelectFieldsWithSubstringKeyFilter();

    @Test
    public abstract void listConfigurationSettingsSelectFieldsWithPrefixStarLabelFilter();

    @Test
    public abstract void listConfigurationSettingsSelectFieldsWithSubstringLabelFilter();

    void listConfigurationSettingsSelectFieldsWithNotSupportedFilterRunner(String keyFilter, String labelFilter,
        Consumer<SettingSelector> testRunner) {
        final Map<String, String> tags = new HashMap<>();
        tags.put("tag1", "value1");
        tags.put("tag2", "value2");

        final SettingSelector selector = new SettingSelector().setKeyFilter(keyFilter)
            .setLabelFilter(labelFilter)
            .setFields(SettingFields.KEY, SettingFields.ETAG, SettingFields.CONTENT_TYPE, SettingFields.TAGS);
        testRunner.accept(selector);
    }

    @Test
    public abstract void listConfigurationSettingsAcceptDateTime();

    @Test
    public abstract void listRevisions();

    static void validateListRevisions(ConfigurationSetting expected, ConfigurationSetting actual) {
        assertEquals(expected.getKey(), actual.getKey());
        assertNotNull(actual.getETag());
        assertNull(actual.getValue());
        assertNull(actual.getLastModified());
    }

    @Test
    public abstract void listRevisionsWithMultipleKeys();

    void listRevisionsWithMultipleKeysRunner(String key, String key2,
        Function<List<ConfigurationSetting>, Iterable<ConfigurationSetting>> testRunner) {
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value");
        final ConfigurationSetting settingUpdate
            = new ConfigurationSetting().setKey(setting.getKey()).setValue("updatedValue");
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key2).setValue("value");
        final ConfigurationSetting setting2Update
            = new ConfigurationSetting().setKey(setting2.getKey()).setValue("updatedValue");
        final List<ConfigurationSetting> testInput = Arrays.asList(setting, settingUpdate, setting2, setting2Update);
        final Set<ConfigurationSetting> expectedSelection = new HashSet<>(testInput);

        for (ConfigurationSetting actual : testRunner.apply(testInput)) {
            expectedSelection.removeIf(expected -> equals(expected, cleanResponse(expected, actual)));
        }

        assertTrue(expectedSelection.isEmpty());
    }

    @Test
    public abstract void listRevisionsWithMultipleLabels();

    void listRevisionsWithMultipleLabelsRunner(String key, String label, String label2,
        Function<List<ConfigurationSetting>, Iterable<ConfigurationSetting>> testRunner) {
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label);
        final ConfigurationSetting settingUpdate
            = new ConfigurationSetting().setKey(setting.getKey()).setLabel(setting.getLabel()).setValue("updatedValue");
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label2);
        final ConfigurationSetting setting2Update = new ConfigurationSetting().setKey(setting2.getKey())
            .setLabel(setting2.getLabel())
            .setValue("updatedValue");
        final List<ConfigurationSetting> testInput = Arrays.asList(setting, settingUpdate, setting2, setting2Update);
        final Set<ConfigurationSetting> expectedSelection = new HashSet<>(testInput);

        for (ConfigurationSetting actual : testRunner.apply(testInput)) {
            expectedSelection.removeIf(expected -> equals(expected, cleanResponse(expected, actual)));
        }

        assertTrue(expectedSelection.isEmpty());
    }

    @Test
    public abstract void listRevisionsAcceptDateTime();

    @Test
    public abstract void listRevisionsWithPagination();

    @Test
    public abstract void listConfigurationSettingsWithPagination();

    @Test
    public abstract void listRevisionsWithPaginationAndRepeatStream();

    @Test
    public abstract void listRevisionsWithPaginationAndRepeatIterator();

    @Test
    public abstract void getConfigurationSettingWhenValueNotUpdated();

    @Disabled("This test exists to clean up resources missed due to 429s.")
    @Test
    public abstract void deleteAllSettings();

    @Test
    public abstract void addHeadersFromContextPolicyTest();

    void addHeadersFromContextPolicyRunner(Consumer<ConfigurationSetting> testRunner) {
        final String key = getKey();
        final String value = "newValue";

        final ConfigurationSetting newConfiguration = new ConfigurationSetting().setKey(key).setValue(value);
        testRunner.accept(newConfiguration);
    }

    @Test
    public abstract void createSnapshot();

    void createSnapshotRunner(BiConsumer<String, List<ConfigurationSettingsFilter>> testRunner) {
        String snapshotName = getKey();
        List<ConfigurationSettingsFilter> filters = new ArrayList<>();
        filters.add(new ConfigurationSettingsFilter(snapshotName + "-*"));
        testRunner.accept(snapshotName, filters);
    }

    @Test
    public abstract void getSnapshot();

    @Test
    public abstract void getSnapshotConvenience();

    @Test
    public abstract void archiveSnapshot();

    @Test
    public abstract void archiveSnapshotConvenience();

    @Test
    public abstract void recoverSnapshot();

    @Test
    public abstract void recoverSnapshotConvenience();

    @Test
    public abstract void listSnapshots();

    @Test
    public abstract void listSnapshotsWithFields();

    @Test
    public abstract void listSettingFromSnapshot();

    @Test
    public abstract void listSettingFromSnapshotWithFields();

    @Test
    public abstract void listSettingsWithPageETag();

    @Test
    public abstract void listLabels();

    List<ConfigurationSetting> listLabelsRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();
        String label = getLabel();
        String label2 = getLabel();
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label);
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key).setValue("value").setLabel(label2);
        testRunner.accept(setting);
        testRunner.accept(setting2);
        List<ConfigurationSetting> result = new ArrayList<>();
        result.add(setting);
        result.add(setting2);
        return result;
    }

    @Test
    public abstract void listSettingByTagsFilter();

    List<ConfigurationSetting> listSettingByTagsFilterRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();
        String key2 = getKey();
        Map<String, String> tags = new HashMap<>();
        tags.put(key, "tagValue");
        Map<String, String> tags2 = new HashMap<>();
        tags2.put(key, "tagValue");
        tags2.put(key2, "tagValue");
        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value").setTags(tags);
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key2).setValue("value").setTags(tags2);

        testRunner.accept(setting);
        testRunner.accept(setting2);

        List<ConfigurationSetting> result = new ArrayList<>();
        result.add(setting);
        result.add(setting2);
        return result;
    }

    @Test
    public abstract void listRevisionsWithTagsFilter();

    List<ConfigurationSetting> listRevisionsWithTagsFilterRunner(Consumer<ConfigurationSetting> testRunner) {
        final String keyName = getKey();
        final Map<String, String> tags = new HashMap<>();
        tags.put("MyTag", "TagValue");
        tags.put("AnotherTag", "AnotherTagValue");

        final ConfigurationSetting original
            = new ConfigurationSetting().setKey(keyName).setValue("myValue").setTags(tags);
        final ConfigurationSetting updated
            = new ConfigurationSetting().setKey(original.getKey()).setValue("anotherValue");
        final ConfigurationSetting updated2
            = new ConfigurationSetting().setKey(original.getKey()).setValue("anotherValue2");

        testRunner.accept(original);
        testRunner.accept(updated);
        testRunner.accept(updated2);

        List<ConfigurationSetting> result = new ArrayList<>();
        result.add(original);
        result.add(updated);
        result.add(updated2);
        return result;
    }

    @Test
    public abstract void createSnapshotWithTagsFilter();

    List<ConfigurationSetting> createSnapshotWithTagsFilterPrepareRunner(Consumer<ConfigurationSetting> testRunner) {
        String key = getKey();
        String key2 = getKey();
        Map<String, String> tags = new HashMap<>();
        tags.put("MyTag", "TagValue");
        tags.put("AnotherTag", "AnotherTagValue");

        final ConfigurationSetting setting = new ConfigurationSetting().setKey(key).setValue("value");
        final ConfigurationSetting setting2 = new ConfigurationSetting().setKey(key2).setValue("value").setTags(tags);

        testRunner.accept(setting);
        testRunner.accept(setting2);

        List<ConfigurationSetting> result = new ArrayList<>();
        result.add(setting);
        result.add(setting2);
        return result;
    }

    void createSnapshotWithTagsFilterRunner(BiConsumer<String, List<ConfigurationSettingsFilter>> testRunner) {
        String snapshotName = getKey();
        List<String> tagsFilter = new ArrayList<>();
        tagsFilter.add("MyTag=TagValue");
        tagsFilter.add("AnotherTag=AnotherTagValue");

        List<ConfigurationSettingsFilter> filters = new ArrayList<>();
        filters.add(new ConfigurationSettingsFilter(KEY_PREFIX + "*").setTags(tagsFilter));
        testRunner.accept(snapshotName, filters);
    }

    /**
     * Helper method to verify that the RestResponse matches what was expected. This method assumes a response status of 200.
     *
     * @param expected ConfigurationSetting expected to be returned by the service
     * @param response RestResponse returned by the service, the body should contain a ConfigurationSetting
     */
    static void assertConfigurationEquals(ConfigurationSetting expected, Response<ConfigurationSetting> response) {
        assertConfigurationEquals(expected, response, 200);
    }

    static void assertFeatureFlagConfigurationSettingEquals(FeatureFlagConfigurationSetting expected,
        FeatureFlagConfigurationSetting actual) {
        assertEquals(expected.getFeatureId(), actual.getFeatureId());
        assertEquals(expected.getDisplayName(), actual.getDisplayName());
        assertEquals(expected.getDescription(), actual.getDescription());

        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    static void assertSecretReferenceConfigurationSettingEquals(SecretReferenceConfigurationSetting expected,
        SecretReferenceConfigurationSetting actual) {
        assertEquals(expected.getSecretId(), actual.getSecretId());
        assertEquals(expected.getKey(), actual.getKey());
        assertEquals(expected.getValue(), actual.getValue());
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    /**
     * Helper method to verify that the RestResponse matches what was expected.
     *
     * @param expected ConfigurationSetting expected to be returned by the service
     * @param response RestResponse returned from the service, the body should contain a ConfigurationSetting
     * @param expectedStatusCode Expected HTTP status code returned by the service
     */
    static void assertConfigurationEquals(ConfigurationSetting expected, Response<ConfigurationSetting> response,
        final int expectedStatusCode) {
        assertNotNull(response);
        assertConfigurationEquals(expected, response.getValue());
    }

    /**
     * Helper method to verify that the returned ConfigurationSetting matches what was expected.
     *
     * @param expected ConfigurationSetting expected to be returned by the service
     * @param actual ConfigurationSetting contained in the RestResponse body
     */
    static void assertConfigurationEquals(ConfigurationSetting expected, ConfigurationSetting actual) {
        if (expected != null && actual != null) {
            actual = cleanResponse(expected, actual);
        } else if (expected == actual) {
            return;
        } else if (expected == null || actual == null) {
            assertFalse(true, "One of input settings is null");
        }

        equals(expected, actual);
    }

    /**
     * The ConfigurationSetting has some fields that are only manipulated by the service,
     * this helper method cleans those fields on the setting returned by the service so tests are able to pass.
     * @param expected ConfigurationSetting expected to be returned by the service.
     * @param actual ConfigurationSetting returned by the service.
     */
    private static ConfigurationSetting cleanResponse(ConfigurationSetting expected, ConfigurationSetting actual) {
        ConfigurationSetting cleanedActual = new ConfigurationSetting().setKey(actual.getKey())
            .setLabel(actual.getLabel())
            .setValue(actual.getValue())
            .setTags(actual.getTags())
            .setContentType(actual.getContentType())
            .setETag(expected.getETag());

        ConfigurationSettingHelper.setLastModified(actual, expected.getLastModified());

        if (ConfigurationSetting.NO_LABEL.equals(expected.getLabel()) && actual.getLabel() == null) {
            cleanedActual.setLabel(ConfigurationSetting.NO_LABEL);
        }

        return cleanedActual;
    }

    static void assertRestException(Runnable exceptionThrower, int expectedStatusCode) {
        assertRestException(exceptionThrower, HttpResponseException.class, expectedStatusCode);
    }

    static void assertRestException(Runnable exceptionThrower,
        Class<? extends HttpResponseException> expectedExceptionType, int expectedStatusCode) {
        try {
            exceptionThrower.run();
            fail();
        } catch (Throwable ex) {
            assertRestException(ex, expectedExceptionType, expectedStatusCode);
        }
    }

    /**
     * Helper method to verify the error was a HttpResponseException and it has a specific HTTP response code.
     *
     * @param exception Expected error thrown during the test
     * @param expectedStatusCode Expected HTTP status code contained in the error response
     */
    static void assertRestException(Throwable exception, int expectedStatusCode) {
        assertRestException(exception, HttpResponseException.class, expectedStatusCode);
    }

    static void assertRestException(Throwable exception, Class<? extends HttpResponseException> expectedExceptionType,
        int expectedStatusCode) {
        assertEquals(expectedExceptionType, exception.getClass());
        assertEquals(expectedStatusCode, ((HttpResponseException) exception).getResponse().getStatusCode());
    }

    /**
     * Helper method to verify that a command throws an IllegalArgumentException.
     *
     * @param exceptionThrower Command that should throw the exception
     */
    static <T> void assertRunnableThrowsException(Runnable exceptionThrower, Class<T> exception) {
        try {
            exceptionThrower.run();
            fail();
        } catch (Exception ex) {
            assertEquals(exception, ex.getClass());
        }
    }

    /**
     * Helper method to verify that two configuration setting are equal. Users can defined their equal method.
     *
     * @param o1 ConfigurationSetting object 1
     * @param o2 ConfigurationSetting object 2
     * @return boolean value that defines if two ConfigurationSettings are equal
     */
    static boolean equals(ConfigurationSetting o1, ConfigurationSetting o2) {
        if (o1 == o2) {
            return true;
        }

        if (!Objects.equals(o1.getKey(), o2.getKey())
            || !Objects.equals(o1.getLabel(), o2.getLabel())
            || !Objects.equals(o1.getValue(), o2.getValue())
            || !Objects.equals(o1.getETag(), o2.getETag())
            || !Objects.equals(o1.getLastModified(), o2.getLastModified())
            || !Objects.equals(o1.isReadOnly(), o2.isReadOnly())
            || !Objects.equals(o1.getContentType(), o2.getContentType())
            || CoreUtils.isNullOrEmpty(o1.getTags()) != CoreUtils.isNullOrEmpty(o2.getTags())) {
            return false;
        }

        if (!CoreUtils.isNullOrEmpty(o1.getTags())) {
            return Objects.equals(o1.getTags(), o2.getTags());
        }

        return true;
    }

    /**
     * A helper method to verify that two lists of ConfigurationSetting are equal each other.
     *
     * @param settings1 List of ConfigurationSetting
     * @param settings2 Another List of ConfigurationSetting
     * @return boolean value that defines if two ConfigurationSetting lists are equal
     */
    static boolean equalsArray(List<ConfigurationSetting> settings1, List<ConfigurationSetting> settings2) {
        if (settings1 == settings2) {
            return true;
        }

        if (settings1 == null || settings2 == null) {
            return false;
        }

        if (settings1.size() != settings2.size()) {
            return false;
        }

        final int size = settings1.size();
        for (int i = 0; i < size; i++) {
            if (!equals(settings1.get(i), settings2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method that sets up HttpHeaders
     *
     * @return the http headers
     */
    static HttpHeaders getCustomizedHeaders() {
        final String headerOne = "my-header1";
        final String headerTwo = "my-header2";
        final String headerThree = "my-header3";

        final String headerOneValue = "my-header1-value";
        final String headerTwoValue = "my-header2-value";
        final String headerThreeValue = "my-header3-value";

        final HttpHeaders headers = new HttpHeaders();
        headers.put(headerOne, headerOneValue);
        headers.put(headerTwo, headerTwoValue);
        headers.put(headerThree, headerThreeValue);

        return headers;
    }

    /**
     * Helper method that check if the {@code headerContainer} contains {@code headers}.
     *
     * @param headers the headers that been checked
     * @param headerContainer The headers container that check if the {@code headers} exist in it.
     */
    static void assertContainsHeaders(HttpHeaders headers, HttpHeaders headerContainer) {
        headers.stream()
            .forEach(httpHeader -> assertEquals(headerContainer.getValue(httpHeader.getName()), httpHeader.getValue()));
    }

    private String getFeatureFlagConfigurationSettingValue(String key) {
        return "{\"id\":\"" + key + "\",\"description\":null,\"display_name\":\"Feature Flag X\""
            + ",\"enabled\":false,\"conditions\":{\"client_filters\":[{\"name\":"
            + "\"Microsoft.Percentage\",\"parameters\":{\"Value\":30}}]}}";
    }

    private FeatureFlagConfigurationSetting getFeatureFlagConfigurationSetting(String key, String displayName) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Value", 30);
        final List<FeatureFlagFilter> filters = new ArrayList<>();
        filters.add(new FeatureFlagFilter("Microsoft.Percentage").setParameters(parameters));

        return new FeatureFlagConfigurationSetting(key, false).setDisplayName(displayName)
            .setClientFilters(filters)
            .setValue(getFeatureFlagConfigurationSettingValue(key));
    }

    void assertConfigurationSnapshotWithResponse(int expectedStatusCode, String name,
        ConfigurationSnapshotStatus snapshotStatus, List<ConfigurationSettingsFilter> filters,
        SnapshotComposition snapshotComposition, Duration retentionPeriod, Long size, Long itemCount,
        Map<String, String> tags, Response<ConfigurationSnapshot> response) {
        assertNotNull(response);
        assertEquals(expectedStatusCode, response.getStatusCode());

        assertEqualsConfigurationSnapshot(name, snapshotStatus, filters, snapshotComposition, retentionPeriod, size,
            itemCount, tags, response.getValue());
    }

    void assertEqualsConfigurationSnapshot(String name, ConfigurationSnapshotStatus snapshotStatus,
        List<ConfigurationSettingsFilter> filters, SnapshotComposition snapshotComposition, Duration retentionPeriod,
        Long size, Long itemCount, Map<String, String> tags, ConfigurationSnapshot actualSnapshot) {
        assertEquals(name, actualSnapshot.getName());
        assertEquals(snapshotStatus, actualSnapshot.getStatus());
        assertEqualsSnapshotFilters(filters, actualSnapshot.getFilters());
        assertEquals(snapshotComposition, actualSnapshot.getSnapshotComposition());
        assertEquals(retentionPeriod, actualSnapshot.getRetentionPeriod());
        assertNotNull(actualSnapshot.getCreatedAt());
        assertEquals(itemCount, actualSnapshot.getItemCount());
        assertNotNull(actualSnapshot.getSizeInBytes());
        assertNotNull(actualSnapshot.getETag());

        if (!CoreUtils.isNullOrEmpty(tags)) {
            assertEquals(tags, actualSnapshot.getTags());
        }
    }

    void assertEqualsSnapshotFilters(List<ConfigurationSettingsFilter> o1, List<ConfigurationSettingsFilter> o2) {
        if (o1 == o2) {
            return;
        }
        assertEquals(o1.size(), o2.size());
        for (int i = 0; i < o1.size(); i++) {
            ConfigurationSettingsFilter expectedFilter = o1.get(i);
            ConfigurationSettingsFilter actualFilter = o2.get(i);
            assertEquals(expectedFilter.getKey(), actualFilter.getKey());
            assertEquals(expectedFilter.getLabel(), actualFilter.getLabel());
        }
    }
}
