package com.reidzeibel.animatedadaptersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        List<SampleItem> sampleItemList = new ArrayList<>();
        SampleAdapter adapter = new SampleAdapter(recyclerView, sampleItemList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL));

        sampleItemList.add(new SampleItem("test1", "Exorcizamus te, omnis immundus spiritus"));
        sampleItemList.add(new SampleItem("test2", "omnis satanica potestas, omnis incursio infernalis adversarii"));
        sampleItemList.add(new SampleItem("test3", "omnis congregatio et secta diabolica"));
        sampleItemList.add(new SampleItem("test4", "Ergo, draco maledicte"));
        sampleItemList.add(new SampleItem("test5", "et omnis legio diabolica adjuramus te."));
        sampleItemList.add(new SampleItem("test6", "Ecclesiam tuam securi tibi facias libertate servire,"));
        sampleItemList.add(new SampleItem("test7", "te rogamus, audi nos."));
        adapter.notifyDataSetChanged();
    }
}
