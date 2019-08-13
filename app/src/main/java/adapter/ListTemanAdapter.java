package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapps.DetailTeman;
import com.example.myapps.R;

import java.util.ArrayList;

import model.ListTeman;
import model.Teman;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class ListTemanAdapter extends RecyclerView.Adapter<ListTemanAdapter.CategoryViewHolder> {

    private ArrayList<Teman> teman;

    public void setListTeman(ArrayList<Teman> items) {
        this.teman = items;
        notifyDataSetChanged();
    }

    public ListTemanAdapter(ArrayList<Teman> teman) {
        this.teman = teman;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teman, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvNIM.setText(teman.get(position).getNim());
        categoryViewHolder.tvNama.setText(teman.get(position).getNama());

        final Teman item = teman.get(position);
        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailTeman.class);
                i.putExtra("teman", item);
                v.getContext().startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return teman.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNIM;
        TextView tvNama;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNIM = itemView.findViewById(R.id.tvNIM);
            tvNama = itemView.findViewById(R.id.tvNama);
        }
    }
}
