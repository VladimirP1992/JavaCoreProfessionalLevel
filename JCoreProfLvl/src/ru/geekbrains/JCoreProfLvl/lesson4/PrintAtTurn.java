package ru.geekbrains.JCoreProfLvl.lesson4;

public class PrintAtTurn implements Runnable {

    private String myMessage;
    private TurnCounter turnCounter;
    private int[] myTurns;

    public PrintAtTurn(String message, TurnCounter turnCounter, int... turnNumbers) {
        myMessage = message;
        this.turnCounter = turnCounter;
        myTurns = turnNumbers;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (turnCounter) {
            while (true) {
                try {
                    //System.out.print(" Thread[" + myMessage + "] turn = " + turnCounter.getCurrentTurn() + " ");
                    Thread.sleep(200);
                    if (isMyTurn()) {
                        System.out.print(myMessage);
                        turnCounter.nextTurn();
                        turnCounter.notifyAll();
                        if (turnCounter.needsReset()) {
                            turnCounter.reset();
                        }
                    }else {
                        turnCounter.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Если текущий ход совпадает с одним из моих, то TRUE
    private boolean isMyTurn() {
        boolean result = false;
        for (int i : myTurns) {
            if (i == turnCounter.getCurrentTurn()) {
                result = true;
                break;
            }
        }
        return result;
    }
}
