package petproject.entity.stationary;

import petproject.Coordinates;
import petproject.entity.Entity;

public class Tree extends Entity {
    private final Coordinates coordinates;
    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public Tree() {
        this.coordinates = new Coordinates();
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
