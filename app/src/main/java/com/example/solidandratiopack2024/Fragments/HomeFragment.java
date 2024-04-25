package com.example.solidandratiopack2024.Fragments;

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
import com.example.solidandratiopack2024.R;
import com.example.solidandratiopack2024.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buyer = binding.editTextSelectBuyer.getText().toString();
                String method = binding.editTextSelectMethod.getText().toString();
                if (buyer.isEmpty()){
                    Toast.makeText(getActivity(), "Please Select Buyer", Toast.LENGTH_SHORT).show();
                } else if (method.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Select Buyer", Toast.LENGTH_SHORT).show();
                }else {
                    SolidPack solidPack = new SolidPack(buyer,method);
                    mListener.selectedMethod(solidPack);
                }
            }
        });
    }
    HomeFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (HomeFragmentListener) context;
    }

    public interface HomeFragmentListener{
        void selectedMethod(SolidPack solidPack);

    }
}