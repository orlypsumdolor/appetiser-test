package com.navbar.avario.appetisermobilechallenge.presenter.main;

import com.navbar.avario.appetisermobilechallenge.model.Result;
import com.navbar.avario.appetisermobilechallenge.model.SearchResponse;
import com.navbar.avario.appetisermobilechallenge.network.APIClient;
import com.navbar.avario.appetisermobilechallenge.network.interfaces.SearchInterface;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */

/**
 * All the data process in main view is
 * being handled here in this presenter
 */
public class MainPresenter {

  MainViewInterface mvi;

  public MainPresenter(MainViewInterface mvi) {
    this.mvi = mvi;
  }

  /**
   * triggers the itunes search API
   */
  public void getSearchApi() {
    mvi.showLoading();


    /**
     * 1. Populate first with data from DB then Update after using the API data
     */
    getSearchDb();
    APIClient.getRetrofit().create(SearchInterface.class)
        .getSearch("star", "au", "movie")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<SearchResponse>() {
          @Override
          public void onSubscribe(Disposable d) {

          }

          @Override
          public void onNext(SearchResponse searchResponse) {
            mvi.displaySearch(searchResponse);

            // save the Results after the fetch
            saveDataOnDb(searchResponse);
          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
            mvi.displayError(e.getMessage());
          }

          @Override
          public void onComplete() {
            mvi.hideLoading();
          }
        });
  }

  /**
   * gets all the result data from the database
   */
  private void getSearchDb() {
    Observable.create(new ObservableOnSubscribe<List<Result>>() {
      @Override
      public void subscribe(ObservableEmitter<List<Result>> emitter) throws Exception {

        List<Result> results = SugarRecord .listAll(Result.class);

        emitter.onNext(results);
        emitter.onComplete();
      }

    }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<List<Result>>() {
          @Override
          public void onSubscribe(Disposable d) {

          }

          @Override
          public void onNext(List<Result> results) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setResults(results);
            mvi.displaySearch(searchResponse);
          }

          @Override
          public void onError(Throwable e) {
            mvi.displayError(e.getMessage());
          }

          @Override
          public void onComplete() {
            mvi.hideLoading();
          }
        });


  }

  /**
   * Saves all the result data into DB
   */
  private void saveDataOnDb(SearchResponse searchResponse) {
    for (Result result : searchResponse.getResults()) {
      Result resultDb = Select.from(Result.class).where(
          Condition.prop("track_id").eq(result.getTrackId())).first();
      if (resultDb != null) {
        SugarRecord.deleteAll(Result.class, "track_id = ?", String.valueOf(result.getTrackId()));
      }
      SugarRecord.save(result);
    }
  }

}
