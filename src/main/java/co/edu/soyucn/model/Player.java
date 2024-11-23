package co.edu.soyucn.model;

public class Player {
    // Atributos
    private static int contadorid = 1;
    private int id;
    private String fullname;
    private String team;
    private int score;

    // Propiedades: GETTER & SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(String fullname, String team, int score) {
        this.id = this.contadorid++;;
        this.fullname = fullname;
        this.team = team;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player {" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", team='" + team + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
