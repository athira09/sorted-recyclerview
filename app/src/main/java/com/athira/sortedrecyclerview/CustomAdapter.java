package com.athira.sortedrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Athira.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<String> mArrayList = new ArrayList<>();

    CustomAdapter(ArrayList<String> arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.mText.setText(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView mText;

        CustomViewHolder(final View v) {
            super(v);
            mText = v.findViewById(R.id.text);
        }
    }
}
