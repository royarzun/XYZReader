package com.example.xyzreader.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.xyzreader.R;
import com.example.xyzreader.ui.custom.views.DynamicHeightNetworkImageView;

/**
 * Created by royarzun on 02-08-16.
 */
public class ArticlesViewHolder  extends RecyclerView.ViewHolder {
    public DynamicHeightNetworkImageView thumbnailView;
    public TextView titleView;
    public TextView subtitleView;

    public ArticlesViewHolder(View view) {
        super(view);
        thumbnailView = (DynamicHeightNetworkImageView) view.findViewById(R.id.thumbnail);
        titleView = (TextView) view.findViewById(R.id.article_title);
        subtitleView = (TextView) view.findViewById(R.id.article_subtitle);
    }
}
