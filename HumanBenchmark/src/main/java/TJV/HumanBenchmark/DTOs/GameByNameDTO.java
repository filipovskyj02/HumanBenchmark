package TJV.HumanBenchmark.DTOs;

public class GameByNameDTO {
    private String name;
    public String getName() {
        return name;
    }

    public GameByNameDTO(String name) {
        this.name = name;
    }
    public GameByNameDTO(){}

    public void setName(String name) {
        this.name = name;
    }
}
