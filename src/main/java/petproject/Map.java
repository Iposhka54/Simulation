package petproject;

import petproject.entity.Entity;

import java.util.Arrays;

public class Map {
    private Entity[][] map;

    public void initMap(int width, int height) {
        this.map = new Entity[width][height];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new Ground(new Coordinates(x, y));
            }
        }
        System.out.println(Arrays.deepToString(map));
    }
}
