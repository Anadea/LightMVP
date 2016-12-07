package com.anadeainc.exampledagger.features.main.mainview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.remote.models.Post;

import java.lang.ref.WeakReference;

class ItemViewHolder extends RecyclerView.ViewHolder {

    private final WeakReference<IViewHolderCallback> callback;

    private final TextView titleTextView;
    private final TextView bodyTextView;

    ItemViewHolder(View itemView, WeakReference<IViewHolderCallback> weakReferenceCallback) {
        super(itemView);

        callback = weakReferenceCallback;

        titleTextView = (TextView) itemView.findViewById(R.id.textView_itemTitle);
        bodyTextView = (TextView) itemView.findViewById(R.id.textView_itemBody);

        itemView.setOnClickListener(view -> {
            if (callback.get() != null)
                callback.get().onViewHolderClick(view, getAdapterPosition());
        });

    }

    void bindView(Post data) {
        titleTextView.setText(data.getTitle());
        bodyTextView.setText(data.getBody());
    }

}
