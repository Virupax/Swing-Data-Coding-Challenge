package com.DiamondKinetics.Swing.Util;

import com.DiamondKinetics.Swing.Model.SensorData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
    public static final String SENSORDATAFILEPATH = "C:\\Users\\virup\\Documents\\ICICI\\Applications\\Applications\\UNCC - IT\\SPRING 2021\\Assessments\\Diamond Kinetics\\latestSwing.csv";

    public static ArrayList<SensorData> readCSVtoSensorDataList() throws IOException {
        // Read all lines in from CSV file and add to String array
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String line = null;
        ArrayList<SensorData> data = new ArrayList<>();
        try{
            fileReader = new FileReader(SENSORDATAFILEPATH);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(new SensorData(Long.parseLong(row[0]),
                        Double.parseDouble(row[1]),
                        Double.parseDouble(row[2]),
                        Double.parseDouble(row[3]),
                        Double.parseDouble(row[4]),
                        Double.parseDouble(row[5]),
                        Double.parseDouble(row[6])
                        ));
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        bufferedReader.close();
        return data;
    }
    
}
