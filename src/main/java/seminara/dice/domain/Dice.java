package seminara.dice.domain;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {
    private static final Random RANDOM = new Random();

    public int roll() {
        return RANDOM.nextInt(6) + 1; // Génère un nombre entre 1 et 6.
    }
}
