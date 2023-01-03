package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "Scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_score", unique = true, updatable = false)
    private long id_score;
    @Column(name = "score")
    private int score;
    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "player_id_player",nullable = false,referencedColumnName = "id_player")

    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id_game",nullable = false,referencedColumnName = "id_game")


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
