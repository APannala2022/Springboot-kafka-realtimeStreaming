package com.kafka.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @type: SpaceRequest
 * @description:
 *
 * @author: sgogineni
 * @version: 1.0
 * @created: Feb 13, 2020
 */
@Validated
public class SpaceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("capacity")
    private String capacity = null;

    @JsonProperty("childXRefIds")
    @Valid
    private List<String> childXRefIds = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("devices")
    @Valid
    private List<SpaceDeviceRequest> devices = null;

    @JsonProperty("friendlyName")
    private String friendlyName = null;

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("identifiers")
    @Valid
    private Map<String, String> identifiers = null;

    @JsonProperty("location")
    private SpaceLocation location = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("openHours")
    @Valid
    private List<OpenHours> openHours = null;

    @JsonProperty("parentSpaceId")
    private String parentSpaceId = null;

    @JsonProperty("subtype")
    private String subtype = null;

    @JsonProperty("tags")
    @Valid
    private List<String> tags = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("customerId")
    private String customerId = null;

    @JsonProperty("presentedAs")
    private String presentedAs;

    @JsonProperty("iconName")
    private String iconName;

    @JsonProperty("isReservable")
    private Boolean isReservable;

    private String campusId;

    @JsonProperty("geographyIds")
    private GeographyIds geographyIds;

    private String zoomTier;

    @JsonProperty("freeText")
    private String freeText;

    private String roomReleaseStatus = null;

    public String getZoomTier() {
        return zoomTier;
    }

    public void setZoomTier(String zoomTier) {
        this.zoomTier = zoomTier;
    }

    public GeographyIds getGeographyIds() {
        return geographyIds;
    }

    public void setGeographyIds(GeographyIds geographyIds) {
        this.geographyIds = geographyIds;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<String> getChildXRefIds() {
        return childXRefIds;
    }

    public void setChildXRefIds(List<String> childXRefIds) {
        this.childXRefIds = childXRefIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Valid
    public List<SpaceDeviceRequest> getDevices() {
        return devices;
    }

    public void setDevices(List<SpaceDeviceRequest> devices) {
        this.devices = devices;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(Map<String, String> identifiers) {
        this.identifiers = identifiers;
    }

    @Valid
    public SpaceLocation getLocation() {
        return location;
    }

    public void setLocation(SpaceLocation location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Valid
    public List<OpenHours> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(List<OpenHours> openHours) {
        this.openHours = openHours;
    }

    public String getParentSpaceId() {
        return parentSpaceId;
    }

    public void setParentSpaceId(String parentSpaceId) {
        this.parentSpaceId = parentSpaceId;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPresentedAs() {
        return presentedAs;
    }

    public void setPresentedAs(String presentedAs) {
        this.presentedAs = presentedAs;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Boolean getIsReservable() {
        return isReservable;
    }

    public void setIsReservable(Boolean isReservable) {
        this.isReservable = isReservable;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public String getRoomReleaseStatus() {
        return roomReleaseStatus;
    }

    public void setRoomReleaseStatus(String roomReleaseStatus) {
        this.roomReleaseStatus = roomReleaseStatus;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpaceRequest spaceRequest = (SpaceRequest) o;
        return Objects.equals(capacity, spaceRequest.capacity)
                && Objects.equals(childXRefIds, spaceRequest.childXRefIds)
                && Objects.equals(description, spaceRequest.description)
                && Objects.equals(devices, spaceRequest.devices)
                && Objects.equals(friendlyName, spaceRequest.friendlyName) && Objects.equals(id, spaceRequest.id)
                && Objects.equals(identifiers, spaceRequest.identifiers)
                && Objects.equals(location, spaceRequest.location) && Objects.equals(name, spaceRequest.name)
                && Objects.equals(openHours, spaceRequest.openHours)
                && Objects.equals(parentSpaceId, spaceRequest.parentSpaceId)
                && Objects.equals(subtype, spaceRequest.subtype) && Objects.equals(tags, spaceRequest.tags)
                && Objects.equals(type, spaceRequest.type) && Objects.equals(status, spaceRequest.status)
                && Objects.equals(customerId, spaceRequest.customerId)
                && Objects.equals(presentedAs, spaceRequest.presentedAs)
                && Objects.equals(iconName, spaceRequest.iconName)
                && Objects.equals(isReservable, spaceRequest.isReservable)
                && Objects.equals(campusId, spaceRequest.campusId) && Objects.equals(zoomTier, spaceRequest.zoomTier)
                && Objects.equals(freeText, spaceRequest.freeText)
                && Objects.equals(roomReleaseStatus, spaceRequest.roomReleaseStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, childXRefIds, description, devices, friendlyName, id, identifiers, location, name,
                openHours, parentSpaceId, subtype, tags, type, status, customerId, presentedAs, iconName, isReservable,
                campusId, zoomTier, freeText, roomReleaseStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SpaceRequest {\n");

        sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
        sb.append("    childXRefIds: ").append(toIndentedString(childXRefIds)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    devices: ").append(toIndentedString(devices)).append("\n");
        sb.append("    friendlyName: ").append(toIndentedString(friendlyName)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    openHours: ").append(toIndentedString(openHours)).append("\n");
        sb.append("    parentSpaceId: ").append(toIndentedString(parentSpaceId)).append("\n");
        sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    presentedAs: ").append(toIndentedString(presentedAs)).append("\n");
        sb.append("    iconName: ").append(toIndentedString(iconName)).append("\n");
        sb.append("    isReservable: ").append(toIndentedString(isReservable)).append("\n");
        sb.append("    campusId: ").append(toIndentedString(campusId)).append("\n");
        sb.append("    zoomTier: ").append(toIndentedString(zoomTier)).append("\n");
        sb.append("    freeText: ").append(toIndentedString(freeText)).append("\n");
        sb.append("    roomReleaseStatus: ").append(toIndentedString(roomReleaseStatus)).append("\n");
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
