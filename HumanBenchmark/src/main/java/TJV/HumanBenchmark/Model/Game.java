package TJV.HumanBenchmark.Model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Games")
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_game", unique = true, updatable = false)
    private long id_game;
    @Column(name = "name")
    private String name;

    @Column(name = "scores", nullable = true)
    @OneToMany
    private List<Score> scores = new ArrayList<Score>();


    public long getId_game() {
        return id_game;
    }
    public void addScore(Score score) {
        this.scores.add(score);
    }

    public void setId_game(long id_game) {
        this.id_game = id_game;
    }

    public Game(String name){
        this.name = name;
    }
    public Game(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
