package com.example.solidandratiopack2024.Fragments.Solid;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.solidandratiopack2024.Models.SolidPack;
import com.example.solidandratiopack2024.databinding.FragmentScanUPCBinding;

public class ScanUPC_SolidFragment extends Fragment {

    private static final String ARG_PARAM_SCAN_UPC = "ARG_PARAM_SCAN_UPC";

    private SolidPack mSolidPack;

    public ScanUPC_SolidFragment() {
        // Required empty public constructor
    }

    public static ScanUPC_SolidFragment newInstance(SolidPack mSolidPack) {
        ScanUPC_SolidFragment fragment = new ScanUPC_SolidFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_SCAN_UPC, mSolidPack);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSolidPack = (SolidPack) getArguments().getSerializable(ARG_PARAM_SCAN_UPC);
        }
    }
    FragmentScanUPCBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentScanUPCBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mSolidPack != null){
            binding.textViewBuyer.setText(mSolidPack.getBuyer());
            binding.textViewMethod.setText(mSolidPack.getMethod());
            binding.textViewPONumber.setText(mSolidPack.getPoNumber());
            binding.textViewCartons.setText(mSolidPack.getCartons());
        }

        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoPOandCartonFragment();
            }
        });

        binding.imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cartonNumber = binding.editTextCartonNumber.getText().toString();
                String upcNumber = binding.editTextUPCNumber.getText().toString();
                String pieces = binding.editTextMaximumPieces.getText().toString();

                if (cartonNumber.isEmpty()){
                    Toast.makeText(getActivity(), "Please Scan Carton Number", Toast.LENGTH_SHORT).show();
                } else if (upcNumber.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Scan UPC Number", Toast.LENGTH_SHORT).show();
                } else if (pieces.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter Maximum Piece", Toast.LENGTH_SHORT).show();
                }else {
                    mSolidPack.setCartonNumber(cartonNumber);
                    mSolidPack.setUpcNumber(upcNumber);
                    mSolidPack.setPieces(pieces);
                    mListener.gotoScanSolidFragment(mSolidPack);

                }

            }
        });

    }
    ScanUPCFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ScanUPCFragmentListener) context;
    }

    public interface ScanUPCFragmentListener{
        void gotoPOandCartonFragment();
        void gotoScanSolidFragment(SolidPack solidPack);
    }
}