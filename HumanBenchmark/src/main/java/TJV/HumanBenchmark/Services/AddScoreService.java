package TJV.HumanBenchmark.Services;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.GameRepo;
import TJV.HumanBenchmark.Repository.MaxScoreRepo;
import TJV.HumanBenchmark.Repository.PlayerRepo;
import TJV.HumanBenchmark.Repository.ScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class AddScoreService {
    @Autowired
    @Lazy
    ScoreRepo scoreRepo;
    @Autowired
    @Lazy
    MaxScoreRepo maxScoreRepo;
    @Autowired
    @Lazy
    GameRepo gameRepo;
    @Autowired
    @Lazy
    PlayerRepo playerRepo;

    public boolean addScoreToDb(ScoreDTO scoreDTO){
        if (!gameRepo.existsById(scoreDTO.getId_game()) || !playerRepo.existsById(scoreDTO.getId_player())) return false;
        Player player = playerRepo.getReferenceById(scoreDTO.getId_player());
        Game game = gameRepo.getReferenceById(scoreDTO.getId_game());
        Score newScore = new Score(scoreDTO.getScore(),player,game);
        scoreRepo.save(newScore);
        player.addScore(newScore);
        checkAndUpdateMax(scoreDTO);
        game.addScore(newScore);
        player.addScore(newScore);
        playerRepo.save(player);
        gameRepo.save(game);
        return true;

    }
    public void checkAndUpdateMax(ScoreDTO scoreDTO){
        MaxScore.MaxScoreId compositeKey = new MaxScore.MaxScoreId(scoreDTO.getId_game(), scoreDTO.getId_player());
        if (maxScoreRepo.existsById(compositeKey) == true) {
            MaxScore maxScore = maxScoreRepo.getReferenceById(compositeKey);
            if (maxScore.getScore() < scoreDTO.getScore()) {
                maxScore.setScore(scoreDTO.getScore());
                maxScoreRepo.flush();
            }

        }
        else {
            MaxScore maxScore = new MaxScore();
            maxScore.setScore(scoreDTO.getScore());
            maxScore.setId_maxscore(compositeKey);
            maxScoreRepo.save(maxScore);
        }


        }


}
