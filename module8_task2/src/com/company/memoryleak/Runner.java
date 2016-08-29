package com.company.memoryleak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by alt-hanny on 28.08.2016.
 */
public class Runner {
    public static void main(String[] args) {
        final String FILE_NAME = "module8_task2/resources/Data.txt";
        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);
            String line;
            List resultList = new ArrayList();
            while ((line = br.readLine()) != null) {
                resultList.add(new String(line.substring(0,3)));
            }
            br.close();
            fr.close();
            TimeUnit.MINUTES.sleep(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
