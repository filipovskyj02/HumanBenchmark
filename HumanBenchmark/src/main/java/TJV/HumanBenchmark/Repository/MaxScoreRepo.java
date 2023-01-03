package TJV.HumanBenchmark.Repository;


import TJV.HumanBenchmark.Model.MaxScore;
import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMaxScoreRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MaxScoreRepo extends JpaRepository<MaxScore, MaxScore.MaxScoreId>, CustomMaxScoreRepo {
}
