package TJV.HumanBenchmark.DTOs;

public class OutPlayerLoginDTO {
    long id_player;
    String name;

    public OutPlayerLoginDTO(long id_player, String name) {
        this.id_player = id_player;
        this.name = name;
    }
    public OutPlayerLoginDTO(){}

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
