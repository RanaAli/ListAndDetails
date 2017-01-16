package com.andro.listndetails.utils;

import android.widget.ImageView;

import com.andro.listndetails.R;
import com.squareup.picasso.Picasso;

/**
 * Created by andro on 1/14/2017.
 */
public class ImageUtils {

    public static final int DEFAULT_PLACEHOLDER = R.drawable.default_placeholder;

    public static void getImage(String imageUrl, String size, ImageView imageView, int placeHolder) {
        int selectedPlaceHolder = DEFAULT_PLACEHOLDER;

        if (placeHolder != -1) {
            selectedPlaceHolder = placeHolder;
        }

        String url;

        if (size != null && !size.equalsIgnoreCase("")) {
            url = imageView.getContext().getString(R.string.imageURL) + size + imageUrl;
        } else {
            url = imageView.getContext().getString(R.string.imageURL) + "w500" + imageUrl;
        }

        Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(selectedPlaceHolder)
                .into(imageView);
    }
}
