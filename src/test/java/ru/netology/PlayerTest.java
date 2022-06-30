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
    public void TestForInstallShouldInstallAndSumGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game);
        player.installGame(game);
        player.play(game, 3);
        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreOfTwoGamesIfThreeGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 10);
        player.play(game2, 4);
        player.play(game3, 2);
        int expected = 12;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreOfOneGameIfThreeGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 10);
        player.play(game2, 4);
        player.play(game3, 2);
        int expected = 4;
        int actual = player.sumGenre(game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreOfNoGamesIfFourGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Game game4 = store.publishGame("Риддик", "РПГ");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 10);
        player.play(game2, 4);
        player.play(game3, 2);
        int expected = 0;
        int actual = player.sumGenre(game4.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHoursIfPlayOneTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        int actual = player.play(game, 3);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHoursIfPlayTwoTimes() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        int actual = player.play(game, 3) + player.play(game,4);
        int expected = 7;
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
        Game actual1 = player.mostPlayerByGenre(game2.getGenre());
        Game expected1 = game2;
        Game actual2 = player.mostPlayerByGenre(game3.getGenre());
        Game expected2 = game1;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void shouldReturnNullWhenMostPlayedGameByGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Петька и Василий Иванович", "Квест");
        Game game3 = store.publishGame("Аллоды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game3, 2);
        Game actual = player.mostPlayerByGenre(game2.getGenre());
        assertEquals(null, actual);
    }
}
