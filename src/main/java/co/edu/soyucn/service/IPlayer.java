package co.edu.soyucn.service;

import co.edu.soyucn.model.Player;

import java.util.List;

// Interfaz que tiene los métodos para simular las operaciones sobre una BD (ArrayList)
public interface IPlayer {
    public void create(Player player);
    public List<Player> readAll();
    public void updateById(String body, int id);
    public void deleteById(int id);
    public void findById(int id);
}
