package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHours() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        int actual = player.play(game, 3);;
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }

    @Test
    public void shouldFindMostPlayedGameByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 10);
        player.play(game3, 2);
        Game actual = player.mostPlayerByGenre(game2.getGenre());
        Game expected = game2;
        assertEquals(expected, actual);
    }
}
