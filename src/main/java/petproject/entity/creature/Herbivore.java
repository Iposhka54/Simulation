package petproject.entity.creature;

import petproject.BreadthFirstSearch;
import petproject.Coordinates;
import petproject.Ground;
import petproject.entity.Entity;
import petproject.entity.Grass;

import java.util.List;

import static petproject.Main.simulation;

public class Herbivore extends Creature {
    private BreadthFirstSearch breadthFirstSearch;

    private static void eatGrass(List<Coordinates> wayToObject) {
        Coordinates coordinatesOfGrass = wayToObject.get(0);
        Entity[][] map = simulation.getMap().getMap();
        map[coordinatesOfGrass.getX()][coordinatesOfGrass.getY()] = new Ground(coordinatesOfGrass);
    }

    @Override
    public void makeMove() {
        breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if (wayToObject.size() == 1) {
            eatGrass(wayToObject);
        } else {
            moveToGrass(wayToObject);
        }
    }

    private void moveToGrass(List<Coordinates> wayToObject) {
        // Remove herbivore from it current coordinates
        Entity[][] map = simulation.getMap().getMap();
        map[coordinates.getX()][coordinates.getY()] = new Ground(new Coordinates(coordinates.getX(), coordinates.getY()));
        // Set new coordinates to herbivore
        Coordinates coordinatesToMove = wayToObject.get(0);

        if (map[coordinatesToMove.getX()][coordinatesToMove.getY()].getClass().equals(Creature.class)) {
            coordinatesToMove = coordinates;
        }

        Herbivore herbivore = new Herbivore();
        herbivore.setCoordinates(coordinatesToMove);
        simulation.getMap().addObject(herbivore);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC07";
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
