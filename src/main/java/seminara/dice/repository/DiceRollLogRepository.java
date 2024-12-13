package seminara.dice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seminara.dice.entity.DiceRollLog;

public interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {
}
