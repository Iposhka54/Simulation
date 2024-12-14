package petproject;

import petproject.entity.Entity;

public class Ground extends Entity {

    public Ground(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Ground() {
        this.coordinates = new Coordinates();
    }

    @Override
    public String toString() {
        return "\uD83D\uDFEB";
    }
}
