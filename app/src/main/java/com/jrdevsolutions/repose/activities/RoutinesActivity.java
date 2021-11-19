package com.jrdevsolutions.repose.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Stretch;
import com.jrdevsolutions.repose.R;
import com.jrdevsolutions.repose.adapters.RoutinesRecyclerViewAdapter;
import com.jrdevsolutions.repose.adapters.StretchRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RoutinesActivity extends AppCompatActivity {
    StretchRecyclerViewAdapter stretchRecyclerViewAdapter;
    RoutinesRecyclerViewAdapter routinesRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);

//        Amplify.API.query(
//                ModelQuery.list(Stretch.class),
//                success -> {
//                    List<Stretch> stretchList = new ArrayList<>();
//                    for (Stretch stretch : success.getData()) {
//                        stretchList.add(stretch);
//                    }
//                },
//                failure -> {
//
//                }
//        );

        List<Stretch> stretchList = new ArrayList<>();
        RecyclerView stretchesRecyclerView = findViewById(R.id.stretchesRecyclerView);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        stretchesRecyclerView.setLayoutManager(lm);
        stretchRecyclerViewAdapter = new StretchRecyclerViewAdapter(this, stretchList);
        stretchesRecyclerView.setAdapter(stretchRecyclerViewAdapter);

        List<String> routineNames = new ArrayList<>();
        routineNames.add("Neck");
        routineNames.add("Back");
        routineNames.add("Legs");
        routineNames.add("Arms");
        RecyclerView routinesRecyclerView = findViewById(R.id.routinesRecyclerView);
        RecyclerView.LayoutManager lm2 = new LinearLayoutManager(this);
        routinesRecyclerView.setLayoutManager(lm2);
        routinesRecyclerViewAdapter = new RoutinesRecyclerViewAdapter(this, routineNames);
        routinesRecyclerView.setAdapter(routinesRecyclerViewAdapter);
    }
}