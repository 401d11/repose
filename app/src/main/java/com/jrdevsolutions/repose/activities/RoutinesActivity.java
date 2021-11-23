package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;
import com.jrdevsolutions.repose.adapters.RoutinesRecyclerViewAdapter;
import com.jrdevsolutions.repose.adapters.StretchRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

public class RoutinesActivity extends AppCompatActivity {
    StretchRecyclerViewAdapter stretchRecyclerViewAdapter;
    RoutinesRecyclerViewAdapter routinesRecyclerViewAdapter;
    public static boolean canStart = false;

    public final static String TAG = "jrdevsolutions_repose_routinesactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);

        List<Stretch> stretchList = new ArrayList<>();
        RecyclerView stretchesRecyclerView = findViewById(R.id.stretchesRecyclerView);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        stretchesRecyclerView.setLayoutManager(lm);
        stretchRecyclerViewAdapter = new StretchRecyclerViewAdapter(this, stretchList);
        stretchesRecyclerView.setAdapter(stretchRecyclerViewAdapter);

        Button startRoutine = findViewById(R.id.startRoutine);
        List<String> routineNames = new ArrayList<>();
        routineNames.add("Neck");
        routineNames.add("Back");
        routineNames.add("Legs");
        routineNames.add("Arms");
        RecyclerView routinesRecyclerView = findViewById(R.id.routinesRecyclerView);
        RecyclerView.LayoutManager lm2 = new LinearLayoutManager(this);
        routinesRecyclerView.setLayoutManager(lm2);
        routinesRecyclerViewAdapter = new RoutinesRecyclerViewAdapter(this, routineNames, stretchRecyclerViewAdapter, startRoutine);
        routinesRecyclerView.setAdapter(routinesRecyclerViewAdapter);


        startRoutine.setVisibility(View.INVISIBLE);

        startRoutine.setOnClickListener(view -> {
            Intent intent = new Intent(RoutinesActivity.this, StretchPageActivity.class);
            List<Stretch> stretchList1 = stretchRecyclerViewAdapter.getStretchList();
            ArrayList<String> stretchIds = new ArrayList<>();
            for (Stretch stretch : stretchList1) {
                stretchIds.add(stretch.getId());
            }
            intent.putStringArrayListExtra("Stretches", stretchIds);
            startActivity(intent);
        });

        Button backButton = findViewById(R.id.routineActivityBackButton);
        backButton.setOnClickListener(view -> {
            Intent backIntent = new Intent(RoutinesActivity.this, MainActivity.class);
            startActivity(backIntent);

        });
    }
}