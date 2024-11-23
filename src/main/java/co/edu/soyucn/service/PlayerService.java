package co.edu.soyucn.service;

import co.edu.soyucn.model.Player;

import java.util.ArrayList;
import java.util.List;

// Clase que simula JPA y ejecuta las operaciones sobre la BD (ArrayList)
public class PlayerService implements IPlayer {
    private static List<Player> players = new ArrayList<Player>();
    public static Player player;

    @Override
    public void create(Player player) {
        players.add(player);
        String response = "Se ha creado el usuario con exito y sus datos son:\n" + "Id:" + player.getId() + ", " + " Nombre completo: " + player.getFullname() + ", " +
                "Score: " + player.getScore();

        System.out.println(response);
    }

    @Override
    public List<Player> readAll() {
        printPlayers();
        return players;
    }

    @Override
    public void updateById(String body, int id){
        for (Player playerUpdate : players) {
            if (playerUpdate.getId() == id) {
                String[] data = body.split(",");
                playerUpdate.setFullname(data[0]);
                playerUpdate.setTeam(data[1]);
                playerUpdate.setScore(Integer.parseInt(data[2]));
                player = playerUpdate;
                break;
            }
        }
        System.out.println("Se ha actualizado el jugador con éxito y sus datos son:\n" + "Id:" + player.getId() + ", " + " Nombre completo: " + player.getFullname() + ", " +
                "Team: " + player.getTeam() + ", " + "Score: " + player.getScore());
    }

    @Override
    public void deleteById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                players.remove(player);
                break;
            }
        }

        System.out.println("Se ha eliminado el jugador con Id:" + id);
        printPlayers();
    }

    @Override
    public void findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                System.out.println("Se ha encontrado el jugador con Id:" + id);
                System.out.println(player);
            }
        }
    }

    // Mostrar es formato tipo JSON la información.
    static void printPlayers() {
        System.out.println("Lista de jugadores:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\n{\n\t\"id\":" + players.get(i).getId() + "," + "\n\t\"nombre completo\":" + players.get(i).getFullname() + "\"," +
                    "\n\t\"team\":" + "\"" + players.get(i).getTeam() + "\",\n\t\"score\":" + "\"" + players.get(i).getScore() + "\"\n\t\t\t\t\t\t},");
        }
    }
}
