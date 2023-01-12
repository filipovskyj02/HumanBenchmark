package TJV.HumanBenchmark.Services;

import TJV.HumanBenchmark.DTOs.GameByIdDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
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

import org.springframework.stereotype.Service;


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
        newScore.setPlayer(player);
        scoreRepo.save(newScore);
        checkAndUpdateMax(scoreDTO);

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
        public int getMax(MaxScoreDTO maxScoreDTO) {
            MaxScore.MaxScoreId compositeKey = new MaxScore.MaxScoreId(maxScoreDTO.getId_game(), maxScoreDTO.getId_player());
            if (maxScoreRepo.existsById(compositeKey) == true) {
                MaxScore maxScore = maxScoreRepo.getReferenceById(compositeKey);
                return maxScore.getScore();
            } else return 0;
        }
        public int getGlobalMax(GameByIdDTO gameByIdDTO){
        int max = 0;
        for (MaxScore maxScore: maxScoreRepo.findAll()){
            if (maxScore.getId_maxscore().getId_game() == gameByIdDTO.getId_game() && maxScore.getScore() > max)
                max = maxScore.getScore();
        }
        return max;

        }



}

