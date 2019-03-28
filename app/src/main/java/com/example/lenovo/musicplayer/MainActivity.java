package com.example.lenovo.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ArrayList<music> arrayList;
   private musicAdapter adapter;
   private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        arrayList=new ArrayList<music>();
        arrayList.add(new music("UD da Punjab","Unknown",R.raw.ud));
        arrayList.add(new music("Chitta","Unknown",R.raw.chit));
        arrayList.add(new music("Jhak","Unknown",R.raw.jhak));
        arrayList.add(new music("5 Taara","Diljeet",R.raw.panj));
        arrayList.add(new music("Chargi","Babbu Maan",R.raw.chargi));
        adapter= new musicAdapter(this,R.layout.music,arrayList);
        listView.setAdapter(adapter);

    }
}
