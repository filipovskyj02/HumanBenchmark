package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game,Long>, CustomGameRepo {

}
