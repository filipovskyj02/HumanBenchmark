package TJV.HumanBenchmark.DTOs;

public class MedalAwardDTO {
    private long id_player;

    public MedalAwardDTO() {
    }

    public MedalAwardDTO(long id_player, String name) {
        this.id_player = id_player;
        this.name = name;
    }

    private String name;

    public long getId_player() {
        return id_player;
    }

    public void setId_player(long id_player) {
        this.id_player = id_player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
