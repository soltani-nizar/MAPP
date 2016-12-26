package com.example.soltani.a222;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class Cadapter extends BaseAdapter {
    static ArrayList<ListProduit> tab = new ArrayList<ListProduit>();

    public Cadapter(ArrayList<ListProduit> tab) {

        this.tab = tab;

    }

    @Override
    public int getCount() {
        return tab.size() ;
    }

    @Override
    public Object getItem(int position) {
        return tab.get(position).libelle;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        TextView prix=(TextView)view.findViewById(R.id.prix);
        TextView qte=(TextView)view.findViewById(R.id.qte);
        TextView description=(TextView)view.findViewById(R.id.description);

        TextView libelle=(TextView)view.findViewById(R.id.nom);


        libelle.setText(tab.get(position).libelle);
        prix.setText(tab.get(position).prix);
        qte.setText(tab.get(position).qte);
        description.setText(tab.get(position).description);


        return view;
    }


}
