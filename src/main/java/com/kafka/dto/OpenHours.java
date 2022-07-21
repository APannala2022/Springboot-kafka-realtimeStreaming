package com.kafka.dto;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @type: OpenHours
 * @description:
 *
 * @author: sgogineni
 * @version: 1.0
 * @created: Feb 13, 2020
 */
@Validated
public class OpenHours implements Serializable {

    private static final long serialVersionUID = 7585169963274536694L;

    @JsonProperty("closeHours")
    private String closeHours = null;

    @JsonProperty("closeMinutes")
    private String closeMinutes = null;

    @JsonProperty("day")
    private String day = null;

    @JsonProperty("dayIndex")
    private String dayIndex = null;

    @JsonProperty("isOpen")
    private Boolean isOpen = false;

    @JsonProperty("openHours")
    private String openHours = null;

    @JsonProperty("openMinutes")
    private String openMinutes = null;

    public String getCloseHours() {
        return closeHours;
    }

    public void setCloseHours(String closeHours) {
        this.closeHours = closeHours;
    }

    public String getCloseMinutes() {
        return closeMinutes;
    }

    public void setCloseMinutes(String closeMinutes) {
        this.closeMinutes = closeMinutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(String dayIndex) {
        this.dayIndex = dayIndex;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getOpenMinutes() {
        return openMinutes;
    }

    public void setOpenMinutes(String openMinutes) {
        this.openMinutes = openMinutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(closeHours, closeMinutes, dayIndex, isOpen, openHours, openMinutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OpenHours other = (OpenHours) obj;
        return Objects.equals(closeHours, other.closeHours) && Objects.equals(closeMinutes, other.closeMinutes)
                && Objects.equals(dayIndex, other.dayIndex) && Objects.equals(isOpen, other.isOpen)
                && Objects.equals(openHours, other.openHours) && Objects.equals(openMinutes, other.openMinutes);
    }

    @Override
    public String toString() {
        return "OpenHours [closeHours=" + closeHours + ", closeMinutes=" + closeMinutes + ", dayIndex=" + dayIndex
                + ", isOpen=" + isOpen + ", openHours=" + openHours + ", openMinutes=" + openMinutes + "]";
    }

}
