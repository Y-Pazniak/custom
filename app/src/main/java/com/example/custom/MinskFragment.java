package com.example.custom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MinskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_minsk, container, false);

        final Intent[] intent = {null};

        Button orlovskayaCall = view.findViewById(R.id.orlovskaya_call);
        Button orlovskayaRoute = view.findViewById(R.id.orlovskaya_route);
        Button kolyadichiCall = view.findViewById(R.id.kolyadichi_call);
        Button kolyadichiRoute = view.findViewById(R.id.kolyadichi_route);
        Button sezCall = view.findViewById(R.id.sez_call);
        Button sezRoute = view.findViewById(R.id.sez_route);
        Button kulttorgCall = view.findViewById(R.id.kulttorg_call);
        Button kulttorgRoute = view.findViewById(R.id.kulttorg_route);
        View.OnClickListener onClickListener = (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                initialListener(v, intent[0]);
            }
        });

        orlovskayaCall.setOnClickListener(onClickListener);
        orlovskayaRoute.setOnClickListener(onClickListener);
        kolyadichiCall.setOnClickListener(onClickListener);
        kolyadichiRoute.setOnClickListener(onClickListener);
        sezCall.setOnClickListener(onClickListener);
        sezRoute.setOnClickListener(onClickListener);
        kulttorgCall.setOnClickListener(onClickListener);
        kulttorgRoute.setOnClickListener(onClickListener);

        return view;
    }

    private void initialListener(View view, Intent intent) {
        intent = null;
        switch (view.getId()){
            case R.id.orlovskaya_call: intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+375 44 580 31 66"));
                startActivity(intent);
                break;
            case R.id.orlovskaya_route: intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.932734, 27.555669"));
                startActivity(intent);
                break;

            case R.id.kolyadichi_call: intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+375 29 122 81 12"));
                startActivity(intent);
                break;
            case R.id.kolyadichi_route: intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.800841, 27.593587"));
                startActivity(intent);
                break;

            case R.id.sez_call: intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+375 44 580 82 88"));
                startActivity(intent);
                break;
            case R.id.sez_route: intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.848595, 27.684011"));
                startActivity(intent);
                break;

            case R.id.kulttorg_call: intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+375 29 616 74 02"));
                startActivity(intent);
                break;
            case R.id.kulttorg_route: intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.847368, 27.415433"));
                startActivity(intent);
                break;
        }
    }
}