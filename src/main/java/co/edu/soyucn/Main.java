package co.edu.soyucn;

import co.edu.soyucn.server.Server;

// Clase del programa principal
public class Main {
    public static void main(String[] args) {
        // Expone una api rest emulada
        Server server = new Server();

        // Inicialización del servidor
        server.StartServer();

        // Petición POST =  Para crear un nuevo jugador en la base de datos.  La base de datos es un ArrayList
        Server request = new Server("Content-Type: application/json", "Orlando Contreras,Millonarios,91", "POST");
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición POST =  Para crear un nuevo jugador en la base de datos
        request = new Server("Content-Type: application/json", "Katerine Cano,Medellin,90", "POST");
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición POST =  Para crear un nuevo jugador en la base de datos
        request = new Server("Content-Type: application/json", "Marcela Medina,Nacional,92", "POST");
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición GET =  Obtiene todos los jugadores almacenados en el ArrayList
        request = new Server("Content-Type: application/json","", "GET");
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición GET =  Obtiene los datos de un jugador de acuerdo con el ID.
        request = new Server("Content-Type: application/json","", "GET", 2);
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición PUT = Actualiza los datos de un jugador de acuerdo con el ID
        request = new Server("Content-Type: application/json","Carlos Henriquez,Junior,87", "PUT", 1);
        System.out.println(request);
        System.out.println("---------------------------------------------------");

        // Petición DELETE = Eliminar un jugador del ArrayList de acuerdo con el ID.
        request = new Server("Content-Type: application/json","", "DELETE", 3);
        System.out.println(request);
        System.out.println("---------------------------------------------------");

    }
}