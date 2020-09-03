
package com.stackroute.usertrackservice.rabbitmq.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageId",
    "text",
    "size"
})
public class ImageDTO {

    @JsonProperty("imageId")
    private Long imageId;
    @JsonProperty("text")
    private String imageUrl;
    @JsonProperty("size")
    private String imageSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageDTO() {
    }

    /**
     * 
     * @param imageId
     * @param imageUrl
     * @param imageSpec
     */
    public ImageDTO(Long imageId, String imageUrl, String imageSpec) {
        super();
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.imageSpec = imageSpec;
    }

    @JsonProperty("imageId")
    public Long getImageId() {
        return imageId;
    }

    @JsonProperty("imageId")
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    @JsonProperty("text")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("text")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("size")
    public String getImageSpec() {
        return imageSpec;
    }

    @JsonProperty("size")
    public void setImageSpec(String imageSpec) {
        this.imageSpec = imageSpec;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imageUrl=" + imageUrl + ", imageSpec=" + imageSpec
				+ ", additionalProperties=" + additionalProperties + "]";
	}

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("imageId", imageId).append("imageUrl", imageUrl).append("imageSpec", imageSpec).append("additionalProperties", additionalProperties).toString();
//    }

}
