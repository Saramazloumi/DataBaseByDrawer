package model;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.midterm.lasalle.databasebydrawer.R;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class EmployeeFragment extends android.app.Fragment {


    //set the layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.employee_fragment, container,false);
    }

    //sending information
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Employee employee = (Employee) getArguments().getSerializable("key");

           if (employee instanceof FullTime){

               TextView textViewTd = (TextView)getActivity().findViewById(R.id.editTextId);
               TextView textViewName = (TextView)getActivity().findViewById(R.id.editTextName);
               TextView textViewJob = (TextView)getActivity().findViewById(R.id.editTextJob);
               TextView textViewStartDate = (TextView)getActivity().findViewById(R.id.editTextStartDate);
               TextView textViewSalary = (TextView)getActivity().findViewById(R.id.editTextSalary);
               TextView textViewEndDate = (TextView)getActivity().findViewById(R.id.editTextEndDate);
               TextView textViewPerWeek = (TextView)getActivity().findViewById(R.id.editTextnhPerWeek);

               textViewTd.setText(employee.getId());
               textViewName.setText(employee.name);
               textViewJob.setText(employee.job);
               textViewStartDate.setText(((FullTime) employee).getFStartDate());
               textViewSalary.setText(String.valueOf(((FullTime) employee).getFSalary()) + " $");
               textViewEndDate.setVisibility(EditText.INVISIBLE);
               textViewPerWeek.setVisibility(EditText.INVISIBLE);

           }else if (employee instanceof Contractor){

               TextView textViewId = (TextView)getActivity().findViewById(R.id.editTextId);
               TextView textViewName = (TextView)getActivity().findViewById(R.id.editTextName);
               TextView textViewJob = (TextView)getActivity().findViewById(R.id.editTextJob);
               TextView textViewStartDate = (TextView)getActivity().findViewById(R.id.editTextStartDate);
               TextView textViewSalary = (TextView)getActivity().findViewById(R.id.editTextSalary);
               TextView textViewEndDate = (TextView)getActivity().findViewById(R.id.editTextEndDate);
               TextView textViewPerWeek = (TextView)getActivity().findViewById(R.id.editTextnhPerWeek);

               textViewId.setText(employee.getId());
               textViewName.setText(employee.getName());
               textViewJob.setText(employee.getJob());
               textViewStartDate.setText(((Contractor) employee).getcStartDate());
               textViewEndDate.setVisibility(EditText.VISIBLE);
               textViewEndDate.setText(((Contractor) employee).getEndDate());
               textViewSalary.setText(String.valueOf(((Contractor) employee).getcSalary()) + " $ Per hour");
               textViewPerWeek.setVisibility(EditText.VISIBLE);
               textViewPerWeek.setText(String.valueOf(((Contractor) employee).getNhPerWeek()));
           }
       }
}
