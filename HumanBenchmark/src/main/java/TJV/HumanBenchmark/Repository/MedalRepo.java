package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.Medal;
import TJV.HumanBenchmark.Repository.RepoInterface.CustomMedalRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Primary

public interface MedalRepo extends JpaRepository<Medal,Long>, CustomMedalRepo {
    Optional<Medal> findByname(String name);
}
