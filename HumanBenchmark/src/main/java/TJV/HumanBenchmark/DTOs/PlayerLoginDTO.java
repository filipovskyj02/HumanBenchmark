package TJV.HumanBenchmark.DTOs;

public class PlayerLoginDTO {
    private String password;
    private String email;

    public PlayerLoginDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }
    public PlayerLoginDTO(){};

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
