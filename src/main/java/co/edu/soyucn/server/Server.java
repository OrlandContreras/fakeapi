package co.edu.soyucn.server;

import co.edu.soyucn.controller.PlayerController;

// Clase Servidor la que permite emular un servidor sobre el cual se expone la API
public class Server {
    private static final String HOST = "http://localhost";
    private static final int PORT = 8080;
    private static final String VERSION_PROTOCOL = "HTTP/1.1";

    private static final String URL_FAKE_API = HOST + ":" + PORT + "/api/players";

    // Variables del encabezado de una API.
    private String headers;
    private String body;
    private String method;
    private int id;

    private PlayerController playerController;

    public Server() {}

    // Constructor de la clase para las peticiones GET y POST que no requerien el ID
    public Server(String headers, String body, String method) {
        this.headers = headers;
        this.body = body;
        this.method = method;
        playerController = new PlayerController();

        switch (method) {
            case "GET":
                this.GetAllPlayers();
                break;
            case "POST":
                this.PostPlayer(body);
                break;
            default:
                System.out.println("Invalid method: " + method);
                break;
        }
    }

    // Constructor de la clase para las peticiones que requerien el ID
    public Server(String headers, String body, String method, int id) {
        this.headers = headers;
        this.body = body;
        this.method = method;
        this.id = id;
        playerController = new PlayerController();

        switch (method) {
            case "GET":
                this.GetById(id);
                break;
            case "PUT":
                this.Update(id, body);
                break;
            case "DELETE":
                this.Delete(id);
                break;
            default:
                System.out.println("Invalid method: " + method);
                break;
        }
    }

    // Clase que inicializa el servidor que expone la Api (ficticio)
    public void StartServer() {
        System.out.println("====== Emulando un servidor web ======");
        System.out.println("Inicializando servidor web....");
        System.out.println("HOST: " + HOST);
        System.out.println("PORT: " + PORT);
        System.out.println("Servidor iniciado....");
        System.out.println("=======================================");
    }

    // Método que permite la creación de un jugador
    private void PostPlayer(String body) {
        playerController.Create(body);
    }

    // Método que obtiene el listado de jugadores almacenados en un ArrayList
    private void GetAllPlayers() {
        playerController.GetAll();
    }

    // Método que obtiene los datos de un jugador de acuerdo con el ID
    private void GetById(int id) {
        playerController.GetById(id);
    }

    // Método que actualiza los datos de un jugador de acuerdo con el ID
    private void Update(int id, String body) {
        playerController.Update(id, body);
    }

    // Método que elimina un jugador del ArrayList de acuerdo con el ID
    private void Delete(int id) {
        playerController.Delete(id);
    }

    // Muestra los datos del encabezado de la Api.
    @Override
    public String toString() {
        return "Server {" +
                "url='" + URL_FAKE_API + '\'' +
                ", headers='" + headers + '\'' +
                ", method='" + method + '\'' +
                ",\n body='" + body + '\'' +
                '}';
    }
}
