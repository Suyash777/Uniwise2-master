package com.example.uniwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity {

    TextView dept;
    String[] empty={"Empty List","Empty List"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Intent intent = getIntent();
        String[] ITsubjectList = intent.getStringArrayExtra("ITkey");
        String[] ITcourseCode=intent.getStringArrayExtra("ITcode");
        String[] COMPsubjectList = intent.getStringArrayExtra("COMPkey");
        String[] MECHsubjectList=intent.getStringArrayExtra("MECHkey");
        String[] CIVILsubjectList=intent.getStringArrayExtra("CIVILkey");
        String[] ELECTRICALsubjectList=intent.getStringArrayExtra("ELECkey");
        String[] ENTCsubjectList=intent.getStringArrayExtra("ENTCkey");
        String[] METAsubjectList=intent.getStringArrayExtra("METAkey");
        String[] DDGMsubjectList=intent.getStringArrayExtra("DDGMkey");
        String[] MATHsubjectList=intent.getStringArrayExtra("MATHkey");
        String[] ENGsubjectList=intent.getStringArrayExtra("ENGkey");
        String[] PHYSICSsubjectList=intent.getStringArrayExtra("PHYSICSkey");
        String[] CHEMsubjectList=intent.getStringArrayExtra("CHEMkey");
        dept=findViewById(R.id.title_dept);

        RecyclerView Subjects = findViewById(R.id.list_subs);
        Subjects.setLayoutManager(new LinearLayoutManager(this));
        if(ITsubjectList!=null) {
            Subjects.setAdapter(new SubjectsAdapter(ITsubjectList,ITcourseCode));
            dept.setText("IT Department");
        }
        else if(COMPsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(COMPsubjectList,ITcourseCode));
            dept.setText("Computer Department");
        }
        else if(MECHsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(MECHsubjectList,ITcourseCode));
            dept.setText("Mechanical Department");
        }
        else if(CIVILsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(CIVILsubjectList,ITcourseCode));
            dept.setText("Civil Department");
        }
        else if(ELECTRICALsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ELECTRICALsubjectList,ITcourseCode));
            dept.setText("Electrical Department");
        }
        else if(ENTCsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ENTCsubjectList,ITcourseCode));
            dept.setText("Electronics and Telecommunication Department");
        }
        else if(METAsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(METAsubjectList,ITcourseCode));
            dept.setText("Metallurgy Department");
        }
        else if(DDGMsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(DDGMsubjectList,ITcourseCode));
            dept.setText("Dress Designing and Garment Manufacturing Department");
        }
        else if(MATHsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(MATHsubjectList,ITcourseCode));
            dept.setText("Mathematics Department");
        }
        else if(ENGsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ENGsubjectList,ITcourseCode));
            dept.setText("English Department");
        }
        else if(PHYSICSsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(PHYSICSsubjectList,ITcourseCode));
            dept.setText("Physics Department");
        }
        else if(CHEMsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(CHEMsubjectList,ITcourseCode));
            dept.setText("Chemistry Department");
        }
        else {
            Subjects.setAdapter(new SubjectsAdapter(empty,empty));
        }
    }

}





