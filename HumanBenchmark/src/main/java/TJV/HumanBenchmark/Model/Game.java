package TJV.HumanBenchmark.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_game", unique = true, updatable = false)
    private long id_game;
    @Column(name = "name")
    private String name;

    @Nullable
    @OneToMany(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "player_id_player")
    @JsonIgnore
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
