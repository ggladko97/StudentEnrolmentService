package com.wsiiz.studentservice.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wsiiz.studentservice.R;

/**
 * Created by hladlyev on 18.12.2017.
 */

public class UnivercityViewHolder extends RecyclerView.ViewHolder {
    private CardViewAnimator cvUniverCard;
    private TextView tvUniverName, tvUniverCity, tvOpinionsDisp, tvOpinionsCount, tvExpContent;
//    private ImageButton ibExpand;

    public UnivercityViewHolder(View itemView) {
        super(itemView);
//        cvUniverCard = itemView.findViewById(R.id.cvUniverCard);
        tvUniverName = (TextView) itemView.findViewById(R.id.tvUnivercityName);
        tvOpinionsCount = (TextView) itemView.findViewById(R.id.tvOpinionsCount);
//        tvExpContent = (TextView) itemView.findViewById(R.id.tvExpandedContent);
        tvOpinionsDisp = (TextView) itemView.findViewById(R.id.tvOpinionsDisp);
//        ibExpand = (ImageButton) itemView.findViewById(R.id.ibExpand);
        tvUniverCity = (TextView) itemView.findViewById(R.id.tvUnivercityCity);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CardViewAnimator)itemView).expand();
//                if (i == expandedPosition) {
//                    univercityViewHolder.getTvExpContent().setVisibility(View.VISIBLE);
//                } else {
//                    univercityViewHolder.getTvExpContent().setVisibility(View.GONE);
//                }
                Toast.makeText(v.getContext(), "univercity clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public TextView getTvUniverName() {
        return tvUniverName;
    }


    public TextView getTvOpinionsDisp() {
        return tvOpinionsDisp;
    }


    public TextView getTvOpinionsCount() {
        return tvOpinionsCount;
    }


//    public ImageButton getIbExpand() {
//        return ibExpand;
//    }


    public TextView getTvUniverCity() {
        return tvUniverCity;
    }

    public CardView getCvUniverCard() {
        return cvUniverCard;
    }

    public TextView getTvExpContent() {
        return tvExpContent;
    }
}
