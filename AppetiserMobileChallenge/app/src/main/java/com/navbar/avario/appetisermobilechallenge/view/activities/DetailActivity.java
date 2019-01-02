package com.navbar.avario.appetisermobilechallenge.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.navbar.avario.appetisermobilechallenge.R;
import com.navbar.avario.appetisermobilechallenge.model.Result;

/**
 * @author: orly
 * @date: 1/1/2019
 * @department: Android
 */
public class DetailActivity extends AppCompatActivity {

  public static String RESULT_EXTRA = "RESULT_EXTRA";

  private ImageView _coverImage;
  private TextView  _titleText;
  private TextView  _descriptionText;

  private Result result;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    getExtras();
    initViews();
    populateViews();
  }

  /**
   * get all the extra sent from on item click from the search list
   */
  private void getExtras() {
    String resultExtra = getIntent().getStringExtra(RESULT_EXTRA);
    if (resultExtra != null) {

      // Convert the JSON string to Result Object
      result = new Gson().fromJson(resultExtra, Result.class);
    }
  }

  private void initViews() {
    _coverImage = (ImageView) findViewById(R.id.image_cover);
    _titleText = (TextView) findViewById(R.id.text_title);
    _descriptionText = (TextView) findViewById(R.id.text_description);
  }

  private void populateViews() {
    if (result != null) {

      Glide.with(DetailActivity.this).load(result.getArtWork()).placeholder(
          getApplicationContext().getResources().getColor(R.color.gray)).into(_coverImage);

      _titleText.setText(result.getTrackName());
      _descriptionText.setText(result.getLongDescription());


    }
  }
}
