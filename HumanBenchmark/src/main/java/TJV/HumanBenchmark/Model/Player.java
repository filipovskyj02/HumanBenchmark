package TJV.HumanBenchmark.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_user;
    private String name;
    private String email;
    private String password;
    private String race;



    private int maxScore = 0;
    @Nullable
    @OneToMany
    private List<Score> scores = new ArrayList<Score>();


   public Player(String name, String email, String password,String race){
        this.name = name;
        this.email = email;
        this.password = password;
        this.race= race;
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

    public long getId_user() {
        return id_user;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }
    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
    public Player() {}
}
