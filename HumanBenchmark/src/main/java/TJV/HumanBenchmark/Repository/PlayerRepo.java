package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Player;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomPlayerRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Primary

public interface PlayerRepo extends JpaRepository<Player,Long>, CustomPlayerRepo {
    Optional<Player> findByemail(String email);


}
