
package TJV.HumanBenchmark;

import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class MaxScore {

    public MaxScore(MaxScoreId compositeId,Score score) {
        this.id_maxscore = compositeId;
        this.maxScore = score.getScore();
    }

    @Embeddable
    public static class MaxScoreId implements Serializable {
        private long id_player;
        private long id_game;
        public MaxScoreId(long id_player,long id_game) {
            this.id_player = id_player;
            this.id_game = id_game;
        }
        public MaxScoreId(){}

        public long getId_player() {
            return id_player;
        }

        public void setId_player(long id_player) {
            this.id_player = id_player;
        }

        public long getId_game() {
            return id_game;
        }

        public void setId_game(long id_game) {
            this.id_game = id_game;
        }



    }

    @EmbeddedId
    private MaxScoreId id_maxscore;

    private int maxScore;


    public MaxScore(){}

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }


    public long getId_player() {
        return id_maxscore.getId_player();
    }

    public long getId_game() {
        return id_maxscore.getId_game();
    }
}



