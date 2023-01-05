package TJV.HumanBenchmark.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
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

    public Medal getMedal() {
        return medal;
    }

    public void setMedal(Medal medal) {
        this.medal = medal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

