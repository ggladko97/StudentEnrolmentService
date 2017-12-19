package com.wsiiz.studentservice.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
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
    private RecyclerView rcView;

    private int expandedPosition = -1;

    public UnivercityCustomAdapter(List<Univercity> universList, RecyclerView rcView) {
        this.universList = universList;
        this.rcView = rcView;
    }

    @Override
    public UnivercityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CardViewAnimator itemView = (CardViewAnimator) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_card_view, viewGroup, false);
        itemView.attachTitleContent(R.layout.list_view_custom);
        itemView.attachExpandedContent(R.layout.custom_expanded_view);

        return new UnivercityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UnivercityViewHolder univercityViewHolder, int i) {
        Univercity univercity = universList.get(i);
        univercityViewHolder.getTvUniverName().setText(String.valueOf(univercity.getTitle()));
        univercityViewHolder.getTvOpinionsCount().setText(String.valueOf(univercity.getOpinionss().size()));
        univercityViewHolder.getTvUniverCity().setText(String.valueOf(univercity.getLocalization()));





    }

    @Override
    public int getItemCount() {
        return universList.size();
    }
}
