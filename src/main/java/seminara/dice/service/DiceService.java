package seminara.dice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminara.dice.domain.Dice;
import seminara.dice.entity.DiceRollLog;
import seminara.dice.repository.DiceRollLogRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository repository;

    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    public List<Integer> rollDice(int count) {
        List<Integer> results = IntStream.range(0, count)
                .mapToObj(i -> dice.roll())
                .collect(Collectors.toList());

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        repository.save(log);

        return results;
    }
}
