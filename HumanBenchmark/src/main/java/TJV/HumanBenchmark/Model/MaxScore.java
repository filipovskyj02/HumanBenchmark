package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "maxscores")
public class MaxScore {
        @Embeddable
        public static class MaxScoreId implements Serializable {

            @Column(name="game_id_game")
            private Long id_game;

            @Column(name="player_id_player")
            private Long id_player;

            public MaxScoreId(Long id_game, Long id_player) {
                this.id_game = id_game;
                this.id_player = id_player;
            }
            public MaxScoreId(){}

            public Long getId_game() {
                return id_game;
            }

            public void setId_game(Long id_game) {
                this.id_game = id_game;
            }

            public Long getId_player() {
                return id_player;
            }

            public void setId_player(Long id_player) {
                this.id_player = id_player;
            }
        }

        @EmbeddedId
        private MaxScoreId id_maxscore;

        @Column(name="score")
        private Integer score;
    public MaxScore(){}
    public MaxScore(Integer score, long gameId, long playerId) {
        this.score = score;
        this.setId_maxscore(new MaxScoreId(gameId,playerId));
    }

    @ManyToOne
        @JoinColumn(name="game_id_game", insertable=false, updatable=false)
        private Game game;

        @ManyToOne
        @JoinColumn(name="player_id_player", insertable=false, updatable=false)
        private Player player;

    public MaxScoreId getId_maxscore() {
        return id_maxscore;
    }

    public void setId_maxscore(MaxScoreId id_maxscore) {
        this.id_maxscore = id_maxscore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
