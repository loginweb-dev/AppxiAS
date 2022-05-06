package com.loginweb.appxi.ui.historial;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.loginweb.appxi.R;
import com.loginweb.appxi.databinding.HistorialFragmentBinding;
import com.loginweb.appxi.databinding.SoporteFragmentBinding;

public class HistorialFragment extends Fragment {

    private HistorialViewModel mViewModel;
    private HistorialFragmentBinding binding;
    private WebView miweb;
    public static HistorialFragment newInstance() {
        return new HistorialFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.historial_fragment, container, false);
        binding = HistorialFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        miweb = root.findViewById(R.id.miweb);
        WebSettings webSettings = miweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        miweb.setWebViewClient(new WebViewClient());
        miweb.loadUrl("https://appxi.loginweb.dev/historial/cliente");
        return root;
    }

}