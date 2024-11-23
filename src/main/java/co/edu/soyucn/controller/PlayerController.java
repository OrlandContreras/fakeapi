package co.edu.soyucn.controller;

import co.edu.soyucn.model.Player;
import co.edu.soyucn.service.IPlayer;
import co.edu.soyucn.service.PlayerService;

// Clase controlador que ejecuta las operaciones de la API
public class PlayerController {
    private IPlayer iplayer;

    public PlayerController() {
        iplayer = new PlayerService();
    }

    // GET @ID
    public void GetById(int id) {
        iplayer.findById(id);
    }

    // GET
    public void GetAll() {
        iplayer.readAll();
    }

    // POST
    public void Create(String body) {
       String [] data = body.split(",");
       Player player = new Player(data[0], data[1], Integer.parseInt(data[2]));
       iplayer.create(player);
    }

    // UPDATE @ID
    public void Update(int id, String body) {
        iplayer.updateById(body, id);
    }

    // DELETE @ID
    public void Delete(int id) {
        iplayer.deleteById(id);
    }
}
