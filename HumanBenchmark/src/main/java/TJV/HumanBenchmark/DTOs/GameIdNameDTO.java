package TJV.HumanBenchmark.DTOs;

public class GameIdNameDTO {
    private long id_game;
    private String name;

    public long getId_game() {
        return id_game;
    }

    public void setId_game(long id_game) {
        this.id_game = id_game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameIdNameDTO(long id_game,String name) {
        this.id_game = id_game;
        this.name = name;
    }
    public GameIdNameDTO(){}
}
