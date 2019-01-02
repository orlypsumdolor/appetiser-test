package com.navbar.avario.appetisermobilechallenge.network.interfaces;

import com.navbar.avario.appetisermobilechallenge.model.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Binary Bean Technologies Inc.
 *
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 *
 * Purpose:
 */
public interface SearchInterface {

  @GET("search")
  Observable<SearchResponse> getSearch(
      @Query("term") String term,
      @Query("country") String country,
      @Query("media") String media
  );

}
