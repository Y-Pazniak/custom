package com.example.custom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmployeesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView servicesRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_employees, container, false);

        String[] employeesNames = new String[Employee.employees.length];
        for (int i = 0; i < employeesNames.length; i++) {
            employeesNames[i] = Employee.employees[i].getEmployeeName();
        }

        String[] employeesDescr = new String[Employee.employees.length];
        for (int i = 0; i < employeesDescr.length; i++) {
            employeesDescr[i] = Employee.employees[i].getEmployeeDescr();
        }

        int[] employeesPhoto = new int[Employee.employees.length];
        for (int i = 0; i < employeesPhoto.length; i++) {
            employeesPhoto[i] = Employee.employees[i].getEmployeePhoto();
        }

        CardEmployeesAdapter adapter = new CardEmployeesAdapter(employeesNames, employeesDescr, employeesPhoto);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        servicesRecycler.setLayoutManager(layoutManager);
        servicesRecycler.setAdapter(adapter);
        return servicesRecycler;
    }
}