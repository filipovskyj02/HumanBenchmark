package TJV.HumanBenchmark.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_game", unique = true, updatable = false)
    private long id_game;
    @Column(name = "name")
    private String name;

    @Nullable
    @OneToMany(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "player_id_player")
    @JsonIgnore
    private List<Score> scores = new ArrayList<Score>();
    public Game(String str){
        this.name = str;
    }

}
