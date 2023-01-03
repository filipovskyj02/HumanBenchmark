package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.DTOs.GameDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.DTOs.NewGameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.http.ResponseEntity;

public interface CustomMaxScoreRepo {


    ResponseEntity getMaxScoreForGame(GameDTO gameDTO);
    ResponseEntity getMaxScoreById(MaxScoreDTO maxScoreDTO);
    int checkScore(Score fullScore, Player player, Game game);
}
