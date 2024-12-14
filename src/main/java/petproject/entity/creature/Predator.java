package petproject.entity.creature;

import petproject.BreadthFirstSearch;
import petproject.Coordinates;
import petproject.entity.Grass;

import java.util.List;

public class Predator extends Creature {
    int attack;
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());
        Coordinates coordinatesToMove = wayToObject.get(speed - 1);
        this.setCoordinates(coordinatesToMove);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}
