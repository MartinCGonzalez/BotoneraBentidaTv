package com.botonerabenditatv.botonerabendita;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SonidosFragment extends Fragment {

    public SonidosFragment(){}

    public static SonidosFragment newInstance(){
        SonidosFragment fragment = new SonidosFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoundManager.getInstance().init(getContext());
        getActivity().setVolumeControlStream(3);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar el layout para este fragmento
        final View root = inflater.inflate(R.layout.fragment_sonidos, container, false);

        GridView gridview = (GridView) root.findViewById(R.id.gridSonidos);
        gridview.setBackgroundResource(R.drawable.fondo);
        gridview.setAdapter(new ButtonAdapter(getContext()));

        AdView mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        return  root;
    }
}
