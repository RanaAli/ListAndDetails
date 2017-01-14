package com.andro.listndetails.screens.mainscreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.listndetails.R;
import com.andro.listndetails.models.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andro on 1/14/2017.
 */

public class MovieListAdaptor extends RecyclerView.Adapter<MovieListItem>{

    private List<Result> mResults = new ArrayList<Result>();

    private MovieListAdapterInterface mMovieListAdapterInterface;

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    @Override
    public MovieListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);

        return new MovieListItem(view);

    }

    @Override
    public void onBindViewHolder(MovieListItem holder, int position) {
        holder.populate(mResults.get(position));
        holder.setMovieItemInterface(mMovieItemInterface);

    }

    private MovieListItem.MovieItemInterface mMovieItemInterface = new MovieListItem.MovieItemInterface() {
        @Override
        public void onItemClicked(Result result) {
            if (mMovieListAdapterInterface != null) {
                mMovieListAdapterInterface.onItemClicked(result);
            }
        }
    };

    public void setData(List<Result> results) {
        mResults = results;
        notifyDataSetChanged();
    }

    public List<Result> getData(){
        return mResults;
    }

    public void addData(List<Result> results) {
        mResults.addAll(results);
        notifyDataSetChanged();
    }

    public void setMovieListAdapterInterface(MovieListAdapterInterface movieListAdapterInterface) {
        this.mMovieListAdapterInterface = movieListAdapterInterface;
    }

    public interface MovieListAdapterInterface {
        void onItemClicked(Result result);
    }

}
