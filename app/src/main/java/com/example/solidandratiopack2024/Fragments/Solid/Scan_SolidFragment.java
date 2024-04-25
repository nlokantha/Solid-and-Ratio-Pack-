package com.example.solidandratiopack2024.Fragments.Solid;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.solidandratiopack2024.Models.SolidPack;
import com.example.solidandratiopack2024.R;
import com.example.solidandratiopack2024.databinding.FragmentScanSolidBinding;

public class Scan_SolidFragment extends Fragment {

    private static final String ARG_PARAM_SCAN_SOLID = "ARG_PARAM_SCAN_SOLID";
    private SolidPack mSolidPack;

    public Scan_SolidFragment() {
        // Required empty public constructor
    }
    public static Scan_SolidFragment newInstance(SolidPack mSolidPack) {
        Scan_SolidFragment fragment = new Scan_SolidFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_SCAN_SOLID, mSolidPack);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSolidPack = (SolidPack) getArguments().getSerializable(ARG_PARAM_SCAN_SOLID);
        }
    }
    FragmentScanSolidBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentScanSolidBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(mSolidPack != null){
            binding.textViewBuyer.setText(mSolidPack.getBuyer());
            binding.textViewMethod.setText(mSolidPack.getMethod());
            binding.textViewPONumber.setText(mSolidPack.getPoNumber());
            binding.textViewCartons.setText(mSolidPack.getCartons());
            binding.textViewPieces.setText(mSolidPack.getPieces());
        }
        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoScanUPCFragment();
            }
        });
    }
    ScanSolidFragmentListener mListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ScanSolidFragmentListener) context;
    }

    public interface ScanSolidFragmentListener{
        void gotoScanUPCFragment();
    }
}