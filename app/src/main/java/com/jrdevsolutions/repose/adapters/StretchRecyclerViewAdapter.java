package com.jrdevsolutions.repose.adapters;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;
import com.jrdevsolutions.repose.activities.RoutinesActivity;

import java.util.List;

public class StretchRecyclerViewAdapter extends RecyclerView.Adapter<StretchRecyclerViewAdapter.StretchViewHolder>  {
    AppCompatActivity associatedActivity;
    List<Stretch> stretchList;

    public StretchRecyclerViewAdapter(AppCompatActivity associatedActivity, List<Stretch> stretchList) {
        this.associatedActivity = associatedActivity;
        this.stretchList = stretchList;
    }

    @NonNull
    @Override
    public StretchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_stretch, parent, false );
        StretchViewHolder stretchViewHolder = new StretchViewHolder(fragment);
        return stretchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StretchViewHolder holder, int position) {
        Stretch stretch = stretchList.get(position);
        View stretchFragment = holder.itemView;
        TextView currentStretchFragmentTextView = stretchFragment.findViewById(R.id.currentStretchFragmentTextView);
        String stretchString = stretch.getName();
        currentStretchFragmentTextView.setText(stretchString);
    }

    @Override
    public int getItemCount() { return stretchList.size(); }

    public List<Stretch> getStretchList() {return stretchList; }

    public void setStretchList(List<Stretch> stretchList){
        this.stretchList = stretchList;
    }


    public static class StretchViewHolder extends RecyclerView.ViewHolder {
        public StretchViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
