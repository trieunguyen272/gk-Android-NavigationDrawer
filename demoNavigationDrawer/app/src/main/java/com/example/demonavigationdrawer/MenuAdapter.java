package com.example.demonavigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemMenu> list;

    public MenuAdapter (Context context, int layout, List<ItemMenu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {
        TextView tv;
        ImageView imgv;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tvItem);
            viewHolder.imgv = (ImageView) convertView.findViewById(R.id.imgIcon);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
            //sử dụng 1 view đã tồn tại
        }
        viewHolder.tv.setText(list.get(position).tenItem);
        viewHolder.imgv.setImageResource(list.get(position).Icon);
        return convertView;
    }

}
//LayoutInflater đơn giản là tạo ra một View mới từ layout resource. Đoạn code trên đang kiểm tra xem convertView
// có phải là một View được tái chế do adapter không.
// Nếu không phải (convertView==null) thì tạo một View mới theo cấu trúc của resource layout.