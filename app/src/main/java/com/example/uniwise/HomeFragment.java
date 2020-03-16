package com.example.uniwise;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList<String> eventArray=new ArrayList<>();
        eventArray.add("TECHNOFEST");
        eventArray.add("EXAM FEE");
        eventArray.add("RESULT");
        RecyclerView recyclerView=view.findViewById(R.id.EventsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        EventAdapter eventAdapter=new EventAdapter(getActivity(),eventArray);
        recyclerView.setAdapter(eventAdapter);
        return view;

    }

}
