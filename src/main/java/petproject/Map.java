package petproject;

import petproject.entity.Entity;

public class Map {
    int x;
    int y;
    private Entity[][] map;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        this.map = new Entity[x][y];
    }

    public Map(){
        this.x = 20;
        this.y = 20;
        this.map = new Entity[x][y];
    }

    public Entity[][] getMap() {
        return map;
    }

    public void setMap(Entity[][] map) {
        this.map = map;
    }

    /*
     * Adds an object to the map.
     * <p>
     * This method takes an `Entity` object and adds it to the map at the coordinates specified by the object's `Coordinates`. The x and y values of the `Coordinates` are used to determine the position in the map where the object will be added.
     *
     * @param object The `Entity` object to be added to the map.
     */
    public void addObject(Entity object) {
        Coordinates coordinates = object.getCoordinates();
        map[coordinates.getX()][coordinates.getY()] = object;
    }

    public void refreshMap(){
        for (Entity[] entities : map) {
            for (Entity entity : entities) {
                map[entity.getCoordinates().getX()][entity.getCoordinates().getY()] = entity;
            }
        }
    }
}
