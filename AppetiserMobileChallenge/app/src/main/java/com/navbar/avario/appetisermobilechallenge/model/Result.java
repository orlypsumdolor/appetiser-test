package com.navbar.avario.appetisermobilechallenge.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */
@Table
public class Result {

  @SerializedName("trackId")
  private int trackId;

  @SerializedName("trackName")
  private String trackName;

  @SerializedName("artworkUrl100")
  private String artWork;

  @SerializedName("primaryGenreName")
  private String genre;

  @SerializedName("trackPrice")
  private double trackPrice;

  @SerializedName("currency")
  private String currency;

  @SerializedName("longDescription")
  private String longDescription;

  public void setTrackId(int trackId) {
    this.trackId = trackId;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public void setArtWork(String artWork) {
    this.artWork = artWork;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setTrackPrice(int trackPrice) {
    this.trackPrice = trackPrice;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public int getTrackId() {
    return trackId;
  }

  public String getTrackName() {
    return trackName;
  }

  public String getArtWork() {
    return artWork;
  }

  public double getTrackPrice() {
    return trackPrice;
  }

  public String getCurrency() {
    return currency;
  }

  public String getGenre() {
    return genre;
  }

  public String getLongDescription() {
    return longDescription;
  }
}
