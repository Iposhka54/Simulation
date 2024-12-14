package petproject.entity.creature;

import petproject.BreadthFirstSearch;
import petproject.Coordinates;
import petproject.Ground;
import petproject.entity.Entity;
import petproject.entity.Grass;

import java.util.List;

import static petproject.Main.simulation;

public class Herbivore extends Creature {
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    @Override
    public void makeMove() {
        List<Coordinates> wayToObject = breadthFirstSearch.findClosestObjectCoordinates(this.getCoordinates(), new Grass());

        if(wayToObject.size() == 1){
            Coordinates coordinatesOfGrass = wayToObject.getFirst();
            Entity[][] map = simulation.getMap().getMap();
            map[coordinatesOfGrass.getX()][coordinatesOfGrass.getY()] = new Ground(coordinatesOfGrass);
        }
        else{
            Coordinates coordinatesToMove = wayToObject.get(speed - 1);
            setCoordinates(coordinatesToMove);
        }
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
