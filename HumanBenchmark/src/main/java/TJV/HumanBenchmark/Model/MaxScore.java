package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "maxscores")
public class MaxScore {
        @Embeddable
        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @Setter
        public static class MaxScoreId implements Serializable {
            @Column(name = "game_id_game")
            private Long id_game;
            @Column(name = "player_id_player")
            private Long id_player;
        }
        @EmbeddedId
        private MaxScoreId id_maxscore;

        @Column(name="score")
        private Integer score;

        @ManyToOne
        @JoinColumn(name="game_id_game", insertable=false, updatable=false)
        private Game game;

        @ManyToOne
        @JoinColumn(name="player_id_player", insertable=false, updatable=false)
        private Player player;
        public MaxScore(Integer score, long gameId, long playerId) {
        this.score = score;
        this.setId_maxscore(new MaxScoreId(gameId,playerId));
    }

}
