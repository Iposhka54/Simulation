import petproject.Coordinates;
import petproject.Main;
import petproject.Map;
import petproject.Simulation;
import petproject.entity.Entity;
import petproject.entity.stationary.Stationary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BreadthFirstSearch {

    private final Simulation simulation = Main.simulation;
    private final List<Coordinates> queuedCoordinates = new ArrayList<>();
    private final List<Coordinates> exploredCoordinates = new ArrayList<>();
    private final HashMap<Coordinates, Coordinates> childParentMap = new HashMap<>();
    private Entity[][] map;
    private Entity objectToFind;

    public List<Coordinates> findClosestObjectCoordinates(Coordinates currentCoordinates, Entity objectToFind) {
        this.map = simulation.getMap().getMap();
        this.objectToFind = objectToFind;

        queuedCoordinates.add(currentCoordinates);

        Coordinates coordinatesOfDesiredObject = exploreQueuedObjects();

        while (coordinatesOfDesiredObject == null) {
            coordinatesOfDesiredObject = exploreQueuedObjects();
        }

        return findWayToObject(coordinatesOfDesiredObject);
    }

    private Coordinates exploreQueuedObjects() {
        for (int i = 0; i < queuedCoordinates.size(); i++) {
            Coordinates coordinate = queuedCoordinates.get(i);

            Entity object = map[coordinate.getX()][coordinate.getY()];

            if (object.getClass().equals(objectToFind.getClass())) {
                return coordinate;
            }

            exploredCoordinates.add(coordinate);
        }

        queuedCoordinates.removeAll(exploredCoordinates);
        findEnqueuedCoordinates();

        return null;
    }

    private void findEnqueuedCoordinates() {
        for (Coordinates coordinate : exploredCoordinates) {
            findEnqueuedCoordinates(coordinate);
        }
    }

    private void findEnqueuedCoordinates(Coordinates coordinates) {
        int startX = coordinates.getX() - 1;
        if (startX < 0) {
            startX = 0;
        }

        int endX = coordinates.getX() + 1;
        if (endX > map.length - 1) {
            endX = map.length - 1;
        }

        int startY = coordinates.getY() - 1;
        if (startY < 0) {
            startY = 0;
        }

        int endY = coordinates.getY() + 1;
        if (endY > map[0].length - 1) {
            endY = map[0].length - 1;
        }

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                Coordinates coordinatesOfEnqueuedObject = new Coordinates(i, j);
                Entity entity = map[coordinatesOfEnqueuedObject.getX()][coordinatesOfEnqueuedObject.getY()];

                if (!queuedCoordinates.contains(coordinatesOfEnqueuedObject)
                        && !exploredCoordinates.contains(coordinatesOfEnqueuedObject)
                        && !(entity instanceof Stationary)) {
                    childParentMap.put(coordinatesOfEnqueuedObject, coordinates);
                    queuedCoordinates.add(coordinatesOfEnqueuedObject);
                }
            }
        }
    }

    private List<Coordinates> findWayToObject(Coordinates coordinatesOfDesiredObject) {
        List<Coordinates> way = new ArrayList<>();

        while (childParentMap.containsKey(coordinatesOfDesiredObject)) {
            way.add(coordinatesOfDesiredObject);
            coordinatesOfDesiredObject = childParentMap.get(coordinatesOfDesiredObject);
        }

        Collections.reverse(way);

        return way;
    }
}