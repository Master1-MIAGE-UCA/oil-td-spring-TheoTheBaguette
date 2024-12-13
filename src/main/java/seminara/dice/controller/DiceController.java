package seminara.dice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seminara.dice.service.DiceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    private final DiceService diceService;

    @Autowired
    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public List<Integer> rollDice() {
        return diceService.rollDice(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollDices(@PathVariable int count) {
        return diceService.rollDice(count);
    }
}
