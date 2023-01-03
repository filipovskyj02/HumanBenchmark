package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.GameDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CustomMaxScoreRepo {
    int getUserMaxScore(MaxScoreDTO maxScoreDTO);


}
