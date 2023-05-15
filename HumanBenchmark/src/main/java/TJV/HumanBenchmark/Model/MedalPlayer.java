package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class MedalPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medals_id_medal")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Medal medal;

    @ManyToOne
    @JoinColumn(name = "players_id_player")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Player player;


}

