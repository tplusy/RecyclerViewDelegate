package top.plusy.recyclerviewdelegate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import top.plusy.Adapter.MyAdapter;
import top.plusy.Adapter.MyData;
import top.plusy.Adapter.SimpleAdapter;
import top.plusy.Adapter.SimpleData;
import top.plusy.Adapter.SimpleItemTouchHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private SimpleData<MyData> simpleData = new SimpleData<>(1);
    private MyAdapter myAdapter = new MyAdapter(simpleData);
    private int numbers = 0;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.simpleRecyclerView);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        myAdapter.addDelegateAdapter(new SimpleAdapter());
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.VERTICAL, 4, android.R.color.background_dark));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SimpleItemTouchHelper(myAdapter, simpleData));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onClick(View v) {
        numbers+=1;
        MyData myData = new MyData("Hello " + numbers);
        simpleData.dataList.add(myData);
        int pos = simpleData.dataList.indexOf(myData);
        myAdapter.notifyItemInserted(pos);
    }
}
