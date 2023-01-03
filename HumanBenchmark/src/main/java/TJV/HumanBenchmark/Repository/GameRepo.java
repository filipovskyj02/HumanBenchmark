package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomGameRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepo extends JpaRepository<Game,Long>, CustomGameRepo {
    Optional<Game> findByname(String name);

}
