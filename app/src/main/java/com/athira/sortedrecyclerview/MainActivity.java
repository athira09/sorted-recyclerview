package com.athira.sortedrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    RecyclerView recyclerView;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().trim().length() != 0) {
                    arrayList.add(editText.getText().toString());
                    editText.setText("");
                    // Sorting data
                    Collections.sort(arrayList);

                    CustomAdapter customAdapter = new CustomAdapter(arrayList);
                    recyclerView.setAdapter(customAdapter);
                    customAdapter.notifyDataSetChanged();
                } else
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_text), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
