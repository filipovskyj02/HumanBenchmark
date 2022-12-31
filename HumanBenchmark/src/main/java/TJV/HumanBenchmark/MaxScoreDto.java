
package TJV.HumanBenchmark;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MaxScoreDto {
    private long id_game;
    private long id_player;
    public MaxScoreDto(){}
    public MaxScoreDto(long id_game, long id_player) {
        this.id_game = id_game;
        this.id_player = id_player;
    }


    public long getId_game() {
        return id_game;
    }

    public void setId_game(long id_game) {
        this.id_game = id_game;
    }

    public long getId_player() {
        return id_player;
    }

    public void setId_player(long id_player) {
        this.id_player = id_player;
    }

}


