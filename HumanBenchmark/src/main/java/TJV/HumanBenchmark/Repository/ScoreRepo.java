package TJV.HumanBenchmark.Repository;


import TJV.HumanBenchmark.Model.Score;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomScoreRepo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScoreRepo extends JpaRepository<Score,Long>, CustomScoreRepo {

}
