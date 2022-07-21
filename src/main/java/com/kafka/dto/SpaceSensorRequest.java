package com.kafka.dto;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @type: SensorRequest
 * @description:
 *
 * @author: sgogineni
 * @version: 1.0
 * @created: Feb 13, 2020
 */
@Validated
public class SpaceSensorRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("hardwareId")
    private String hardwareId = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("sensorType")
    private String sensorType = null;

    @JsonProperty("sensorZoneId")
    private String sensorZoneId = null;

    @JsonProperty("vendor")
    private String vendor = null;

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorZoneId() {
        return sensorZoneId;
    }

    public void setSensorZoneId(String sensorZoneId) {
        this.sensorZoneId = sensorZoneId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpaceSensorRequest spaceSensorRequest = (SpaceSensorRequest) o;
        return Objects.equals(hardwareId, spaceSensorRequest.hardwareId) && Objects.equals(id, spaceSensorRequest.id)
                && Objects.equals(sensorType, spaceSensorRequest.sensorType)
                && Objects.equals(sensorZoneId, spaceSensorRequest.sensorZoneId)
                && Objects.equals(vendor, spaceSensorRequest.vendor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hardwareId, id, sensorType, sensorZoneId, vendor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpaceSensorRequest {\n");

        sb.append("    hardwareId: ").append(toIndentedString(hardwareId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    sensorType: ").append(toIndentedString(sensorType)).append("\n");
        sb.append("    sensorZoneId: ").append(toIndentedString(sensorZoneId)).append("\n");
        sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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
