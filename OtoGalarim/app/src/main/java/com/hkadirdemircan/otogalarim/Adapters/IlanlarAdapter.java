package com.hkadirdemircan.otogalarim.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkadirdemircan.otogalarim.Models.IlanlarPojo;
import com.hkadirdemircan.otogalarim.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IlanlarAdapter extends BaseAdapter {

    List<IlanlarPojo> ılanlarPojoList;
    Context context;

    public List<IlanlarPojo> getIlanlarPojoList() {
        return ılanlarPojoList;
    }

    public void setIlanlarPojoList(List<IlanlarPojo> ılanlarPojoList) {
        this.ılanlarPojoList = ılanlarPojoList;
    }

    public IlanlarAdapter(List<IlanlarPojo> ılanlarPojoList, Context context) {
        this.ılanlarPojoList = ılanlarPojoList;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ılanlarPojoList.size();
    }

    @Override
    public Object getItem(int i) {
        return ılanlarPojoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.ilanlarlayout,viewGroup,false);
        TextView baslik,fiyat,adres;
        ImageView resim;

        baslik = (TextView)view.findViewById(R.id.ilanlarIlanBaslik);
        fiyat = (TextView)view.findViewById(R.id.ilanlarIlanFiyat);
        adres = (TextView)view.findViewById(R.id.ilanlarIlanAdres);
        resim = (ImageView) view.findViewById(R.id.ilanlarIlanResim);

        baslik.setText(ılanlarPojoList.get(i).getBaslik());
        fiyat.setText(ılanlarPojoList.get(i).getFiyat());
        adres.setText(ılanlarPojoList.get(i).getIl()+"  "+ılanlarPojoList.get(i).getIlce()+"  "+ılanlarPojoList.get(i).getMahalle());

        Picasso.with(context).load("http://kadirdemircan.tk/"+ılanlarPojoList.get(i).getResim()).resize(100,100).into(resim);

        return view;
    }
}
