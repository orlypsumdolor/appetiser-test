package com.navbar.avario.appetisermobilechallenge.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.navbar.avario.appetisermobilechallenge.R;
import com.navbar.avario.appetisermobilechallenge.model.Result;
import com.navbar.avario.appetisermobilechallenge.model.SearchResponse;
import com.navbar.avario.appetisermobilechallenge.presenter.main.MainPresenter;
import com.navbar.avario.appetisermobilechallenge.presenter.main.MainViewInterface;
import com.navbar.avario.appetisermobilechallenge.view.adapters.SearchAdapter;

/**
 * The main view of the app
 */
public class MainActivity extends AppCompatActivity implements MainViewInterface {

  private MainPresenter mainPresenter;

  private RecyclerView _songsList;
  private TextView     _loadingText;

  private SearchAdapter searchAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setUpPresenters();
    setUpViews();
    initListeners();
    populateViews();

  }

  /*
  * Initialize Presenters here for this view
  * */
  private void setUpPresenters() {
    mainPresenter = new MainPresenter(this);
  }

  /**
   * initialize all the views here
   */
  private void setUpViews() {
    _songsList = (RecyclerView) findViewById(R.id.list_songs);
    _loadingText = (TextView) findViewById(R.id.text_loading);

    _songsList.setLayoutManager(new LinearLayoutManager(this));
    searchAdapter = new SearchAdapter();
    _songsList.setAdapter(searchAdapter);
  }

  /**
   * listeners of all kinds
   */
  private void initListeners() {
    searchAdapter.setOnItemClick(new SearchAdapter.OnItemClick() {
      @Override
      public void onClick(Result result, int position) {

        /**
         * Convert the Result object to Json string so that it can be passed as extra
         */
        String resultString = new Gson().toJson(result);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.RESULT_EXTRA, resultString);
        startActivity(intent);

      }
    });
  }

  /**
   * trigger the API that populate all the list in the main view
   */
  private void populateViews() {
    mainPresenter.getSearchApi();
  }

  @Override
  public void showToast(String s) {

  }

  @Override
  public void showLoading() {
    _loadingText.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    _loadingText.setVisibility(View.GONE);
  }

  @Override
  public void displaySearch(SearchResponse searchResponse) {
    // populate the views
    if (searchResponse != null) {
      searchAdapter.setResultList(searchResponse.getResults());
      searchAdapter.notifyDataSetChanged();
    }
  }

  @Override
  public void displayError(String s) {

  }
}
