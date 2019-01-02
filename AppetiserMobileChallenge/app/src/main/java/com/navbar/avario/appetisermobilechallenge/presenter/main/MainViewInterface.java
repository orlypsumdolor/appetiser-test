package com.navbar.avario.appetisermobilechallenge.presenter.main;

import com.navbar.avario.appetisermobilechallenge.model.SearchResponse;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */

/**
 * interface calls for the main view
 */
public interface MainViewInterface {

  void showToast(String s);

  void showLoading();

  void hideLoading();

  void displaySearch(SearchResponse searchResponse);

  void displayError(String s);

}
