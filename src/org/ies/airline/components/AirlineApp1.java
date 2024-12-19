package org.ies.airline.components;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class AirlineApp1 {
    private final Scanner scanner;
    private final AirlineReader airlineReader;
    private final Passenger passenger;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader, Passenger passenger) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
        this.passenger = passenger;
    }

    public void run() {

        //Pide los datos de la aerolínea
        Airline airline = airlineReader.read();

        // Pide al usuario un número de vuelo.
        System.out.print("Introduce un número de vuelo: ");
        int askFlightNumber = scanner.nextInt();
        scanner.nextLine();

        //Busca el vuelo con ese número de vuelo
        Flight flight = airline.findFlight(askFlightNumber);
        //Si no existe muestra por pantalla un error
        if (flight == null) {
            System.out.println("Error, el número de vuelo no existe.");
        }
        //Si existe:
        else {
            //Pide al usuario un pasajero.
            System.out.print("Introduce el NIF del pasajero: ");
            String nif = scanner.nextLine();

            //Busca a ese pasajero dentro del vuelo:
            boolean passengers = flight.hasPassenger(nif);

            if (passengers) {
                passenger.showInfo();

                System.out.print("Introduce un número de asiento: ");
                int askSeatNumber = scanner.nextInt();
                scanner.nextLine();

                airline.updateSeatNumber(askFlightNumber, nif, askSeatNumber);
            } else {
                System.out.println("El pasajero dentro del vuelo no existe...");
            }
        }
    }
}
