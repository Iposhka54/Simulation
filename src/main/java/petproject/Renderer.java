package petproject;

import petproject.entity.Entity;

/*
* Class for print simulation map
* */
public class Renderer {
    public void renderMap(Map mapObj) {
        Entity[][] map = mapObj.getMap();

        for (Entity[] entityRow : map) {
            for (Entity entity : entityRow) {
                System.out.print(entity.toString() + " ");
            }
            System.out.println();
        }
    }
}