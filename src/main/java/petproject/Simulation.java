package petproject;

import petproject.action.Action;
import petproject.action.InitAction;
import petproject.action.TurnAction;
import petproject.entity.Entity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private Map map;
    private final InitAction initAction = new InitAction();
    private final TurnAction turnAction = new TurnAction();
    private Renderer renderer;
    private int movesCounter = 0;
    private boolean isGameStopped = false;

    void nextTurn(){
        turnAction.processCreatureMoves(map);
    }

    void startSimulation(){
        initAction.initMap();

        while (!isGameStopped) {
            nextTurn();
            movesCounter++;
        }
    }

    void stopSimulation(){
        isGameStopped = true;
    }

    public Map getMap() {
        return map;
    }
}
