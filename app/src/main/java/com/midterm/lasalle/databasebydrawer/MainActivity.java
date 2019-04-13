package com.midterm.lasalle.databasebydrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Employee;
import model.EmployeeFragment;
import model.FileManager;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener , View.OnClickListener {

    TextView textViewTitle;
    ImageButton btnMenu;
    DrawerLayout drawerLayout;
    ListView listViewPersons;

    ArrayList<Employee> listOfEmployee;
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        textViewTitle = findViewById(R.id.textViewTitle);
        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawerLayout);
        listViewPersons = findViewById(R.id.listViewPersons);
        listViewPersons.setOnItemClickListener(this);

        listOfEmployee = new ArrayList<Employee>();

        listOfEmployee = FileManager.readFile(this,"Person.txt");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfEmployee);
        listViewPersons.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(listViewPersons);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("key",listOfEmployee.get(position));

        EmployeeFragment employeeFragment = new EmployeeFragment();
        employeeFragment.setArguments(bundle);


        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_ui, employeeFragment);
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(listViewPersons);
    }


}
