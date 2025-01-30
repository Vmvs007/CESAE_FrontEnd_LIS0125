package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStoreTest {

    private GameStore gameStore;

    @BeforeEach
    void setUp() {
        gameStore= new GameStore();
    }

    @Test
    public void testGameStoreStartsEmpty(){
        assertTrue(gameStore.getStock().isEmpty());
        assertTrue(gameStore.getSales().isEmpty());
    }

    @Test
    public void testAddGameToStock(){
        gameStore.addGameToStock(new VideoGame("Skyrim", "Beteshda", 10.0, 50.0));
        gameStore.addGameToStock(new VideoGame("GTA V", "Rockstar", 15.0, 70.0));

        assertEquals(2,gameStore.getStock().size());
        assertEquals(0,gameStore.getSales().size());

        gameStore.addGameToStock(new VideoGame("FIFA 22", "Electronic Arts", 20.0, 45.0));
        gameStore.addGameToStock(new VideoGame("Assassin's Creed Valhalla", "Ubisoft", 35.0, 55.0));

        assertEquals(4,gameStore.getStock().size());
        assertEquals(0,gameStore.getSales().size());

    }

    @Test
    public void testSellGame(){
        gameStore.addGameToStock(new VideoGame("FIFA 22", "Electronic Arts", 20.0, 45.0));
        gameStore.addGameToStock(new VideoGame("Assassin's Creed Valhalla", "Ubisoft", 35.0, 55.0));
        gameStore.addGameToStock(new VideoGame("Skyrim", "Beteshda", 10.0, 50.0));
        gameStore.addGameToStock(new VideoGame("GTA V", "Rockstar", 15.0, 70.0));

        assertEquals(4,gameStore.getStock().size());
        assertEquals(0,gameStore.getSales().size());

        gameStore.sellGame(0);

        assertEquals(3,gameStore.getStock().size());
        assertEquals(1,gameStore.getSales().size());

        gameStore.sellGame(0);
        gameStore.sellGame(1);

        assertEquals(1,gameStore.getStock().size());
        assertEquals(3,gameStore.getSales().size());
    }

    @Test
    public void testSellGameOutOfBounds(){
        gameStore.addGameToStock(new VideoGame("FIFA 22", "Electronic Arts", 20.0, 45.0));
        gameStore.addGameToStock(new VideoGame("Assassin's Creed Valhalla", "Ubisoft", 35.0, 55.0));
        gameStore.addGameToStock(new VideoGame("Skyrim", "Beteshda", 10.0, 50.0));
        gameStore.addGameToStock(new VideoGame("GTA V", "Rockstar", 15.0, 70.0));

        assertEquals(4,gameStore.getStock().size());
        assertEquals(0,gameStore.getSales().size());

        assertThrows(IllegalArgumentException.class, () -> gameStore.sellGame(10));

    }
}