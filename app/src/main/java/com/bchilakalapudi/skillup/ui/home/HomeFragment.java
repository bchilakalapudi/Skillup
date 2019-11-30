package com.bchilakalapudi.skillup.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bchilakalapudi.skillup.BankActivity;
import com.bchilakalapudi.skillup.R;

import com.bchilakalapudi.skillup.SalesforceActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private String evtSource="";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
      /*  final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("A03E8CB1F034A0790951F2713CE1E0CE").build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("A03E8CB1F034A0790951F2713CE1E0CE").build());
      //  mInterstitialAd.show();
        Button bankbtn=(Button)root.findViewById(R.id.btn_bank_exams);
        bankbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   mInterstitialAd.show();
                evtSource="Bank";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button btn_salesforce=(Button)root.findViewById(R.id.btn_salesforce);
        btn_salesforce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="Salesforce";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.

            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("A03E8CB1F034A0790951F2713CE1E0CE").build());
               if(evtSource.equals("Bank")) {
                   Intent intent = new Intent(getActivity(), BankActivity.class);
                   // intent.putExtra("EXTRA_User", us);
                   startActivity(intent);
               }
                if(evtSource.equals("Salesforce")) {
                    Intent intent = new Intent(getActivity(), SalesforceActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
            }
        });

        return root;
    }
}