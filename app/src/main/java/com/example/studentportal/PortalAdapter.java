package com.example.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private Context context;
    private List<Portal> portalList;

    public PortalAdapter(Context context, List<Portal> portalList) {
        this.context = context;
        this.portalList = portalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.grid_cell, viewGroup, false);
        return new PortalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.portal.setText(portalList.get(viewHolder.getAdapterPosition()).getTitle());
        viewHolder.portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                String url = portalList.get(viewHolder.getAdapterPosition()).getUrl();
                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return portalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView portal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            portal = itemView.findViewById(R.id.tv_portal);
        }
    }
}
