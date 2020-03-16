package com.example.uniwise;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentFragment extends Fragment {
    String[] IT={ "Applied Mathematics-1", "Applied Mathematics-2", "Basics Of IT",
            "Computer Workshop", "Communication Skills", "Client Side Scripting Using Javascript",
            "Computer Security", "Development Of Softskills-1", "Development Of Softskills-2",
            "Digital Technics and Microprocessor", "Data Structure", "Data Communication and Networking",
            "Database Administrator", "English", "Environmental Science", "Engineering Physics",
            "Engineering Mathematics", "E-Commerce", "Fundamentals Of Electronics", "Fundamentals Of Electrical",
            "Graphics and Gaming Technology", "Java Programming-1", "Java Programming-2", "Linux Basics", "Multimedia and Animation",
            "Management Information System", "Mobile Application Development", "Network Management and Administration", "Operating System",
            "Programming in C", "Programming using .Net", "Project and Seminar", "Relational Database Management", "Software Engineering",
            "Software Testing","Server Side Scripting Using PHP", "Web Designing Using HTML"};
    String[] ITcode={ "SC181"," SC182", "IT281", "CM283", "HU182", "IT482", "CM485"," NC481", "NC482"," IT381", "CM387", "IT383", "IT581", "HU181",
            "AU481", "SC183", "SC282", " AU486", "ET284"," EE283", "IT584", "CM389", "CM482", "CM284", "IT382", "MA487", "IT481"," CM586", "IT385", "CM282",
            " IT483", "CM481"," IT384"," IT484"," CM486", "IT582", "CM285"};
    String[] COMP={"Android","NMA","JSP"};
    String[] MECH={"Power Engineering","Mechanics","CAD"};
    String[] CIVIL={"civil1","civil2","civil3","civil4","civil5"};
    String[] ELECTRICAL={"elec1","elec2","elec3","elec4","elec5"};
    String[] ENTC={"entc1","entc2","entc3","entc4","entc5"};
    String[] META={"Meta1","Meta2","Meta3","Meta4","Meta5"};
    String[] DDGM={"DDGM1","DDGM2","DDGM3","DDGM4","DDGM5"};
    String[] MATHS={"M1","M2","M3"};
    String[] ENGLISH={"English","CMS"};
    String[] PHYSICS={"Engg Physics"};
    String[] CHEM={"Chemistry"};

    public DepartmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_department, container, false);

        CardView cdIT=(CardView)rootView.findViewById(R.id.itCard);
        CardView cdComp=(CardView)rootView.findViewById(R.id.compCard);
        CardView cdMech=(CardView)rootView.findViewById(R.id.mechanicalCard);
        CardView cdCivil=(CardView)rootView.findViewById(R.id.civilCard);
        CardView cdElectric=(CardView)rootView.findViewById(R.id.electricalCard);
        CardView cdENTC=(CardView)rootView.findViewById(R.id.entcCard);
        CardView cdMeta=(CardView)rootView.findViewById(R.id.metallurgyCard);
        CardView cdDDGM=(CardView)rootView.findViewById(R.id.ddgmCard);
        CardView cdMath=(CardView)rootView.findViewById(R.id.mathCard);
        CardView cdEng=(CardView)rootView.findViewById(R.id.englishCard);
        CardView cdPhy=(CardView)rootView.findViewById(R.id.physicsCard);
        CardView cdChem=(CardView)rootView.findViewById(R.id.chemCard);


        cdIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("ITkey",IT);
                intent.putExtra("ITcode",ITcode);
                getActivity().startActivity(intent);

            }
        });

        cdComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("COMPkey",COMP);
                getActivity().startActivity(intent);
            }
        });

        cdMech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("MECHkey",MECH);
                getActivity().startActivity(intent);
            }
        });

        cdCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("CIVILkey",CIVIL);
                getActivity().startActivity(intent);
            }
        });

        cdElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("ELECkey",ELECTRICAL);
                getActivity().startActivity(intent);
            }
        });

        cdENTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("ENTCkey",ENTC);
                getActivity().startActivity(intent);
            }
        });

        cdMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("METAkey",META);
                getActivity().startActivity(intent);
            }
        });

        cdDDGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("DDGMkey",DDGM);
                getActivity().startActivity(intent);
            }
        });

        cdMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("MATHkey",MATHS);
                getActivity().startActivity(intent);
            }
        });

        cdEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("ENGkey",ENGLISH);
                getActivity().startActivity(intent);
            }
        });

        cdPhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("PHYSICSkey",PHYSICS);
                getActivity().startActivity(intent);
            }
        });

        cdChem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("CHEMkey",CHEM);
                getActivity().startActivity(intent);
            }
        });
        return rootView;
    }

}
