package TJV.HumanBenchmark.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_user;
    private String name;
    private String email;
    private String password;
    private String race;

   public Player(String name, String email, String password,String race){
        this.name = name;
        this.email = email;
        this.password = password;
        this.race= race;
    }

    public Player() {}
}
