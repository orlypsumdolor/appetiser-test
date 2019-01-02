package com.navbar.avario.appetisermobilechallenge.presenter.detail;

import com.navbar.avario.appetisermobilechallenge.model.Result;

/**
 * @author: orly
 * @date: 1/1/2019
 * @department: Android
 */
public interface DetailViewInterface {


  void showToast(String s);

  void showLoading();

  void hideLoading();

  void displayResult(Result result);

  void displayError(String s);

}
