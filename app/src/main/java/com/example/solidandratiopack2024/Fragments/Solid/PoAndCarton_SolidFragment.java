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
import com.example.solidandratiopack2024.databinding.FragmentPoAndCartonSBinding;


public class PoAndCarton_SolidFragment extends Fragment {

    private static final String ARG_PARAM_SOLID_PACK = "ARG_PARAM_SOLID_PACK";

    private SolidPack mSolidPack;

    public PoAndCarton_SolidFragment() {
        // Required empty public constructor
    }

    public static PoAndCarton_SolidFragment newInstance(SolidPack mSolidPack) {
        PoAndCarton_SolidFragment fragment = new PoAndCarton_SolidFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_SOLID_PACK, mSolidPack);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSolidPack = (SolidPack) getArguments().getSerializable(ARG_PARAM_SOLID_PACK);

        }
    }
    FragmentPoAndCartonSBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentPoAndCartonSBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mSolidPack != null){
            binding.textViewBuyer.setText(mSolidPack.getBuyer());
            binding.textViewMethod.setText(mSolidPack.getMethod());
        }

        binding.imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poNumber = binding.editTextPoNumber.getText().toString();
                String cartons = binding.editTextCartons.getText().toString();
                if (poNumber.isEmpty()){
                    Toast.makeText(getActivity(), "Enter PO Number", Toast.LENGTH_SHORT).show();
                } else if (cartons.isEmpty()) {
                    Toast.makeText(getActivity(), "Enter Carton Number", Toast.LENGTH_SHORT).show();
                }else {
                    mSolidPack.setPoNumber(poNumber);
                    mSolidPack.setCartons(cartons);
                    mListener.gotoScanFragment(mSolidPack);

                }
            }
        });
        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoHomeFragment();
            }
        });
    }
    PoAndCartonFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (PoAndCartonFragmentListener) context;
    }

    public interface PoAndCartonFragmentListener{
            void gotoScanFragment(SolidPack solidPack);
            void gotoHomeFragment();
    }
}