package com.andresmz.practiceexam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andresmz.practiceexam.Class.CatClass;
import com.andresmz.practiceexam.R;

import java.util.ArrayList;

public class AdapterCats extends RecyclerView.Adapter<AdapterCats.ViewHolderAdapterCats> {

    ArrayList<CatClass> listCats;

    public AdapterCats(ArrayList<CatClass> listCats) {
        this.listCats = listCats;
    }

    @NonNull
    @Override
    public ViewHolderAdapterCats onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cats, null, false);
        return new ViewHolderAdapterCats(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapterCats holder, int position) {

        holder.createTextView.setText(listCats.get(position).getCreate());

    }

    @Override
    public int getItemCount() {
        return listCats.size();
    }

    public class ViewHolderAdapterCats extends RecyclerView.ViewHolder {
        TextView createTextView;

        public ViewHolderAdapterCats(@NonNull View itemView) {
            super(itemView);
                createTextView = itemView.findViewById(R.id.created_at_textview);
        }
    }
}
