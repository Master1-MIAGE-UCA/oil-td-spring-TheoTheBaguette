package seminara.dice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seminara.dice.entity.DiceRollLog;
import seminara.dice.repository.DiceRollLogRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryController {

    private final DiceRollLogRepository repository;

    @Autowired
    public HistoryController(DiceRollLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllLogs() {
        return repository.findAll();
    }
}
