
package TJV.HumanBenchmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaxScoreRepo extends JpaRepository<MaxScore, MaxScore.MaxScoreId>, CustomMaxScoreRepo {

}
