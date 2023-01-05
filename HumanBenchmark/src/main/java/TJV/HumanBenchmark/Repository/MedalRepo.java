package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMedalRepo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedalRepo extends JpaRepository<Medal,Long>, CustomMedalRepo {
    Optional<Medal> findByname(String name);
}
