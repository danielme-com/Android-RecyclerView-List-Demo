package com.danielme.android.recyclerview.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielme.com
 */
public class MainActivity extends AppCompatActivity {

    private List<Color> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initColors();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MaterialPaletteAdapter(colors, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast toast = Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT);
                int color = android.graphics.Color.parseColor(colors.get(position).getHex());
                toast.getView().setBackgroundColor(color);
                toast.show();
            }
        }));
        //VERTICAL
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //HORIZONTAL
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView.addItemDecoration(new DividerItemDecoration(this));
    }

    @SuppressWarnings("ResourceType")
    private void initColors() {
        colors = new ArrayList<>();
        colors.add(new Color(getString(R.string.blue), getResources().getString(R.color.blue)));
        colors.add(new Color(getString(R.string.indigo), getResources().getString(R.color.indigo)));
        colors.add(new Color(getString(R.string.red), getResources().getString(R.color.red)));
        colors.add(new Color(getString(R.string.green), getResources().getString(R.color.green)));
        colors.add(new Color(getString(R.string.orange), getResources().getString(R.color.orange)));
        colors.add(new Color(getString(R.string.grey), getResources().getString(R.color.bluegrey)));
        colors.add(new Color(getString(R.string.amber), getResources().getString(R.color.teal)));
        colors.add(new Color(getString(R.string.deeppurple), getResources().getString(R.color.deeppurple)));
        colors.add(new Color(getString(R.string.bluegrey), getResources().getString(R.color.bluegrey)));
        colors.add(new Color(getString(R.string.yellow), getResources().getString(R.color.yellow)));
        colors.add(new Color(getString(R.string.cyan), getResources().getString(R.color.cyan)));
        colors.add(new Color(getString(R.string.brown), getResources().getString(R.color.brown)));
        colors.add(new Color(getString(R.string.teal), getResources().getString(R.color.teal)));
    }

}
