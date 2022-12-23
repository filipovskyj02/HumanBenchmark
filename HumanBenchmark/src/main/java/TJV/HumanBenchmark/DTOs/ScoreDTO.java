package TJV.HumanBenchmark.DTOs;
public class ScoreDTO {


    private long id_user;
    private long id_game;
    private int score;


    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
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