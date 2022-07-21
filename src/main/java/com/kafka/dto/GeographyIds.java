package com.kafka.dto;

import java.util.Objects;

public class GeographyIds {

    private String regionSpaceId;

    private String countrySpaceId;

    private String stateSpaceId;

    private String neighborhoodSpaceId;

    private String campusSpaceId;

    public String getCampusSpaceId() {
        return campusSpaceId;
    }

    public void setCampusSpaceId(String campusSpaceId) {
        this.campusSpaceId = campusSpaceId;
    }

    public String getRegionSpaceId() {
        return regionSpaceId;
    }

    public void setRegionSpaceId(String regionSpaceId) {
        this.regionSpaceId = regionSpaceId;
    }

    public String getNeighborhoodSpaceId() {
        return neighborhoodSpaceId;
    }

    public void setNeighborhoodSpaceId(String neighborhoodSpaceId) {
        this.neighborhoodSpaceId = neighborhoodSpaceId;
    }

    public String getCountrySpaceId() {
        return countrySpaceId;
    }

    public void setCountrySpaceId(String countrySpaceId) {
        this.countrySpaceId = countrySpaceId;
    }

    public String getStateSpaceId() {
        return stateSpaceId;
    }

    public void setStateSpaceId(String stateSpaceId) {
        this.stateSpaceId = stateSpaceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(campusSpaceId, countrySpaceId, neighborhoodSpaceId, regionSpaceId, stateSpaceId);
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
        GeographyIds other = (GeographyIds) obj;
        return Objects.equals(campusSpaceId, other.campusSpaceId)
                && Objects.equals(countrySpaceId, other.countrySpaceId)
                && Objects.equals(neighborhoodSpaceId, other.neighborhoodSpaceId)
                && Objects.equals(regionSpaceId, other.regionSpaceId)
                && Objects.equals(stateSpaceId, other.stateSpaceId);
    }

    @Override
    public String toString() {
        return "GeographyIds [regionSpaceId=" + regionSpaceId + ", countrySpaceId=" + countrySpaceId + ", stateSpaceId="
                + stateSpaceId + ", neighborhoodSpaceId=" + neighborhoodSpaceId + ", campusSpaceId=" + campusSpaceId
                + "]";
    }

}
