package com.example.solidandratiopack2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.solidandratiopack2024.Fragments.HomeFragment;
import com.example.solidandratiopack2024.Fragments.Solid.PoAndCarton_SolidFragment;
import com.example.solidandratiopack2024.Fragments.Solid.ScanUPC_SolidFragment;
import com.example.solidandratiopack2024.Fragments.Solid.Scan_SolidFragment;
import com.example.solidandratiopack2024.Models.SolidPack;

public class MainActivity extends AppCompatActivity implements HomeFragment.HomeFragmentListener,
        PoAndCarton_SolidFragment.PoAndCartonFragmentListener, ScanUPC_SolidFragment.ScanUPCFragmentListener, Scan_SolidFragment.ScanSolidFragmentListener {
    SolidPack mSolidPack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,new HomeFragment())
                .commit();
    }
    @Override
    public void selectedMethod(SolidPack solidPack) {
        this.mSolidPack = solidPack;
        String method = mSolidPack.getMethod();

        if (method.equals("Solid Pack")){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rootView, PoAndCarton_SolidFragment.newInstance(solidPack))
                    .addToBackStack(null)
                    .commit();
        } else if (method.equals("Ratio Pack")) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rootView,new PoAndCarton_SolidFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void gotoScanFragment(SolidPack solidPack) {
        this.mSolidPack = solidPack;

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ScanUPC_SolidFragment.newInstance(mSolidPack))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoHomeFragment() {
        getSupportFragmentManager().popBackStack();
    }


    @Override
    public void gotoPOandCartonFragment() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void gotoScanSolidFragment(SolidPack solidPack) {
        this.mSolidPack = solidPack;
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.rootView, Scan_SolidFragment.newInstance(mSolidPack))
                .commit();
    }

    @Override
    public void gotoScanUPCFragment() {
        getSupportFragmentManager().popBackStack();
    }
}