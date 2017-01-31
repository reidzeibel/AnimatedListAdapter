package com.reidzeibel.animatedadaptersample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reidzeibel.animatedlistadapter.BaseAnimatedListAdapter;

import java.util.List;

/**
 * Created by RidwanAditama on 21/01/2017.
 */

public class SampleAdapter extends BaseAnimatedListAdapter<SampleAdapter.SampleHolder> {

    private List<SampleItem> sampleItemList;

    static class SampleHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        View layout;

        SampleHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
            layout = v.findViewById(R.id.layout);
        }
    }

    SampleAdapter(RecyclerView recyclerView, List<SampleItem> sampleItemList) {
        this.sampleItemList = sampleItemList;
        setRecyclerView(recyclerView);
        initAnimatedListAdapter();
    }

    @Override
    public int getItemCount() {
        return sampleItemList.size();
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sampleitem, parent, false);
        final SampleHolder holder = new SampleHolder(v);
        setClickListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, int position) {
        final SampleItem item = sampleItemList.get(position);
        final boolean isExpanded = position == mExpandedPosition;

        holder.title.setText(item.title);
        holder.description.setText(item.description);
        holder.itemView.setActivated(isExpanded);
        holder.layout.setVisibility(isExpanded? View.VISIBLE : View.GONE);
    }
}
