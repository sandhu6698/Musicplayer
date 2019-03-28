package com.example.lenovo.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class musicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
private boolean flag = true;
    private MediaPlayer mediaPlayer;
    private ArrayList<music> arrayList;

    public musicAdapter(Context context, int layout, ArrayList<music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }
    private class ViewHolder{
        TextView name,artist;
        ImageView iplay,istop;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(layout,null);
            viewHolder.name=(TextView)convertView.findViewById(R.id.name);
            viewHolder.artist=(TextView)convertView.findViewById(R.id.artist);
            viewHolder.iplay=(ImageView) convertView.findViewById(R.id.play);
            viewHolder.istop=(ImageView) convertView.findViewById(R.id.stop);
            convertView.setTag(viewHolder);
        }
         else{
          viewHolder=(ViewHolder)convertView.getTag();
        }
        final music m = arrayList.get(position);
        viewHolder.name.setText(m.getName());
        viewHolder.artist.setText(m.getArtist());
        viewHolder.iplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,m.getSong());
                    flag=false;
                    }

                    if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.iplay.setImageResource(R.drawable.player);
                    }else{
                    mediaPlayer.start();
                        viewHolder.iplay.setImageResource(R.drawable.pause1);

                    }
            }
        });

        viewHolder.istop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                viewHolder.iplay.setImageResource(R.drawable.player);
            }
        });
        return convertView;
    }
}
