package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomPlayerRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player,Long>, CustomPlayerRepo {

}
