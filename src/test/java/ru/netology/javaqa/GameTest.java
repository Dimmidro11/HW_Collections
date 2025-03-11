package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    @BeforeEach
    public void setup() {
        game.register(10, "Роман");
        game.register(25, "Артем");
        game.register(40, "Владислав");
        game.register(35, "Дмитрий");
        game.register(20, "Екатерина");
        game.register(15, "Ирина");
        game.register(13, "Вера");
        game.register(10, "Ульяна");
    }

    @Test
    public void shouldFindPlayer() {
        Integer expected = 10;
        Integer actual = game.searchByName("Роман");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.searchByName("Петр");
        });
    }

    @Test
    public void shouldWinVladislavPlayer1() {

        int expected = 1;
        int actual = game.round("Владислав", "Дмитрий");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayer1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петр", "Ирина");
        });
    }

    @Test
    public void shouldNotFindPlayer2() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Артем", "Петр");
        });
    }

    @Test
    public void shouldWinIrinaPlayer2() {

        int expected = 2;
        int actual = game.round("Вера", "Екатерина");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {

        int expected = 0;
        int actual = game.round("Ульяна", "Роман");

        Assertions.assertEquals(expected, actual);
    }


}
