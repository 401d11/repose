package com.jrdevsolutions.repose.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.jrdevsolutions.repose.R;

import java.util.List;

public class RoutinesRecyclerViewAdapter extends RecyclerView.Adapter<RoutinesRecyclerViewAdapter.RoutinesViewHolder> {
    AppCompatActivity associatedActivity;
    List<String> routines;

    public RoutinesRecyclerViewAdapter(AppCompatActivity associatedActivity, List<String> routines) {
        this.associatedActivity = associatedActivity;
        this.routines = routines;
    }

    @NonNull
    @Override
    public RoutinesRecyclerViewAdapter.RoutinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View fragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_routine, parent, false);
        RoutinesViewHolder routinesViewHolder = new RoutinesViewHolder(fragment);
        return routinesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoutinesRecyclerViewAdapter.RoutinesViewHolder holder, int position) {
        String routineName = routines.get(position);
        View routineNameFragment = holder.itemView;
        Button currentRoutineFragmentButton =   routineNameFragment.findViewById(R.id.currentRoutineFragmentButton);
        currentRoutineFragmentButton.setText(routineName);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public List<String> getRoutines() {
        return routines;
    }

    public void setRoutines(List<String> routines) {
        this.routines = routines;
    }

    public static class RoutinesViewHolder extends RecyclerView.ViewHolder {
        public RoutinesViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
