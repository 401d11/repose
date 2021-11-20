package com.jrdevsolutions.repose.adapters;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;
import com.jrdevsolutions.repose.activities.RoutinesActivity;

import java.util.ArrayList;
import java.util.List;

public class RoutinesRecyclerViewAdapter extends RecyclerView.Adapter<RoutinesRecyclerViewAdapter.RoutinesViewHolder> {
    AppCompatActivity associatedActivity;
    List<String> routines;
    StretchRecyclerViewAdapter stretchRecyclerViewAdapter;

    public RoutinesRecyclerViewAdapter(AppCompatActivity associatedActivity, List<String> routines, StretchRecyclerViewAdapter stretchRecyclerViewAdapter) {
        this.associatedActivity = associatedActivity;
        this.routines = routines;
        this.stretchRecyclerViewAdapter = stretchRecyclerViewAdapter;
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
        Button currentRoutineFragmentButton = routineNameFragment.findViewById(R.id.currentRoutineFragmentButton);
        currentRoutineFragmentButton.setText(routineName);

        currentRoutineFragmentButton.setOnClickListener(view -> {
            List<Stretch> stretchList = new ArrayList<>();
            Amplify.API.query(
                    ModelQuery.list(Stretch.class),
                    success -> {
                        for (Stretch stretch : success.getData()) {
                            if(stretch.getMuscleGroup().toLowerCase().equals(routineName.toLowerCase())){
                                stretchList.add(stretch);
                            }
                        }
                        runOnUiThread(() -> {
                            stretchRecyclerViewAdapter.setStretchList(stretchList);
                            stretchRecyclerViewAdapter.notifyDataSetChanged();
                        });
                    },
                    failure -> {
                    }
            );
        });

    }

    @Override
    public int getItemCount() {
        return routines.size();
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
