package light.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class MyAdapter<T> extends BaseAdapter {

    private final List<T> datas;

    private final Context context;
    private int layoutid;
    private LayoutInflater inflater;

    public MyAdapter(Context context,List<T> data,int layoutid){
        this.context=context;
        this.datas=data;
        this.layoutid=layoutid;
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=ViewHolder.getViewHolder(context,convertView,parent,layoutid,position);
        convert(viewHolder,getItem(position));
        return null;
    }
    public abstract void convert(ViewHolder viewHolder,T t);
}
