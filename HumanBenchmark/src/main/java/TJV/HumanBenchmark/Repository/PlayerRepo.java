package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long>{


}
