
package com.stackroute.usertrackservice.domain;

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
    "artistId",
    "name",
    "url",
    "image"
})
public class Artist {

    @JsonProperty("artistId")
    private Long artistId;
    @JsonProperty("name")
    private String artistName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image")
    private Image image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param artistId
     * @param image
     * @param artistName
     * @param url
     */
    public Artist(Long artistId, String artistName, String url, Image image) {
        super();
        this.artistId = artistId;
        this.artistName = artistName;
        this.url = url;
        this.image = image;
    }

    @JsonProperty("artistId")
    public Long getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("name")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("name")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
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
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", url=" + url + ", image=" + image
				+ ", additionalProperties=" + additionalProperties + "]";
	}

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("artistId", artistId).append("artistName", artistName).append("url", url).append("image", image).append("additionalProperties", additionalProperties).toString();
//    }

}
