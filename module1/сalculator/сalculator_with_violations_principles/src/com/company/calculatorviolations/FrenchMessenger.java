package com.company.calculatorviolations;

import com.company.calculatorviolations.interfaces.MessengerI;

/**
 * Created by alt-hanny on 10.07.2016.
 */
public class FrenchMessenger implements MessengerI {
    //YAGNI
    @Override
    public void inputFirstNumMessage() {
        System.out.println("Entrez le premier numéro: ");
    }

    @Override
    public void inputSecondNumMessage() {
        System.out.println("Entrez le second numéro: ");
    }

    @Override
    public void inputOperationMessage() {
        System.out.println("Entrez l'opération: ");
    }
}
