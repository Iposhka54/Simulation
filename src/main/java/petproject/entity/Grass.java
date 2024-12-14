package petproject.entity;

import petproject.Coordinates;

public class Grass extends Entity {

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Grass() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3E";
    }
}
