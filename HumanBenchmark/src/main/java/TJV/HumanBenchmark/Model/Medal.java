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

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medals")
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_medal", unique = true, updatable = false)
    private long id_medal;
    @Column(name = "name",length = 512)
    private String name;

    @Column(name = "description",length = 4096)
    private String description;

    @JsonIgnore
    @Nullable
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "medal",cascade = CascadeType.REMOVE)
    private List<MedalPlayer> players = new ArrayList<MedalPlayer>();
    public Medal(String name,String description) {
        this.name = name;
        this.description = description;
    }

}
