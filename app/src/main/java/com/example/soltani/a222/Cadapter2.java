package com.example.soltani.a222;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Soltani on 22/12/2016.
 */

public class Cadapter2 extends BaseAdapter{
    static ArrayList<ListProduit> tab1 = new ArrayList<ListProduit>();

    public Cadapter2(ArrayList<ListProduit> tab1) {

        this.tab1 = tab1;

    }

    public int getCount() {
        return tab1.size() ;
    }


    public Object getItem(int position) {
        return tab1.get(position).libelle;
    }


    public long getItemId(int position) {
        return position ;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        TextView prix=(TextView)view2.findViewById(R.id.prix);
        TextView qte=(TextView)view2.findViewById(R.id.qte);
        TextView description=(TextView)view2.findViewById(R.id.description);
        TextView libelle=(TextView)view2.findViewById(R.id.nom);


        libelle.setText(tab1.get(position).libelle);
        prix.setText(tab1.get(position).prix);
        qte.setText(tab1.get(position).qte);
        description.setText(tab1.get(position).description);


        return view2;
    }


}


