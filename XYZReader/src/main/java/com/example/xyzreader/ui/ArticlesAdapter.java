package com.example.xyzreader.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.data.ItemsContract;

/**
 * Created by royarzun on 02-08-16.
 */
public class ArticlesAdapter  extends RecyclerView.Adapter<ArticlesViewHolder> {
    private Cursor mCursor;
    private Context mContext;
    private LayoutInflater mInflater;

    public ArticlesAdapter(Cursor cursor, Context context) {
        mCursor = cursor;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public long getItemId(int position) {
        mCursor.moveToPosition(position);
        return mCursor.getLong(ArticleLoader.Query._ID);
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_article, parent, false);

        final ArticlesViewHolder vh = new ArticlesViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW,
                        ItemsContract.Items.buildItemUri(getItemId(vh.getAdapterPosition()))));
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        holder.titleView.setText(mCursor.getString(ArticleLoader.Query.TITLE));
        holder.subtitleView.setText(" by " + mCursor.getString(ArticleLoader.Query.AUTHOR));
        holder.thumbnailView.setImageUrl(
                mCursor.getString(ArticleLoader.Query.THUMB_URL),
                ImageLoaderHelper.getInstance(mContext).getImageLoader());
        holder.thumbnailView.setAspectRatio(mCursor.getFloat(ArticleLoader.Query.ASPECT_RATIO));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }
}

