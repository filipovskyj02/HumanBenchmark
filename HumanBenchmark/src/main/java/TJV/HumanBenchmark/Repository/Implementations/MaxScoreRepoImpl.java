package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.GameDTO;
import TJV.HumanBenchmark.DTOs.MaxScoreDTO;
import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMaxScoreRepo;
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
    public int getUserMaxScore(MaxScoreDTO maxScoreDTO){
        MaxScore.MaxScoreId maxScoreId = new MaxScore.MaxScoreId(maxScoreDTO.getId_game(), maxScoreDTO.getId_player());
        if (maxScoreRepo.existsById(maxScoreId) == false) return -1;
        return maxScoreRepo.getReferenceById(maxScoreId).getScore();


    }

}



