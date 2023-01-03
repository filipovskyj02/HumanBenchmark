package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.http.ResponseEntity;

public interface CustomScoreRepo {
    ResponseEntity addScore (ScoreDTO scoreDTO);
}
