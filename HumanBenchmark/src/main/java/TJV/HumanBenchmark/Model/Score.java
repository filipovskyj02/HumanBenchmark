package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_score;

    private int score;

    private LocalDateTime date;

    @ManyToOne
    @NonNull
    private Player player;
    @ManyToOne
    @NonNull
    private Game game;

    public Score(int score,Player player,Game gem){
        this.score = score;
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @NonNull
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(@NonNull Player player) {
        this.player = player;
    }

    @NonNull
    public Game getGame() {
        return game;
    }

    public void setGame(@NonNull Game game) {
        this.game = game;
    }

    public Score(){}
}
