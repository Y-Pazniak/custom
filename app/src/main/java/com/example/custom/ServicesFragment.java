package com.example.custom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ServicesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView servicesRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_services, container, false);

        String[] servicesNames = new String[Service.services.length];
        for (int i = 0; i < servicesNames.length; i++) {
            servicesNames[i] = Service.services[i].getServiceName();
        }

        int[] servicesImages = new int[Service.services.length];
        for (int i = 0; i < servicesImages.length; i++) {
            servicesImages[i] = Service.services[i].getServicePicture();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(servicesNames, servicesImages);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        servicesRecycler.setLayoutManager(layoutManager);
        servicesRecycler.setAdapter(adapter);
        return servicesRecycler;
    }
}