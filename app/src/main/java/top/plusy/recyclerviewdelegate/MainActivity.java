package top.plusy.recyclerviewdelegate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import top.plusy.Adapter.MyAdapter;
import top.plusy.Adapter.MyData;
import top.plusy.Adapter.SimpleAdapter;
import top.plusy.Adapter.SimpleData;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private SimpleData<MyData> simpleData = new SimpleData<>(1);
    private MyAdapter myAdapter = new MyAdapter(simpleData);

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.simpleRecyclerView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        simpleData.dataList.add(new MyData("Hello"));
        //myAdapter = new MyAdapter(simpleData);
        myAdapter.addDelegateAdapter(new SimpleAdapter());
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onClick(View v) {
        simpleData.dataList.add(new MyData("Hello"));
        myAdapter.notifyDataSetChanged();
    }
}
