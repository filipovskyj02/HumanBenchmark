package TJV.HumanBenchmark.Repository;

import TJV.HumanBenchmark.Model.MedalPlayer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary

public interface MedalPlayerRepo extends JpaRepository<MedalPlayer,Long> {
}
