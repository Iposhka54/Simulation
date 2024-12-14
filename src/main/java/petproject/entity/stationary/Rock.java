package petproject.entity.stationary;

import petproject.Coordinates;
import petproject.entity.Entity;

public class Rock extends Entity {
    private final Coordinates coordinates;

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Rock() {
        coordinates = new Coordinates();
    }
    @Override
    public String toString() {
        return "\uD83D\uDDFF";
    }
}
