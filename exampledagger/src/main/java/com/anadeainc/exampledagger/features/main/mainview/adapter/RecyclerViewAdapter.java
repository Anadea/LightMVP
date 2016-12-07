package com.anadeainc.exampledagger.features.main.mainview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anadeainc.exampledagger.R;
import com.anadeainc.exampledagger.remote.models.Post;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private WeakReference<IViewHolderCallback> holderCallback;
    private List<Post> dataList = new ArrayList<>();

    public RecyclerViewAdapter(WeakReference<IViewHolderCallback> weakReferenceCallback) {
        this.holderCallback = weakReferenceCallback;
    }

    public void updateDataSet(List<Post> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,
                parent, false);
        return new ItemViewHolder(view, holderCallback);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Post data = dataList.get(position);
        holder.bindView(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
