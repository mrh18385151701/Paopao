package com.zdk.paopao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zdk.paopao.R;
import com.zdk.paopao.bean.ImageInfo;


import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */

public class ImageAdapter extends BaseAdapter {
    List<ImageInfo> imageDataList;
    Context context;

    public ImageAdapter(List<ImageInfo> imageDataList, Context context) {
        this.imageDataList = imageDataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view == null){
            view=View.inflate(context, R.layout.item_image,null);
            holder=new ViewHolder();
            holder.userAvatar=view.findViewById(R.id.user_avatar);
            holder.username=view.findViewById(R.id.username);
            holder.publishTime=view.findViewById(R.id.user_publishtime);
            holder.content=view.findViewById(R.id.content);
            holder.image_content=view.findViewById(R.id.image_content);
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        ImageInfo imageInfo=imageDataList.get(i);
        Glide.with(context).load(imageInfo.getAvatar()).into(holder.userAvatar);
        holder.username.setText(imageInfo.getUsername());
        holder.content.setText(imageInfo.getContent());

        return view;
    }
    private class ViewHolder{
        ImageView userAvatar;
        TextView username;
        TextView publishTime;
        TextView content;
        ImageView image_content;
        TextView comment;
        TextView good;

    }
}
