package TJV.HumanBenchmark.Repository;


import TJV.HumanBenchmark.Model.MaxScore;

import TJV.HumanBenchmark.Repository.RepoInterface.CustomMaxScoreRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
@Primary

public interface MaxScoreRepo extends JpaRepository<MaxScore, MaxScore.MaxScoreId>, CustomMaxScoreRepo {
}
