package top.plusy.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import top.plusy.recyclerviewdelegate.R;

/**
 * Author: WangHui
 * Date: 2018/12/12.
 */
public class SimpleAdapter implements IDelegateAdapter {
    @Override
    public boolean isForViewType(SimpleData data) {
        return data.dataType == 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_layout, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, SimpleData data) {
        SimpleViewHolder simpleViewHolder = (SimpleViewHolder) holder;
        MyData myData = (MyData)data.dataList.get(position);
        simpleViewHolder.title.setText(myData.title);
    }

    static class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
        }
    }
}
