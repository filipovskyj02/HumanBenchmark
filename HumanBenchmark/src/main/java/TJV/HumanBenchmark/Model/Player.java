package TJV.HumanBenchmark.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Entity
@Data
@NoArgsConstructor
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_player", unique = true, updatable = false)
    private long id_player;
    @Column(name = "name")
    private String name;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Nullable
    @OneToMany(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "player_id_player")
    private List<Score> scores = new ArrayList<Score>();

    @JsonIgnore
    @Nullable
    @OnDelete(action = OnDeleteAction.CASCADE)

    @OneToMany(mappedBy = "player",cascade = CascadeType.REMOVE)
    private List<MedalPlayer> medals = new ArrayList<MedalPlayer>();

    public Player(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
