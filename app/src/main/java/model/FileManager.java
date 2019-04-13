package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManager {

    public static ArrayList<Employee> readFile(Context context, String fileName){

        ArrayList<Employee> list = new ArrayList<>();
        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br = new BufferedReader(isr);
            String oneLine = br.readLine();

            while(oneLine != null){

                StringTokenizer st = new StringTokenizer(oneLine, ",");
                String type = st.nextToken();

                switch (type){

                    case "F":
                        String fName = st.nextToken();
                        String fId = st.nextToken();
                        String fJob = st.nextToken();
                        String fStartDate = st.nextToken();
                        double fSalary = Double.valueOf(st.nextToken());
                        list.add(new FullTime(fId,fName,fJob,fStartDate,fSalary));
                        break;

                    case "C":
                        String cName = st.nextToken();
                        String cId = st.nextToken();
                        String cJob = st.nextToken();
                        String cStartDate = st.nextToken();
                        String cEndDate = st.nextToken();
                        int hourSalary = Integer.valueOf(st.nextToken());
                        int nhPerWeek = Integer.valueOf(st.nextToken());
                        list.add(new Contractor(cId,cName,cJob,cStartDate,cEndDate,hourSalary,nhPerWeek));
                        break;
                }
                oneLine = br.readLine();
            }
            br.close();
            isr.close();
        }catch(Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return list;
    }
}
