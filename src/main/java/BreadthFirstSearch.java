import petproject.Coordinates;
import petproject.Simulation;
import petproject.entity.Entity;

import java.util.List;

public class BreadthFirstSearch {
    private Simulation simulation;
    private Entity[][] map;
    private List<Coordinates> queueCoordinates;
    private List<Coordinates> checkedCoordinates;
    private Entity objectToFind;

    public Coordinates findClosestObjectCoordinates(Coordinates currentCoordinates, Entity objectToFind) {
        this.map = simulation.getMap().getMap();
        this.objectToFind = objectToFind;

        queueCoordinates.add(currentCoordinates);

        return exploreQueuedObjects();
    }

    private Coordinates exploreQueuedObjects() {
        Coordinates coordinatesOfDesiredObject = null;

        for(Coordinates coordinate : queueCoordinates) {
            Entity entity = map[coordinate.getX()][coordinate.getY()];
            if(entity.getClass().equals(objectToFind.getClass())) {
                coordinatesOfDesiredObject = coordinate;
            }

            queueCoordinates.remove(coordinate);
            checkedCoordinates.add(coordinate);

            findEnqueuedCoordinates(coordinate);
        }

        if(coordinatesOfDesiredObject == null) {
            exploreQueuedObjects();
        }
        return coordinatesOfDesiredObject;
    }

    private void findEnqueuedCoordinates(Coordinates coordinate) {
        int startX = coordinate.getX() - 1;
        int endX = coordinate.getX() + 1;
        int startY = coordinate.getY() - 1;
        int endY = coordinate.getY() + 1;

        for(int i = startX; i <= endX; i++) {
            for(int j = startY; j <= endY; j++) {
                Coordinates coordinatesOfEnqueuedObject = new Coordinates(i, j);

                if(!queueCoordinates.contains(coordinatesOfEnqueuedObject) && !checkedCoordinates.contains(coordinatesOfEnqueuedObject)) {
                    queueCoordinates.add(coordinatesOfEnqueuedObject);
                }
            }
        }

    }
}
