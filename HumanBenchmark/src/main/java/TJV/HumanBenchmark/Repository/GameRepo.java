package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Game;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomGameRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Primary

public interface GameRepo extends JpaRepository<Game,Long>, CustomGameRepo {
    Optional<Game> findByname(String name);

}
