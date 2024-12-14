package petproject.action;

import petproject.Map;
import petproject.Renderer;
import petproject.entity.Entity;
import petproject.entity.creature.Creature;

import static petproject.Main.simulation;

public class TurnAction extends Action {
    /**
     Processes the moves of all creatures on the map.
     @param mapObj The map object which contains all the entities, including the creatures.
     */
    public void processCreatureMoves(Map mapObj){
        Entity[][] map = mapObj.getMap();

        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                if(entity instanceof Creature creature){
                    creature.makeMove();
                }
            }
        }
        mapObj.refreshMap();
    }

    public void renderMap(Map map) {
        Renderer renderer = simulation.getRenderer();
        renderer.renderMap(map);
    }
}
