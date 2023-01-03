package TJV.HumanBenchmark.Repository;


import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MaxScoreRepo extends JpaRepository<MaxScore, MaxScore.MaxScoreId>,CustomMaxScoreRepo{

}
