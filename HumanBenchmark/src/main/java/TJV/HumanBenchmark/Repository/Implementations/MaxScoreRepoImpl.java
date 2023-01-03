package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.GameDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.CustomMaxScoreRepo;
import TJV.HumanBenchmark.Repository.MaxScoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MaxScoreRepoImpl implements CustomMaxScoreRepo {
    @Autowired
    @Lazy
    MaxScoreRepo maxScoreRepo;

    @Override
    public ResponseEntity getMaxScoreForGame(GameDTO gameDTO) {
        List<MaxScore> repo = maxScoreRepo.findAll();
        int max = -1;
        for (MaxScore maxScore : repo) {
            if (maxScore.getGame().getId_game() == gameDTO.getId_game() && maxScore.getScore() > max) {
                max = maxScore.getScore();
            }

        }
        return ResponseEntity.ok(max);

    }

    @Override
    public ResponseEntity getMaxScoreById(MaxScoreDTO maxScoreDTO) {
        List<MaxScore> repo = maxScoreRepo.findAll();
        int score = 0;
        for (MaxScore maxScore : repo) {
            if (maxScore.getGame().getId_game() == maxScoreDTO.getId_game() && maxScoreDTO.getId_game() == maxScore.getGame().getId_game()) {
                score = maxScore.getScore();
            }

        }
        return ResponseEntity.ok(score);
    }

    @Override
    public int checkScore(Score fullScore, Player player, Game game) {
        MaxScoreDTO maxScoreDTO = new MaxScoreDTO(player.getId_player(), game.getId_game());
        int res = (int) getMaxScoreById(maxScoreDTO).getBody();
        if (res < fullScore.getScore()) {
            MaxScore.MaxScoreId compositeId = new MaxScore.MaxScoreId(game.getId_game(), player.getId_player());
            MaxScore toSave = new MaxScore();
            toSave.setId_maxscore(compositeId);
            toSave.setScore(fullScore.getScore());
            maxScoreRepo.save(toSave);
            return fullScore.getScore();
        }
        return 0;
    }
}



