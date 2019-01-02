package com.navbar.avario.appetisermobilechallenge.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.navbar.avario.appetisermobilechallenge.R;
import com.navbar.avario.appetisermobilechallenge.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: orly
 * @date: 12/27/2018
 * @department: Android
 */

/**
 * Adapter for the search list in the main view
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

  private List<Result> resultList;

  private OnItemClick onItemClick;

  public SearchAdapter() {
    resultList = new ArrayList<>();
  }

  @Override
  public SearchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent,
        false);
    return new SearchHolder(view);
  }

  @Override
  public void onBindViewHolder(SearchHolder holder, final int position) {
    final Result result = resultList.get(position);

    Glide.with(holder.itemView.getContext()).load(result.getArtWork()).placeholder(
        holder.itemView.getContext().getResources().getColor(R.color.gray)).into(
        holder.artworkImage);

    holder.nameText.setText(result.getTrackName());
    holder.genreText.setText(result.getGenre());
    holder.priceText.setText(result.getCurrency() + " " + result.getTrackPrice());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (onItemClick != null) {
          onItemClick.onClick(result, position);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return resultList.size();
  }

  public void setResultList(List<Result> resultList) {
    this.resultList = resultList;
  }

  public void setOnItemClick(OnItemClick onItemClick) {
    this.onItemClick = onItemClick;
  }

  public class SearchHolder extends RecyclerView.ViewHolder {

    ImageView artworkImage;
    TextView  nameText;
    TextView  genreText;
    TextView  priceText;

    public SearchHolder(View itemView) {
      super(itemView);

      artworkImage = (ImageView) itemView.findViewById(R.id.image_artwork);
      nameText = (TextView) itemView.findViewById(R.id.text_name);
      genreText = (TextView) itemView.findViewById(R.id.text_genre);
      priceText = (TextView) itemView.findViewById(R.id.text_price);

    }
  }

  public interface OnItemClick {
    void onClick(Result result, int position);
  }
}
