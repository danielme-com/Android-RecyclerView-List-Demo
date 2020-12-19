package com.danielme.android.recyclerview.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielme.com
 */
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setupToolbar();

    setupRecyclerView();
  }

  private void setupToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void setupRecyclerView() {
    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    final List<Color> colors = buildColors();
    recyclerView.setAdapter(new MaterialPaletteAdapter(colors, new RecyclerViewOnItemClickListener() {
      @Override
      public void onClick(View v, int position) {
        String text = position + " " + colors.get(position).getName();
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
      }
    }));
    //VERTICAL
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    //HORIZONTAL
    //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
            ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
    recyclerView.addItemDecoration(dividerItemDecoration);
  }

  @SuppressWarnings("ResourceType")
  private List<Color> buildColors() {
    List<Color> colors = new ArrayList<>();
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
    return colors;
  }

}
