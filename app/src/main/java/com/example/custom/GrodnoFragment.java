package com.example.custom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GrodnoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grodno, container, false);

        Button callButton = view.findViewById(R.id.grodno_call_button);
        Button mailButton = view.findViewById(R.id.grodno_mail_button);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (view.getId()){
                    case R.id.grodno_call_button:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+375 44 580 82 96"));
                        startActivity(intent);
                        break;
                    case R.id.grodno_mail_button:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.655971, 23.811913"));
                        startActivity(intent);
                        break;
                }
            }
        };

        callButton.setOnClickListener(onClickListener);
        mailButton.setOnClickListener(onClickListener);
        return view;
    }
}