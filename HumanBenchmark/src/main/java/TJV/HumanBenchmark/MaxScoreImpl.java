
package TJV.HumanBenchmark;

import TJV.HumanBenchmark.DTOs.GameDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class MaxScoreImpl implements CustomMaxScoreRepo {
    @Autowired
    @Lazy
    MaxScoreRepo maxScoreRepo;

    /*
    @Override
    public ResponseEntity getMaxScoreById(MaxScoreDto maxScoreDto){
        int max = -1;

        for (MaxScore maxScore: maxScoreRepo.findAll()){
            if (maxScore.getId_player() == maxScoreDto.getId_player() && maxScore.getId_game() == maxScoreDto.getId_game()){
                if (maxScore.getMaxScore() > max)max = maxScore.getMaxScore();
            }
        }
        if (max == -1) return ResponseEntity.badRequest().body("Game or User not present!");
        return ResponseEntity.ok().body(max);

    }

    @Override
    public ResponseEntity getMaxScoreForGame(GameDTO gameDTO){
        int max = -1;
        for (MaxScore maxScore: maxScoreRepo.findAll()){
            if (maxScore.getId_game() == gameDTO.getId_game() && maxScore.getMaxScore() > max){
                max = maxScore.getMaxScore();
            }
        }
        if (max == -1) return ResponseEntity.badRequest().body("No scores for this game set or game not present !");
        return ResponseEntity.ok().body(max);

    }


    @Override
    public int checkScore(Score score, Player player, Game game){
        MaxScore.MaxScoreId compositeId = new MaxScore.MaxScoreId();
        compositeId.setId_game(game.getId_game());
        compositeId.setId_player(player.getId_user());
        Optional<MaxScore> maxScore = maxScoreRepo.findById(compositeId);
        if (!maxScore.isPresent()) return -1;
        if (score.getScore() > maxScore.get().getMaxScore()) {
            maxScoreRepo.save(new MaxScore(compositeId, player,game,score));
            return 1;
        }
        else return 0;
        }
        */


    }


