package petproject.entity.creature;

import petproject.BreadthFirstSearch;
import petproject.Coordinates;
import petproject.entity.Grass;

import java.util.List;

public class Herbivore extends Creature {
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());
        Coordinates coordinatesToMove = wayToObject.get(speed - 1);
        this.setCoordinates(coordinatesToMove);
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
