package com.DiamondKinetics.Swing.Util;

import com.DiamondKinetics.Swing.DemoApplication;
import com.DiamondKinetics.Swing.Model.SensorData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    final static Logger logger = LogManager.getLogger(FileUtil.class.getName());
    final static String COMMASEPARATOR = ",";

    public static SensorData readCSVtoSensorDataList(String fileName)  {
        // Read all lines in from CSV file and add to String array
        String line = null;
        SensorData data = null;
        InputStream is = getFileFromResourceAsStream(fileName);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){
            List<Long> timeStamp = new ArrayList<>();
            List<Double> ax = new ArrayList<>();
            List<Double> ay = new ArrayList<>();
            List<Double> az = new ArrayList<>();
            List<Double> wx = new ArrayList<>();
            List<Double> wy = new ArrayList<>();
            List<Double> wz = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] row = line.split(COMMASEPARATOR);
                timeStamp.add(Long.parseLong(row[0]));
                ax.add(Double.parseDouble(row[1]));
                ay.add(Double.parseDouble(row[2]));
                az.add(Double.parseDouble(row[3]));
                wx.add(Double.parseDouble(row[4]));
                wy.add(Double.parseDouble(row[5]));
                wz.add(Double.parseDouble(row[6]));
            }
            data = new SensorData(timeStamp, ax, ay, az, wx, wy, wz);
        }catch (IOException ex){
            logger.error(ex.getMessage()); //Add into internal logs
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
            return inputStream;
        }catch (FileNotFoundException ex){
            logger.error(ex.getMessage()); //Add into internal logs
        } catch (IOException ex) {
            logger.error(ex.getMessage()); //Add into internal logs
        }
        return null;
    }
}
