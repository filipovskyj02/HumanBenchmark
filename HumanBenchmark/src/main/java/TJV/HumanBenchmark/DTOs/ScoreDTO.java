package TJV.HumanBenchmark.DTOs;
public class ScoreDTO {


    private long id_player;
    private long id_game;
    private int score;

    public ScoreDTO(long id_player, long id_game, int score) {
        this.id_player = id_player;
        this.id_game = id_game;
        this.score = score;
    }


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

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }


}