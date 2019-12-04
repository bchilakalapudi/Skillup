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

import com.bchilakalapudi.skillup.CSSActivity;
import com.bchilakalapudi.skillup.DotNetActivity;
import com.bchilakalapudi.skillup.HTMLActivity;
import com.bchilakalapudi.skillup.JavaActivity;
import com.bchilakalapudi.skillup.MySQLActivity;
import com.bchilakalapudi.skillup.PHPActivity;
import com.bchilakalapudi.skillup.R;

import com.bchilakalapudi.skillup.SalesforceActivity;
import com.bchilakalapudi.skillup.VlocityActivity;
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
        mInterstitialAd.setAdUnitId("ca-app-pub-6536530345445965/4955114872");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice("A03E8CB1F034A0790951F2713CE1E0CE").build());
      //  mInterstitialAd.show();
        Button bankbtn=(Button)root.findViewById(R.id.home_html_btn);
        bankbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   mInterstitialAd.show();
                evtSource="HTML";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button home_css_btn=(Button)root.findViewById(R.id.home_css_btn);
        home_css_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="CSS";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });
        Button home_salesforce_btn=(Button)root.findViewById(R.id.home_salesforce_btn);
        home_salesforce_btn.setOnClickListener(new View.OnClickListener() {
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

        Button home_dotnet_btn=(Button)root.findViewById(R.id.home_dotnet_btn);
        home_dotnet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="DotNet";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button home_java_btn=(Button)root.findViewById(R.id.home_java_btn);
        home_java_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="Java";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button home_mysql_btn=(Button)root.findViewById(R.id.home_mysql_btn);
        home_mysql_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="MySQL";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button home_php_btn=(Button)root.findViewById(R.id.home_php_btn);
        home_php_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="PHP";
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });

        Button home_vlocity_btn=(Button)root.findViewById(R.id.home_vlocity_btn);
        home_vlocity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   mInterstitialAd.show();
                evtSource="Vlocity";
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
               if(evtSource.equals("HTML")) {
                   Intent intent = new Intent(getActivity(), HTMLActivity.class);
                   // intent.putExtra("EXTRA_User", us);
                   startActivity(intent);
               }
                if(evtSource.equals("CSS")) {
                    Intent intent = new Intent(getActivity(), CSSActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("Salesforce")) {
                    Intent intent = new Intent(getActivity(), SalesforceActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("Vlocity")) {
                    Intent intent = new Intent(getActivity(), VlocityActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("Java")) {
                    Intent intent = new Intent(getActivity(), JavaActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("MySQL")) {
                    Intent intent = new Intent(getActivity(), MySQLActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("PHP")) {
                    Intent intent = new Intent(getActivity(), PHPActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
                if(evtSource.equals("DotNet")) {
                    Intent intent = new Intent(getActivity(), DotNetActivity.class);
                    // intent.putExtra("EXTRA_User", us);
                    startActivity(intent);
                }
            }
        });

        return root;
    }
}