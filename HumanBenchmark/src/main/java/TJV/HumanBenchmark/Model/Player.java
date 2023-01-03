package TJV.HumanBenchmark.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_player", unique = true, updatable = false)
    private long id_player;
    @Column(name = "name")
    private String name;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password")
    private String password;


    public long getId_player() {
        return id_player;
    }

    public void setId_player(long id_player) {
        this.id_player = id_player;
    }

    @Nullable
    @OneToMany
    private List<Score> scores = new ArrayList<Score>();

    @Nullable
    @OneToMany
    private List<Medal> medals = new ArrayList<Medal>();


   public Player(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public List<Score> getScores() {
        return this.scores;
    }

    public void addScore(Score score) {
        this.scores.add(score);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Player() {}
}
