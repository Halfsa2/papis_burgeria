package Game;

import Day.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void getToday() {
        game.newDay();
        Day day = game.getDays().getLast();
        assertEquals(day, game.getToday());
    }

    @Test
    void newDay() {
        int sizeOfDayList = game.getDays().size();
        game.newDay();
        assertEquals(sizeOfDayList+1, game.getDays().size());
    }

    @Test
    void increaseMoney() {
        game.increaseMoney(400);
        assertEquals(400, game.getMoney());
    }

    @Test
    void decreaseMoney() {
        game.increaseMoney(1000);
        game.decreaseMoney(400);
        assertEquals(600, game.getMoney());
    }

    @Test
    void increaseMoneyBasedOnScoreWhenScoreIsLow() {
        game.increaseMoneyBasedOnScore(1);
        assertEquals(0, game.getMoney());
    }
    @Test
    void increaseMoneyBasedOnScoreWhenScoreIsHigh() {
        game.increaseMoneyBasedOnScore(6);
        assertEquals(600, game.getMoney());
    }
}