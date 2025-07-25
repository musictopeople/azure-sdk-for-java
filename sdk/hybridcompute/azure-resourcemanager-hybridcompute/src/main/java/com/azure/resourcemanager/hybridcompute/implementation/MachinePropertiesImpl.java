// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.implementation;

import com.azure.core.management.exception.ManagementError;
import com.azure.resourcemanager.hybridcompute.fluent.models.LicenseProfileMachineInstanceViewInner;
import com.azure.resourcemanager.hybridcompute.fluent.models.MachinePropertiesInner;
import com.azure.resourcemanager.hybridcompute.fluent.models.NetworkProfileInner;
import com.azure.resourcemanager.hybridcompute.models.AgentConfiguration;
import com.azure.resourcemanager.hybridcompute.models.AgentUpgrade;
import com.azure.resourcemanager.hybridcompute.models.CloudMetadata;
import com.azure.resourcemanager.hybridcompute.models.FirmwareProfile;
import com.azure.resourcemanager.hybridcompute.models.HardwareProfile;
import com.azure.resourcemanager.hybridcompute.models.IdentityKeyStore;
import com.azure.resourcemanager.hybridcompute.models.LicenseProfileMachineInstanceView;
import com.azure.resourcemanager.hybridcompute.models.LocationData;
import com.azure.resourcemanager.hybridcompute.models.MachineExtensionInstanceView;
import com.azure.resourcemanager.hybridcompute.models.MachineProperties;
import com.azure.resourcemanager.hybridcompute.models.NetworkProfile;
import com.azure.resourcemanager.hybridcompute.models.OSProfile;
import com.azure.resourcemanager.hybridcompute.models.ServiceStatuses;
import com.azure.resourcemanager.hybridcompute.models.StatusTypes;
import com.azure.resourcemanager.hybridcompute.models.StorageProfile;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MachinePropertiesImpl implements MachineProperties {
    private MachinePropertiesInner innerObject;

    private final com.azure.resourcemanager.hybridcompute.HybridComputeManager serviceManager;

    MachinePropertiesImpl(MachinePropertiesInner innerObject,
        com.azure.resourcemanager.hybridcompute.HybridComputeManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public LocationData locationData() {
        return this.innerModel().locationData();
    }

    public AgentConfiguration agentConfiguration() {
        return this.innerModel().agentConfiguration();
    }

    public ServiceStatuses serviceStatuses() {
        return this.innerModel().serviceStatuses();
    }

    public HardwareProfile hardwareProfile() {
        return this.innerModel().hardwareProfile();
    }

    public StorageProfile storageProfile() {
        return this.innerModel().storageProfile();
    }

    public FirmwareProfile firmwareProfile() {
        return this.innerModel().firmwareProfile();
    }

    public CloudMetadata cloudMetadata() {
        return this.innerModel().cloudMetadata();
    }

    public AgentUpgrade agentUpgrade() {
        return this.innerModel().agentUpgrade();
    }

    public OSProfile osProfile() {
        return this.innerModel().osProfile();
    }

    public LicenseProfileMachineInstanceView licenseProfile() {
        LicenseProfileMachineInstanceViewInner inner = this.innerModel().licenseProfile();
        if (inner != null) {
            return new LicenseProfileMachineInstanceViewImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public String provisioningState() {
        return this.innerModel().provisioningState();
    }

    public StatusTypes status() {
        return this.innerModel().status();
    }

    public OffsetDateTime lastStatusChange() {
        return this.innerModel().lastStatusChange();
    }

    public List<ManagementError> errorDetails() {
        List<ManagementError> inner = this.innerModel().errorDetails();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String agentVersion() {
        return this.innerModel().agentVersion();
    }

    public UUID vmId() {
        return this.innerModel().vmId();
    }

    public String displayName() {
        return this.innerModel().displayName();
    }

    public String machineFqdn() {
        return this.innerModel().machineFqdn();
    }

    public String clientPublicKey() {
        return this.innerModel().clientPublicKey();
    }

    public IdentityKeyStore identityKeyStore() {
        return this.innerModel().identityKeyStore();
    }

    public String tpmEkCertificate() {
        return this.innerModel().tpmEkCertificate();
    }

    public String osName() {
        return this.innerModel().osName();
    }

    public String osVersion() {
        return this.innerModel().osVersion();
    }

    public String osType() {
        return this.innerModel().osType();
    }

    public UUID vmUuid() {
        return this.innerModel().vmUuid();
    }

    public List<MachineExtensionInstanceView> extensions() {
        List<MachineExtensionInstanceView> inner = this.innerModel().extensions();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public String osSku() {
        return this.innerModel().osSku();
    }

    public String osEdition() {
        return this.innerModel().osEdition();
    }

    public String domainName() {
        return this.innerModel().domainName();
    }

    public String adFqdn() {
        return this.innerModel().adFqdn();
    }

    public String dnsFqdn() {
        return this.innerModel().dnsFqdn();
    }

    public String privateLinkScopeResourceId() {
        return this.innerModel().privateLinkScopeResourceId();
    }

    public String parentClusterResourceId() {
        return this.innerModel().parentClusterResourceId();
    }

    public String hardwareResourceId() {
        return this.innerModel().hardwareResourceId();
    }

    public String mssqlDiscovered() {
        return this.innerModel().mssqlDiscovered();
    }

    public Map<String, String> detectedProperties() {
        Map<String, String> inner = this.innerModel().detectedProperties();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public NetworkProfile networkProfile() {
        NetworkProfileInner inner = this.innerModel().networkProfile();
        if (inner != null) {
            return new NetworkProfileImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public MachinePropertiesInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.hybridcompute.HybridComputeManager manager() {
        return this.serviceManager;
    }
}
