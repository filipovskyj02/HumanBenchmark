package TJV.HumanBenchmark.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_score", unique = true, updatable = false)
    private long id_score;
    @Column(name = "score")
    private int score;
    @Column(name = "date")
    private String date;

    @ManyToOne
    @JsonIgnore

    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id_game",referencedColumnName = "id_game")
    private Game game;

    public Score(int score,Player player,Game gem){
        this.score = score;
        this.date = "k";

        this.player = player;
        this.game = gem;
    }

    public long getId_score() {
        return id_score;
    }

    public void setId_score(long id_score) {
        this.id_score = id_score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }




    public Player getPlayer() {
        return player;
    }

    public void setPlayer( Player player) {
        this.player = player;
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Score(){}
}
