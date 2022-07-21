package com.kafka.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @type: DeviceRequest
 * @description:
 *
 * @author: sgogineni
 * @version: 1.0
 * @created: Feb 27, 2020
 */
@Validated
public class SpaceDeviceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("deviceType")
    private String deviceType = null;

    @JsonProperty("deviceVendor")
    private String deviceVendor = null;

    @JsonProperty("deviceZoneId")
    private String deviceZoneId = null;

    @JsonProperty("hardwareId")
    private String hardwareId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("sensors")
    @Valid
    private List<SpaceSensorRequest> sensors = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("deviceVendorProperties")
    private DeviceVendorProperties deviceVendorProperties;

    @JsonProperty("spaceId")
    private String spaceId;

    @JsonProperty("spaceType")
    private String spaceType;

    @JsonProperty("floorId")
    private String floorId;

    @JsonProperty("buildingId")
    private String buildingId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("parentSpaceId")
    private String parentSpaceId;

    public DeviceVendorProperties getDeviceVendorProperties() {
        return deviceVendorProperties;
    }

    public void setDeviceVendorProperties(DeviceVendorProperties deviceVendorProperties) {
        this.deviceVendorProperties = deviceVendorProperties;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceVendor() {
        return deviceVendor;
    }

    public void setDeviceVendor(String deviceVendor) {
        this.deviceVendor = deviceVendor;
    }

    public String getDeviceZoneId() {
        return deviceZoneId;
    }

    public void setDeviceZoneId(String deviceZoneId) {
        this.deviceZoneId = deviceZoneId;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Valid
    public List<SpaceSensorRequest> getSensors() {
        return sensors;
    }

    public void setSensors(List<SpaceSensorRequest> sensors) {
        this.sensors = sensors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getParentSpaceId() {
        return parentSpaceId;
    }

    public void setParentSpaceId(String parentSpaceId) {
        this.parentSpaceId = parentSpaceId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpaceDeviceRequest spaceDeviceRequest = (SpaceDeviceRequest) o;
        return Objects.equals(description, spaceDeviceRequest.description)
                && Objects.equals(deviceType, spaceDeviceRequest.deviceType)
                && Objects.equals(deviceVendor, spaceDeviceRequest.deviceVendor)
                && Objects.equals(deviceZoneId, spaceDeviceRequest.deviceZoneId)
                && Objects.equals(deviceVendorProperties, spaceDeviceRequest.deviceVendorProperties)
                && Objects.equals(hardwareId, spaceDeviceRequest.hardwareId)
                && Objects.equals(name, spaceDeviceRequest.name) && Objects.equals(sensors, spaceDeviceRequest.sensors)
                && Objects.equals(status, spaceDeviceRequest.status)
                && Objects.equals(spaceId, spaceDeviceRequest.spaceId)
                && Objects.equals(spaceType, spaceDeviceRequest.spaceType)
                && Objects.equals(floorId, spaceDeviceRequest.floorId)
                && Objects.equals(customerId, spaceDeviceRequest.customerId)
                && Objects.equals(buildingId, spaceDeviceRequest.buildingId)
                && Objects.equals(parentSpaceId, spaceDeviceRequest.parentSpaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, deviceType, deviceVendor, deviceZoneId, deviceVendorProperties, hardwareId,
                name, sensors, status, spaceId, spaceType, floorId, customerId, buildingId, parentSpaceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpaceDeviceRequest {\n");

        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
        sb.append("    deviceVendor: ").append(toIndentedString(deviceVendor)).append("\n");
        sb.append("    deviceZoneId: ").append(toIndentedString(deviceZoneId)).append("\n");
        sb.append("    deviceVendorProperties: ").append(toIndentedString(deviceVendorProperties)).append("\n");
        sb.append("    hardwareId: ").append(toIndentedString(hardwareId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sensors: ").append(toIndentedString(sensors)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    spaceType: ").append(toIndentedString(spaceType)).append("\n");
        sb.append("    floorId: ").append(toIndentedString(floorId)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    buildingId: ").append(toIndentedString(buildingId)).append("\n");
        sb.append("    parentSpaceId: ").append(toIndentedString(parentSpaceId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
