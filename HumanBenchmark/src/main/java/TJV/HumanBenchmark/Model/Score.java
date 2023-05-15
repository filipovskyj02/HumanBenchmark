package TJV.HumanBenchmark.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
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
    @JoinColumn(name = "player_id_player",referencedColumnName = "id_player",updatable = false)
    private Player player;
    @ManyToOne
    @JoinColumn(name = "game_id_game",referencedColumnName = "id_game",updatable = false)
    private Game game;

    public Score(int score,Player player,Game gem){
        this.score = score;
        this.date = LocalDateTime.now().toString();
        this.player = player;
        this.game = gem;
    }

}
