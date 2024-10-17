package com.example.talkingfingers;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlphabetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        List<Integer> alphabetImages = new ArrayList<>();
        //alphabetImages.add(R.drawable.a); // Add images from A to Z
        //alphabetImages.add(R.drawable.b);
        // ... add remaining images

        AlphabetAdapter adapter = new AlphabetAdapter(alphabetImages);
        recyclerView.setAdapter(adapter);
    }
}
