package cl.vero.winelist.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.vero.winelist.R;
import cl.vero.winelist.data.Queries;
import cl.vero.winelist.models.Wine;

public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.ViewHolder>{

    List<Wine> wines = new Queries().wines();
    private WineClickListener listener;

    public WinesAdapter(WineClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_wine,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Wine wine = wines.get(i);
        viewHolder.brandTv.setText(wine.getBrand());
        viewHolder.yearsTv.setText(wine.getYears());
        viewHolder.typeTv.setText(wine.getType());

        viewHolder.brandTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        viewHolder.yearsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        viewHolder.typeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    public void update(Wine wine){
        wines.add(wine);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView brandTv, yearsTv, typeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            brandTv = itemView.findViewById(R.id.brandTv);
            yearsTv = itemView.findViewById(R.id.yearsTv);
            typeTv = itemView.findViewById(R.id.typeTv);


        }
    }
}
