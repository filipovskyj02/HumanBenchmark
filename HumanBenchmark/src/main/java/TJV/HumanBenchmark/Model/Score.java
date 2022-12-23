package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_score;

    private int score;

    private LocalDateTime date;

    @ManyToOne
    private Player player;

    public Score(int score,Player player){
        this.score = score;
        this.date = LocalDateTime.now();
        this.player = player;
    }


    public Score(){}
}
