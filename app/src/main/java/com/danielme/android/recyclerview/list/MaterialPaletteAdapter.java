package com.danielme.android.recyclerview.list;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danielme.android.recyclerview.list.R;

import java.util.List;

/**
 * @author danielme.com
 */
public class MaterialPaletteAdapter extends RecyclerView.Adapter<MaterialPaletteAdapter.PaletteViewHolder> {
    private List<Color> data;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public MaterialPaletteAdapter(@NonNull List<Color> data,
                                  @NonNull RecyclerViewOnItemClickListener
                                      recyclerViewOnItemClickListener) {
        this.data = data;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        Color color = data.get(position);
        holder.getTitleTextView().setText(color.getName());
        holder.getSubtitleTextView().setText(color.getHex());

        GradientDrawable gradientDrawable = (GradientDrawable) holder.getCircleView().getBackground();
        int colorId = android.graphics.Color.parseColor(color.getHex());
        gradientDrawable.setColor(colorId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder implements View
        .OnClickListener {
        private View circleView;
        private TextView titleTextView;
        private TextView subtitleTextView;


        public PaletteViewHolder(View itemView) {
            super(itemView);
            circleView = itemView.findViewById(R.id.circleView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            subtitleTextView = (TextView) itemView.findViewById(R.id.subtitleTextView);
            itemView.setOnClickListener(this);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public TextView getSubtitleTextView() {
            return subtitleTextView;
        }

        public View getCircleView() {
            return circleView;
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }

}

