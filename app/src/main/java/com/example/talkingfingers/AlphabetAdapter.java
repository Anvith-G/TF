package com.example.talkingfingers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.AlphabetViewHolder> {
    private final List<Integer> alphabetImages;

    public AlphabetAdapter(List<Integer> alphabetImages) {
        this.alphabetImages = alphabetImages;
    }

    @NonNull
    @Override
    public AlphabetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alphabet, parent, false);
        return new AlphabetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetViewHolder holder, int position) {
        holder.imageView.setImageResource(alphabetImages.get(position));
    }

    @Override
    public int getItemCount() {
        return alphabetImages.size();
    }

    static class AlphabetViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        AlphabetViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
