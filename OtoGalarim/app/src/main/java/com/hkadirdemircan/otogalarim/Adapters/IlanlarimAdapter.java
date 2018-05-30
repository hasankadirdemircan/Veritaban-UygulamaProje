package com.hkadirdemircan.otogalarim.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkadirdemircan.otogalarim.Models.IlanlarimPojo;
import com.hkadirdemircan.otogalarim.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IlanlarimAdapter extends BaseAdapter {

    List<IlanlarimPojo> list;
    Context context; //layout tanimlamak icin.
    Activity activity;
    String uye_id, ilan_id;


    public IlanlarimAdapter(List<IlanlarimPojo> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.ilanlarimlayout, viewGroup, false);
        ImageView resim;
        TextView baslik, fiyat;



        resim = (ImageView)view.findViewById(R.id.ilanlarimIlanResim);
        baslik = (TextView) view.findViewById(R.id.ilanlarimIlanBaslik);
        fiyat = (TextView)view.findViewById(R.id.ilanlarimIlanFiyat);
        ilan_id = list.get(i).getIlanid();
        uye_id = list.get(i).getUyeid();



        baslik.setText(list.get(i).getBaslik());
        fiyat.setText(list.get(i).getFiyat());

        Picasso.with(context).load("http://kadirdemircan.tk/"+list.get(i).getResim()).resize(100,100).into(resim);

        return view;
    }
}
