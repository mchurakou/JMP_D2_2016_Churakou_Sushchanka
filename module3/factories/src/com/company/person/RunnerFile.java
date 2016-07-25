package com.company.person;

import com.company.person.creators.PersonCreatorI;
import com.company.person.factories.PersonCreatorAbctractFactory;
import com.company.person.factories.PersonCreatorFileFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class RunnerFile {
    public static void main(String[] args) {
            PersonCreatorAbctractFactory fileCreator = new PersonCreatorFileFactory();
            PersonCreatorI personCreatorFile = fileCreator.makePersonCreator();
        try {
            MainLogic.execute(personCreatorFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
