package TJV.HumanBenchmark.DTOs;

public class MaxScoreDTO {
    long id_player;

    public MaxScoreDTO(long id_player, long id_game) {
        this.id_player = id_player;
        this.id_game = id_game;
    }
    MaxScoreDTO(){}
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

    long id_game;
}
