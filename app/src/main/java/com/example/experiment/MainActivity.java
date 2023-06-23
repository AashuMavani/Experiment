package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TimePicker;

import com.example.experiment.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RadioButton python;
    ActivityMainBinding binding;
    String str="";
    TimePickerDialog timePickerDialog;
    private String am_pm="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        //python=binding.python;
//        binding.java.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                binding.ans.setText(""+binding.java.getText().toString());
//            }
//        });
        binding.Chjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.Chjava.isChecked())
                {
                    str=str+" Java";
                }
                else if(!binding.Chjava.isChecked())
                {
                    str=str.replaceAll(" Java"," ");
                }
                binding.ans.setText(""+str);
            }
        });
        binding.Chpython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.Chpython.isChecked())
                {
                    str=str+" Python";
                }
                else if(!binding.Chpython.isChecked())
                {
                    str=str.replaceAll(" Python"," ");
                }
                binding.ans.setText(""+str);
            }
        });
        binding.Chkotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.Chkotlin.isChecked())
                {
                    str=str+" Kotlin";
                }
                else if(!binding.Chkotlin.isChecked())
                {
                    str=str.replaceAll(" Kotlin"," ");
                }
                binding.ans.setText(""+str);
            }
        });

//        binding.timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                binding.ans.setText(""+hourOfDay+":"+minute);
//
//            }
//
//        });
//
       binding.ans.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar calendar=Calendar.getInstance();

               timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                   @Override
                   public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                       calendar.set(Calendar.MINUTE, minute);

                       if (calendar.get(Calendar.AM_PM) == Calendar.AM)
                           am_pm = "AM";
                       else if (calendar.get(Calendar.AM_PM) == Calendar.PM)
                           am_pm = "PM";
                       String strHrsToShow = (calendar.get(Calendar.HOUR) == 0) ?"12":Integer.toString(calendar.get(Calendar.HOUR) );
                       binding.ans.setText(""+strHrsToShow+":"+minute+" "+am_pm);
                   }
               },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
               timePickerDialog.show();
           }
       });
    }
}