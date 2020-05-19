package com.wzw.interfaces;

import java.util.Random;

public class Games {
    public static void playGame(GameFacory gameFacory) {
        Game game = gameFacory.getGame();
        game.printStatus();
    }

    public static void main(String[] args) {
        playGame(new CoinFactory());
        playGame(new DiceFactory());
    }
}

interface Game {
    Random random = new Random(47);
    void printStatus();
}
interface GameFacory{
    Game getGame();
}

class Coin implements Game {
    @Override
    public void printStatus() {
        System.out.println(random.nextInt(2));
    }
}

class CoinFactory implements GameFacory {
    @Override
    public Game getGame() {
        return new Coin();
    }
}
class Dice implements Game {

    @Override
    public void printStatus() {
        System.out.println(random.nextInt(6));
    }
}

class DiceFactory implements GameFacory {
    @Override
    public Game getGame() {
        return new Dice();
    }
}

