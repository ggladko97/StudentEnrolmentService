package com.wsiiz.studentservice.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wsiiz.studentservice.R;
import com.wsiiz.studentservice.model.Univercity;

import java.util.List;

/**
 * Created by hladlyev on 18.12.2017.
 */

public class UnivercityCustomAdapter extends RecyclerView.Adapter<UnivercityViewHolder> {

    private List<Univercity> universList;
    private Context ctx;

    public UnivercityCustomAdapter(List<Univercity> universList) {
        this.universList = universList;
    }

    @Override
    public UnivercityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_view_custom, viewGroup, false);
        ctx = itemView.getContext();
        return new UnivercityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UnivercityViewHolder univercityViewHolder, int i) {
        Univercity univercity = universList.get(i);
        univercityViewHolder.getTvUniverName().setText(String.valueOf(univercity.getTitle()));
        univercityViewHolder.getTvOpinionsCount().setText(String.valueOf(univercity.getOpinionss().size()));
        univercityViewHolder.getTvUniverCity().setText(String.valueOf(univercity.getLocalization()));

        univercityViewHolder.getIbExpand().setOnClickListener((v) -> Toast.makeText(ctx, "univercity clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return universList.size();
    }
}
