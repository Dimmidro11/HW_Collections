package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();
    Player roman = new Player(1, "Роман", 10);
    Player artem = new Player (2, "Артем",25);
    Player vladislav = new Player (3, "Владислав",40);
    Player dmitry = new Player (4, "Дмитрий",35);
    Player ekaterina = new Player (5, "Екатерина",20);
    Player irina = new Player (6, "Ирина",15);
    Player vera = new Player (7, "Вера",13);
    Player ulyana = new Player (8, "Ульяна",10);

    @BeforeEach
    public void setup() {
        game.register(roman);
        game.register(artem);
        game.register(vladislav);
        game.register(dmitry);
        game.register(ekaterina);
        game.register(irina);
        game.register(vera);
        game.register(ulyana);
    }

    @Test
    public void shouldFindByName() {

        Player expected = vladislav;
        Player actual = game.searchByName("Владислав");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayerByName() {

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
