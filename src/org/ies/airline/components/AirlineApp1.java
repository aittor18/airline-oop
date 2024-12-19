package org.ies.airline.components;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

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
        int flightNumber = scanner.nextInt();
        scanner.nextLine();

        //Busca el vuelo con ese número de vuelo
        Flight flight = airline.findFlight(flightNumber);

        // Si no existe muestra por pantalla un error
        if (flight == null) {
            System.out.println("ERROR!, El número de vuelo o existe...");
        }
        //Si existe:
        else {
            //Pide al usuario un pasajero.
            System.out.print("Introduce el NIF del pasajero: ");
            String nif = scanner.nextLine();

            //Busca a ese pasajero dentro del vuelo:
            Passenger passenger = flight.findPassenger(nif);

            // Si existe:
            if (passenger != null) {
                //Muestra los datos del pasajeroç
                passenger.showInfo();

                //Pide un número de asiento
                System.out.println("Introduce un número de asiento: ");
                int seatNumber = scanner.nextInt();
                scanner.nextLine();

                //Cambia el asiento del pasajero
                airline.updateSeatNumber(flightNumber, nif, seatNumber);
            }
            //Si no existe muestra un mensaje de error
            else {
                System.out.println("ERROR!, El NIF introducido no corresponde con el NIF de ningún pasajero...");
            }
        }

    }
}
