package petproject.entity.creature;

import petproject.BreadthFirstSearch;
import petproject.Coordinates;
import petproject.entity.Entity;
import petproject.entity.Grass;

import java.util.List;

import static petproject.Main.simulation;

public class Predator extends Creature {
    int attack;
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Herbivore());

        if (wayToObject.size() == 1) {
            Coordinates coordinatesOfHerbivore = wayToObject.get(0);
            Entity[][] map = simulation.getMap().getMap();
            Herbivore herbivore = (Herbivore) map[coordinatesOfHerbivore.getX()][coordinatesOfHerbivore.getY()];
            int herbivoreHp = herbivore.getHp();
            herbivore.setHp(herbivoreHp - attack);
        }
        else {
            Coordinates coordinatesToMove = wayToObject.get(speed - 1);
            setCoordinates(coordinatesToMove);
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
