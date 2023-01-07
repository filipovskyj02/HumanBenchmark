package TJV.HumanBenchmark.Repository;


import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomScoreRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary


public interface ScoreRepo extends JpaRepository<Score,Long>, CustomScoreRepo {

}
