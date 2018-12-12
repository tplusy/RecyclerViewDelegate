package top.plusy.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WangHui
 * Date: 2018/12/12.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SimpleData simpleData;
    private List<IDelegateAdapter> mAdapters = new ArrayList<>();

    public MyAdapter(SimpleData simpleData) {
        this.simpleData = simpleData;
    }

    public void addDelegateAdapter(IDelegateAdapter delegateAdapter) {
        mAdapters.add(delegateAdapter);
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("simon", "size = " + simpleData.dataList.size());
        for(IDelegateAdapter iDelegateAdapter : mAdapters) {
            if(iDelegateAdapter.isForViewType(simpleData)) {
                return mAdapters.indexOf(iDelegateAdapter);
            }
        }

        throw new RuntimeException("Can not find any Delegate Adapter");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        IDelegateAdapter delegateAdapter = mAdapters.get(viewType);
        RecyclerView.ViewHolder viewHolder = delegateAdapter.onCreateViewHolder(viewGroup, viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = viewHolder.getItemViewType();
        IDelegateAdapter delegateAdapter = mAdapters.get(viewType);
        delegateAdapter.onBindViewHolder(viewHolder, position, simpleData);
    }

    @Override
    public int getItemCount() {
        return simpleData.dataList.size();
    }
}
