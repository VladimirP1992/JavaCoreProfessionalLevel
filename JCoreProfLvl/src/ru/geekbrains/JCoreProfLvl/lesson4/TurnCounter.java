package ru.geekbrains.JCoreProfLvl.lesson4;

public class TurnCounter {
    public final int MAX_TURN;
    private int turn = 0;

    public TurnCounter(int maxTurn){
        MAX_TURN = maxTurn;
    }

    public int getCurrentTurn() {
        return turn;
    }

    public boolean needsReset(){
        return turn > MAX_TURN;
    }

    public void reset(){
        turn = 0;
        System.out.println();
    }

    public void nextTurn() {
        turn++;
    }
}
