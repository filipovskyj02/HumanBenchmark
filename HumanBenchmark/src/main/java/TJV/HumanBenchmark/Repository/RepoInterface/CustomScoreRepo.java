package TJV.HumanBenchmark.Repository.RepoInterface;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CustomScoreRepo {
    boolean deleteScoreById(long id);
     Optional<Score> update(long id, ScoreDTO scoreDTO);
}
