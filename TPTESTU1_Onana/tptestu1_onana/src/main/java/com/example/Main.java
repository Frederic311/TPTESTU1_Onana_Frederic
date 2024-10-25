package com.example;

import com.stjean.operation.OperationMathematique;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int nombrePositif = 5;
        System.out.println("Est positif(" + nombrePositif + ") : " + OperationMathematique.estPositif(nombrePositif));

    }
}