package TJV.HumanBenchmark.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medals")
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_medal", unique = true, updatable = false)
    private long id_medal;
    @Column(name = "description",length = 4096)
    private String description;


    @Nullable
    @OneToMany
    private List<Player> players = new ArrayList<Player>();

    public Medal(){}

    public Medal(String description) {
        this.description = description;
    }

    public long getId_medal() {
        return id_medal;
    }

    public void setId_medal(long id_medal) {
        this.id_medal = id_medal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}