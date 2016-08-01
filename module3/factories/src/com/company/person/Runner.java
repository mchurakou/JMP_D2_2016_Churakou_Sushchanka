package com.company.person;

import com.company.person.beans.StorageType;
import com.company.person.creators.HeandlerI;

import java.io.IOException;
import java.util.Scanner;

/**
 * Runner for the work with database.
 * Created by alt-hanny on 25.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Please, choose the type of the storage: \n 1 - File; \n 2 - Database; ");
        String userChoose;
        boolean userChooseDone;
        HeandlerI handler = null;
        try (Scanner scanner = new Scanner(System.in)) {
            userChoose = scanner.nextLine();
            do {
                switch (userChoose) {
                    case "1":
                        handler = StorageType.FILE.getStorageType().makePersonCreator();
                        userChooseDone = true;
                        break;
                    case "2": {
                        handler = StorageType.H2_DATABASE.getStorageType().makePersonCreator();
                        userChooseDone = true;
                        break;
                    }
                    default:
                        System.out.println("Please, try again");
                        userChooseDone = false;
                }
            } while (!userChooseDone);
            MainLogic.execute(handler);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
