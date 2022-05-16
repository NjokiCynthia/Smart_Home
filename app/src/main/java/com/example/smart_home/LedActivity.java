package com.example.smart_home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LedActivity extends AppCompatActivity {
    ArrayList<Led> ledBulbs;
    CardView card1;
    RecyclerView recyclerView;
    private LedAdapter allDataDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("IoTlab").child("SmartSwitch").child("BULBS");
        ledBulbs = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.myBulbs);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(LedActivity.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            private Object LedAdapter;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot.getChildren();
//       this bit loops through all values and gives u the data in each card
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Led ledValues = child.getValue(Led.class);
                    System.out.println("Led Object ==== > " + ledValues);
                    System.out.println("DATA       ==== > " + ledValues.getStatus());
                    System.out.println("DATA       ==== > " + ledValues.getLabel());
                    ledBulbs.add(ledValues);
                }
                allDataDisplay = new LedAdapter(ledBulbs, LedActivity.this);
                recyclerView.setAdapter(allDataDisplay);
                allDataDisplay.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value" + error.toException());

            }
        });

        LedAdapter ledAdapter = new LedAdapter(ledBulbs, LedActivity.this);
        recyclerView.setAdapter(ledAdapter);

    }
}
