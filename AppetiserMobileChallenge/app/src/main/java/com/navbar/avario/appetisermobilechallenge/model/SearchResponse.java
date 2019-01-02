package com.navbar.avario.appetisermobilechallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */
public class SearchResponse {

  @SerializedName("resultCount")
  private int resultCount;

  @SerializedName("results")
  private List<Result> results;

  public int getResultCount() {
    return resultCount;
  }

  public List<Result> getResults() {
    return results;
  }

  public void setResultCount(int resultCount) {
    this.resultCount = resultCount;
  }

  public void setResults(List<Result> results) {
    this.results = results;
  }
}
