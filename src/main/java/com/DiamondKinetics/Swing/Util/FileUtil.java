package com.DiamondKinetics.Swing.Util;

import com.DiamondKinetics.Swing.DemoApplication;
import com.DiamondKinetics.Swing.Model.SensorData;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileUtil {

    public static ArrayList<SensorData> readCSVtoSensorDataList(String fileName)  {


        // Read all lines in from CSV file and add to String array
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        String line = null;
        ArrayList<SensorData> data = new ArrayList<>();
        try{

            InputStream is = getFileFromResourceAsStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

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
            bufferedReader.close();
        }catch (IOException ex){
            ex.getMessage(); //Add into internal logs
        }
        return data;
    }

    private static InputStream getFileFromResourceAsStream(String fileName)  {

        InputStream inputStream = DemoApplication.class.getResourceAsStream(fileName);

        // the stream holding the file content
        try{
            if (inputStream == null) {
                throw new FileNotFoundException("file not found! " + fileName);
            }

        }catch (FileNotFoundException ex){
            ex.getMessage(); //Add into internal logs
        }
        return inputStream;

    }
}
