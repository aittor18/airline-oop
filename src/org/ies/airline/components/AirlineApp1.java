package org.ies.airline.components;

import org.ies.airline.model.Airline;

import java.util.Scanner;

public class AirlineApp1 {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run() {
        //Pide los datos de la aerolínea
        Airline airline = airlineReader.read();

        //Pide al usuario un número de vuelo
        System.out.println("Introduce un número de vuelo: ");


    }
}
