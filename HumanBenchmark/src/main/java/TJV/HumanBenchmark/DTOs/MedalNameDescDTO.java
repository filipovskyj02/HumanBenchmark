package TJV.HumanBenchmark.DTOs;

public class MedalNameDescDTO {
    private String name;

    public MedalNameDescDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public MedalNameDescDTO(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
}
