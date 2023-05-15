package TJV.HumanBenchmark.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreDTO {
    private long id_player;
    private long id_game;
    private int score;
}