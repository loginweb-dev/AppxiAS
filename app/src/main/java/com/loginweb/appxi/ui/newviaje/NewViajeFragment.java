package com.loginweb.appxi.ui.newviaje;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.loginweb.appxi.R;
import com.loginweb.appxi.databinding.NewViajeFragmentBinding;

public class NewViajeFragment extends Fragment {

    private NewViajeViewModel mViewModel;
    private NewViajeFragmentBinding binding;
    private WebView miweb;

    public static NewViajeFragment newInstance() {
        return new NewViajeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = NewViajeFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        miweb = root.findViewById(R.id.miweb);
        WebSettings webSettings = miweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        miweb.setWebViewClient(new WebViewClient());
        miweb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, false);
            }
        });
        miweb.loadUrl("https://appxi.loginweb.dev/viaje/crear");
        return root;
    }

}