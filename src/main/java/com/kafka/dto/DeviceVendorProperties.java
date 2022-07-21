package com.kafka.dto;

import java.io.Serializable;
import java.util.Objects;

public class DeviceVendorProperties implements Serializable {

    private static final long serialVersionUID = 6345471429486164502L;

    private String description;

    private String location;

    private String name;

    private String timezone;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone the timezone to set
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, location, name, timezone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeviceVendorProperties other = (DeviceVendorProperties) obj;
        return Objects.equals(description, other.description) && Objects.equals(location, other.location)
                && Objects.equals(name, other.name) && Objects.equals(timezone, other.timezone);
    }

}
