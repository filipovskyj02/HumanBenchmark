package TJV.HumanBenchmark.Repository.Implementations;

import TJV.HumanBenchmark.DTOs.ScoreDTO;
import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.*;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomScoreRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public class ScoreRepoImpl implements CustomScoreRepo {
    @Lazy
    @Autowired
    ScoreRepo scoreRepo;



    @Override
    public boolean deleteScoreById(long id){
        if (!scoreRepo.existsById(id)) return false;
        scoreRepo.deleteById(id);
        return true;
    }
    @Override
    public Optional<Score> update(long id,ScoreDTO scoreDTO){
        if (!scoreRepo.existsById(id)) return Optional.empty();
        Score score = scoreRepo.getReferenceById(id);
        score.setScore(scoreDTO.getScore());
        scoreRepo.flush();
        return Optional.of(score);

    }
}