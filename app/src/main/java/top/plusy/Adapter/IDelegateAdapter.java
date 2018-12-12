package top.plusy.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Author: WangHui
 * Date: 2018/12/12.
 */
public interface IDelegateAdapter {
    //是否是委托类需要处理的类型
    boolean isForViewType(SimpleData data);

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType);
    void onBindViewHolder(RecyclerView.ViewHolder holder, int position, SimpleData data);
}
