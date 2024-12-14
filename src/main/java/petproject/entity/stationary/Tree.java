package petproject.entity.stationary;

import petproject.Coordinates;
import petproject.entity.Entity;

public class Tree extends Stationary {
    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Tree() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
