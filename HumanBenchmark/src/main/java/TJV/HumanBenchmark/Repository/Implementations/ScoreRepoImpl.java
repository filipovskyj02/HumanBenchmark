package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.CustomScoreRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import TJV.HumanBenchmark.Repository.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ScoreRepoImpl implements CustomScoreRepo {
    @Autowired
    @Lazy
    ScoreRepo scoreRepo;
    @Autowired
    PlayerRepo playerRepo;
    @Override
    public ResponseEntity addScore (ScoreDTO scoreDTO)  {
        Optional<Player> player = playerRepo.findById(scoreDTO.getUserId());
        if (!player.isPresent()) return ResponseEntity.badRequest().body("Id not present!");
        if (player.get().getMaxScore() < scoreDTO.getScore()) {
            player.get().setMaxScore(scoreDTO.getScore());
        }
        Score fullScore = new Score(scoreDTO.getScore(),player.get());
        player.get().addScore(fullScore);
        scoreRepo.save(fullScore);

        return ResponseEntity.ok("Score added !");
        }

    }

