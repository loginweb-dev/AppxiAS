package com.loginweb.appxi.ui.choferperfil;

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
import com.loginweb.appxi.databinding.ChoferPerfilFragmentBinding;
import com.loginweb.appxi.databinding.NewViajeFragmentBinding;

public class ChoferPerfilFragment extends Fragment {

    private ChoferPerfilViewModel mViewModel;
    private ChoferPerfilFragmentBinding binding;
    private WebView miweb;
    public static ChoferPerfilFragment newInstance() {
        return new ChoferPerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.chofer_perfil_fragment, container, false);
        binding = ChoferPerfilFragmentBinding.inflate(inflater, container, false);
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
        miweb.loadUrl("https://appxi.loginweb.dev/perfil/chofer");
        return root;
    }
}