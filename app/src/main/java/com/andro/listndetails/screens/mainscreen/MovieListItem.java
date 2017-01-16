package com.andro.listndetails.screens.mainscreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andro.listndetails.R;
import com.andro.listndetails.models.Result;
import com.andro.listndetails.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andro on 1/14/2017.
 */

public class MovieListItem extends RecyclerView.ViewHolder{

    public static final String POSTER_SIZE_W_185 = "w185";

    @BindView(R.id.listItemViewTitleTextView)
    protected TextView mTitleTextView;

    @BindView(R.id.listItemViewDateTextView)
    protected TextView mDateTextView;

    @BindView(R.id.listItemViewImageView)
    protected ImageView mImageView;

    private Result mResult;

    private MovieItemInterface mMovieItemInterface;

    public MovieListItem(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void populate(Result result) {

        mResult = result;

        mTitleTextView.setText(result.getTitle());
        mDateTextView.setText(result.getReleaseDate());
        ImageUtils.getImage(result.getPosterPath(), POSTER_SIZE_W_185, mImageView, -1);

        itemView.setOnClickListener(itemClickListener);
    }

    private View.OnClickListener itemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mMovieItemInterface != null) {
                mMovieItemInterface.onItemClicked(mResult);
            }
        }
    };

    public void setMovieItemInterface(MovieItemInterface movieItemInterface) {
        this.mMovieItemInterface = movieItemInterface;
    }

    public interface MovieItemInterface {
        void onItemClicked(Result result);
    }
}
