package top.plusy.Adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;

/**
 * Author: WangHui
 * Date: 2018/12/13.
 */
public class SimpleItemTouchHelper extends ItemTouchHelper.Callback {
    private MyAdapter myAdapter;
    private SimpleData simpleData;

    public SimpleItemTouchHelper(MyAdapter myAdapter, SimpleData simpleData) {
        this.myAdapter = myAdapter;
        this.simpleData = simpleData;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.UP|ItemTouchHelper.DOWN, ItemTouchHelper.START|ItemTouchHelper.END);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        int from = viewHolder.getAdapterPosition();
        int to = viewHolder1.getAdapterPosition();
        Collections.swap(simpleData.dataList, from, to);
        myAdapter.notifyItemMoved(from, to);
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int pos = viewHolder.getAdapterPosition();
        simpleData.dataList.remove(pos);
        myAdapter.notifyItemRemoved(pos);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            assert viewHolder != null;
            viewHolder.itemView.setBackgroundColor(0xff808080);
        }
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundResource(android.R.color.background_light);
    }
}
