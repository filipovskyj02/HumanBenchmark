package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomPlayerRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository<Player,Long>, CustomPlayerRepo {
    Optional<Player> findByemail(String email);
}
