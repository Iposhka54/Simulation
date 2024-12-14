package petproject.action;

import petproject.Coordinates;
import petproject.Ground;
import petproject.Map;
import petproject.entity.Entity;
import petproject.entity.Grass;
import petproject.entity.creature.Herbivore;
import petproject.entity.creature.Predator;
import petproject.entity.stationary.Rock;
import petproject.entity.stationary.Tree;

import java.util.HashMap;
import java.util.Random;

public class InitAction extends Action {
    private Map map;

    /**
     * Initializes the map by creating a pool of objects and adding them to the map.
     * <p>
     * This method creates a `Map` object and then generates a pool of objects (Grass, Herbivore, Predator, Tree, Rock) using the `createObjectPoolForMap` method. The objects in the pool are then assigned random coordinates using the `assignRandomCoordinatesToEntity` method, and finally added to the `Map` object using the `addObject` method. The fully initialized `Map` object is then returned.
     *
     * @return A fully initialized `Map` object containing a pool of objects.
     */
    public Map initMap() {
        map = new Map();

        HashMap<Integer, Integer> pool = createObjectPoolForMap(map);

        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                if (i == 0) {
                    Grass grass = new Grass();
                    assignRandomCoordinatesToEntity(grass);
                    map.addObject(grass);
                }
                if (i == 1) {
                    Herbivore herbivore = new Herbivore();
                    assignRandomCoordinatesToEntity(herbivore);
                    map.addObject(herbivore);
                }
                if (i == 2) {
                    Predator predator = new Predator();
                    assignRandomCoordinatesToEntity(predator);
                    map.addObject(predator);
                }
                if (i == 3) {
                    Tree tree = new Tree();
                    assignRandomCoordinatesToEntity(tree);
                    map.addObject(tree);
                }
                if (i == 4) {
                    Rock rock = new Rock();
                    assignRandomCoordinatesToEntity(rock);
                    map.addObject(rock);
                }
            }
        }


        for (int i = 0; i < map.getMap().length; i++) {
            for (int j = 0; j < map.getMap()[i].length; j++) {
                Entity entity = map.getMap()[i][j];

                if (entity == null) {
                    Ground ground = new Ground(new Coordinates(i, j));
                    map.addObject(ground);
                }
            }
        }

        return map;
    }

    /**
     * Creates a pool of objects for a given map.
     * <p>
     * This method uses the size of the map to calculate the total area and the amount of each type of object
     * (Grass, Herbivore, Predator, Tree, Rock) that should be created. These amounts are then stored as key-value pairs
     * in a `HashMap`, with the object as the key and the amount as the value. The resulting `HashMap` is returned.
     *
     * @param map The map for which the object pool is being created.
     * @return A `HashMap` containing the objects and their corresponding amounts.
     */
    private HashMap<Integer, Integer> createObjectPoolForMap(Map map) {
        HashMap<Integer, Integer> pool = new HashMap<>();

        int x = map.getMap().length;
        int y = map.getMap()[0].length;
        int mapArea = x * y;

        int amountOfGrass = mapArea / 2;
        pool.put(0, amountOfGrass);

        int amountOfHerbivores = amountOfGrass / 10;
        pool.put(1, amountOfHerbivores);

        int amountOfPredators = amountOfHerbivores / 5;
        pool.put(2, amountOfPredators);

        int amountOfTress = amountOfGrass / 10;
        pool.put(3, amountOfTress);

        int amountOfRocks = amountOfGrass / 10;
        pool.put(4, amountOfRocks);

        return pool;
    }

    /**
     * Assigns random coordinates to a given entity.
     * <p>
     * This method uses the length and width of the map to determine the upper bounds for the x and y coordinates.
     * A `java.util.Random` object is used to generate random values within these bounds. The resulting x and y
     * coordinates are used to create a `Coordinates` object, which is then set as the entity's coordinates.
     * The entity with its updated coordinates is returned.
     *
     * @param entity The entity for which the random coordinates are being assigned.
     */
    private <T extends Entity> void assignRandomCoordinatesToEntity(T entity) {
        int xUpperBound = map.getMap().length;
        int yUpperBound = map.getMap()[0].length;

        Random random = new Random();

        int randomX = random.nextInt(xUpperBound);
        int randomY = random.nextInt(yUpperBound);

        Coordinates coordinates = new Coordinates(randomX, randomY);

        entity.setCoordinates(coordinates);
    }
}
