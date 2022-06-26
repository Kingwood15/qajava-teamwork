package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainsGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");
        Game game2 = store.publishGame("Game 2", "Файтинг");

        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldContainsGameNotIncomingInGameStore() {

        GameStore store1 = new GameStore();
        GameStore store2 = new GameStore();

        Game game = store2.publishGame("Game 1", "Аркады");

        assertFalse(store1.containsGame(game));
    }

    @Test
    public void shouldAddPlayerTime() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Sveta", 2);

        int actual = store.getSumPlayedTime();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayerTimeInWeek() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Ivan", 1);
        store.addPlayTime("Ivan", 3);
        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Ivan", 1);
        store.addPlayTime("Ivan", 4);

        int actual = store.getSumPlayedTime();
        int expected = 13;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEnd() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Semen", 3);
        store.addPlayTime("Sergey", 2);
        store.addPlayTime("Andrey", 1);
        store.addPlayTime("Anya", 4);

        String actual = store.getMostPlayer();
        String expected = "Anya";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerFirst() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 6);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Semen", 3);
        store.addPlayTime("Sergey", 2);
        store.addPlayTime("Andrey", 1);
        store.addPlayTime("Anya", 4);

        String actual = store.getMostPlayer();
        String expected = "Ivan";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerMid() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Semen", 3);
        store.addPlayTime("Sergey", 5);
        store.addPlayTime("Andrey", 1);
        store.addPlayTime("Anya", 4);

        String actual = store.getMostPlayer();
        String expected = "Sergey";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerIfZeroPlayer() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        String actual = store.getMostPlayer();
        String expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerIfZeroPlayedTime() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 0);
        store.addPlayTime("Sveta", 0);


        String actual = store.getMostPlayer();
        String expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Game 1", "Аркады");

        store.addPlayTime("Ivan", 2);
        store.addPlayTime("Sveta", 1);
        store.addPlayTime("Semen", 3);
        store.addPlayTime("Sergey", 5);
        store.addPlayTime("Andrey", 1);
        store.addPlayTime("Anya", 4);

        int actual = store.getSumPlayedTime();
        int expected = 16;

        assertEquals(expected, actual);
    }
}
