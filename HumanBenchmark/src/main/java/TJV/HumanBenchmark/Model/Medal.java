package TJV.HumanBenchmark.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medals")
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_medal", unique = true, updatable = false)
    private long id_medal;
    @Column(name = "name",length = 512)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description",length = 4096)
    private String description;

    @JsonIgnore
    @Nullable
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "medal",cascade = CascadeType.REMOVE)
    private List<MedalPlayer> players = new ArrayList<MedalPlayer>();

    public Medal(){}

    public Medal(String name,String description) {
        this.name = name;
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

    public List<MedalPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<MedalPlayer> players) {
        this.players = players;
    }
}
