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
               TextView textViewFId = (TextView)getActivity().findViewById(R.id.editTextId);
               TextView textViewFName = (TextView)getActivity().findViewById(R.id.editTextName);
               TextView textViewFJob = (TextView)getActivity().findViewById(R.id.editTextJob);
               TextView textViewFStartDate = (TextView)getActivity().findViewById(R.id.editTextStartDate);
               TextView textViewFSalary = (TextView)getActivity().findViewById(R.id.editTextSalary);
               TextView textViewEndDate = (TextView)getActivity().findViewById(R.id.editTextEndDate);
               TextView textViewPerweek = (TextView)getActivity().findViewById(R.id.editTextnhPerWeek);

               textViewFId.setText(employee.getId());
               textViewFName.setText(employee.name);
               textViewFJob.setText(employee.job);
               textViewFStartDate.setText(((FullTime) employee).getFStartDate());
               textViewFSalary.setText(String.valueOf(((FullTime) employee).getFSalary()));
               textViewEndDate.setVisibility(EditText.INVISIBLE);
               textViewPerweek.setVisibility(EditText.INVISIBLE);

           }else if (employee instanceof Contractor){
               TextView textViewCId = (TextView)getActivity().findViewById(R.id.editTextId);
               TextView textViewCName = (TextView)getActivity().findViewById(R.id.editTextName);
               TextView textViewCJob = (TextView)getActivity().findViewById(R.id.editTextJob);
               TextView textViewCStartDate = (TextView)getActivity().findViewById(R.id.editTextStartDate);
               TextView textViewCEndDate = (TextView)getActivity().findViewById(R.id.editTextEndDate);
               TextView textViewCSalary = (TextView)getActivity().findViewById(R.id.editTextSalary);
               TextView textViewNHPerWeek = (TextView)getActivity().findViewById(R.id.editTextnhPerWeek);

               textViewCId.setText(employee.getId());
               textViewCName.setText(employee.getName());
               textViewCJob.setText(employee.getJob());
               textViewCStartDate.setText(((Contractor) employee).getcStartDate());
               textViewCEndDate.setVisibility(EditText.VISIBLE);
               textViewCEndDate.setText(((Contractor) employee).getEndDate());
               textViewNHPerWeek.setVisibility(EditText.VISIBLE);
               textViewCSalary.setText(String.valueOf(((Contractor) employee).getcSalary()) + " Per hour");
               textViewNHPerWeek.setText(String.valueOf(((Contractor) employee).getNhPerWeek()));
           }
       }
}
