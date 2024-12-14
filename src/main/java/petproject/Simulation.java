package petproject;

import petproject.action.Action;
import petproject.action.InitAction;
import petproject.action.TurnAction;
import petproject.entity.Entity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private final InitAction initAction = new InitAction();
    private final TurnAction turnAction = new TurnAction();
    private Map map;
    private boolean isGameStopped = false;

    void nextTurn(){

    }

    void startSimulation() throws InterruptedException {
        map = initAction.initMap();
        while (!isGameStopped) {
            for (Entity[] entityRow : map.getMap()) {
                for (Entity entity : entityRow) {
                    System.out.print(entity.toString() + " ");
                }
                System.out.println();
            }
            nextTurn();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    void stopSimulation(){
        
    }

    public Map getMap() {
        return map;
    }
}
