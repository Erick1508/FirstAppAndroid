package com.example.marrero.xavier.erick.myapplicationfirst;

/**
 * Created by user on 26-ene-16.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BandasAdapter extends ArrayAdapter<Bandas>{
    Context context;
    int LayoutResortId;
    Bandas data[]= null;

    public BandasAdapter(Context context, int layoutResortId, Bandas[] data) {
        super(context, layoutResortId,data);

        this.context= context;
        this.LayoutResortId= layoutResortId;
        this.data= data;

    }

    public View getView(int position, View contentView, ViewGroup parent){
        View row= contentView;
        BandasHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row= inflater.inflate(LayoutResortId, parent, false);

            holder= new BandasHolder();
            holder.imagen= (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById((R.id.tv));
            row.setTag(holder);
        }
        else{
            holder= (BandasHolder) row.getTag();
        }

        Bandas bandas = data[position];
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);


        return row;
    }

    static class BandasHolder{
        ImageView imagen;
        TextView texto;
    }
}