package TJV.HumanBenchmark.DTOs;

public class NewGameDTO {
    private String name;
    public String getName() {
        return name;
    }

    public NewGameDTO(String name) {
        this.name = name;
    }
    public NewGameDTO(){}

    public void setName(String name) {
        this.name = name;
    }
}
