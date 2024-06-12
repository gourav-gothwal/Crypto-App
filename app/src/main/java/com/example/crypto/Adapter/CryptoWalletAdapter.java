package com.example.crypto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.crypto.Domain.CryptoWallet;
import com.example.crypto.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CryptoWalletAdapter extends RecyclerView.Adapter<CryptoWalletAdapter.Viewholder>{
    ArrayList<CryptoWallet> cryptoWallets;
    DecimalFormat formatter;

    public CryptoWalletAdapter(ArrayList<CryptoWallet> cryptoWallets) {
        this.cryptoWallets = cryptoWallets;
        formatter = new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public CryptoWalletAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoWalletAdapter.Viewholder holder, int position) {
        holder.cryptoSymbolTxt.setText(cryptoWallets.get(position).getCryptoSymbol());
        holder.cryptoBalancedTxt.setText("Rs."+formatter.format(cryptoWallets.get(position).getCryptoBalance()));
        holder.changePercentTxt.setText(cryptoWallets.get(position).getChangePercent()+"%");
        holder.propertyAmountTxt.setText(cryptoWallets.get(position).getPropertyAmount()+""+cryptoWallets.get(position).getCryptoSymbol());

        int drawableResourceId=holder.itemView.getContext().getResources()
                .getIdentifier(cryptoWallets.get(position).getPicUrl(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.logoCrypto);

        try{
            if(cryptoWallets.get(position).getCryptoBalance() >=0){
                holder.changePercentTxt.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.green));
            }else{
                holder.changePercentTxt.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.red));
            }
        }catch(Exception e){}
    }

    @Override
    public int getItemCount() {
        return cryptoWallets.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView cryptoSymbolTxt,cryptoBalancedTxt,changePercentTxt,propertyAmountTxt;
        ImageView logoCrypto;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cryptoSymbolTxt = itemView.findViewById(R.id.symbolTxt);
            cryptoBalancedTxt = itemView.findViewById(R.id.balance);
            changePercentTxt = itemView.findViewById(R.id.percentTxt);
            propertyAmountTxt = itemView.findViewById(R.id.amount);
            logoCrypto = itemView.findViewById(R.id.pic);
        }
    }
}