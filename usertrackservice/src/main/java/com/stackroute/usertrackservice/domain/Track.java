
package com.stackroute.usertrackservice.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@Document(value = "Tracks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "trackId", "name", "url", "comments", "listeners", "artist" })
public class Track {

	@Id
	@JsonProperty("trackId")
	private String trackId;
	@JsonProperty("name")
	private String trackName;
	@JsonProperty("url")
	private String trackUrl;
	@JsonProperty("comments")
	private String comments;
	@JsonProperty("listeners")
	private Long trackListeners;
	@JsonProperty("artist")
	private Artist artist;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Track() {
	}

	/**
	 * 
	 * @param trackId
	 * @param trackUrl
	 * @param trackName
	 * @param artist
	 * @param comments
	 * @param trackListeners
	 */
	public Track(String trackId, String trackName, String trackUrl, String comments, Long trackListeners,
			Artist artist) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.trackUrl = trackUrl;
		this.comments = comments;
		this.trackListeners = trackListeners;
		this.artist = artist;
	}

	@JsonProperty("trackId")
	public String getTrackId() {
		return trackId;
	}

	@JsonProperty("trackId")
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	@JsonProperty("name")
	public String getTrackName() {
		return trackName;
	}

	@JsonProperty("name")
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	@JsonProperty("url")
	public String getTrackUrl() {
		return trackUrl;
	}

	@JsonProperty("url")
	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	@JsonProperty("comments")
	public String getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonProperty("listeners")
	public Long getTrackListeners() {
		return trackListeners;
	}

	@JsonProperty("listeners")
	public void setTrackListeners(Long trackListeners) {
		this.trackListeners = trackListeners;
	}

	@JsonProperty("artist")
	public Artist getArtist() {
		return artist;
	}

	@JsonProperty("artist")
	public void setArtist(Artist artist) {
		this.artist = artist;
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
		return "Track [trackId=" + trackId + ", trackName=" + trackName + ", trackUrl=" + trackUrl + ", comments="
				+ comments + ", trackListeners=" + trackListeners + ", artist=" + artist + ", additionalProperties="
				+ additionalProperties + "]";
	}

}
