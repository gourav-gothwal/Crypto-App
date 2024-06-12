package com.example.crypto.activity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListAdapter;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crypto.Adapter.CryptoWalletAdapter;
import com.example.crypto.Domain.CryptoWallet;
import com.example.crypto.R;
import com.example.crypto.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerviewInit();
    }

    private void RecyclerviewInit() {


        ArrayList<CryptoWallet> cryptoWalletArrayList = new ArrayList<>();
        cryptoWalletArrayList.add(new CryptoWallet("BTC", "btc", 2.13, 1.4, 14021.35));
        cryptoWalletArrayList.add(new CryptoWallet("ETH", "eth", -1.13, 3.6, 2145.21));
        cryptoWalletArrayList.add(new CryptoWallet("XRP", "xrp", -3.14, 2.6, 21463.10));
        cryptoWalletArrayList.add(new CryptoWallet("LTC", "ltc", 4.45, 3.5, 5412.46));

        binding.list.setLayoutManager(new GridLayoutManager(this, 2));
        binding.list.setAdapter(new CryptoWalletAdapter(cryptoWalletArrayList));
    }
}