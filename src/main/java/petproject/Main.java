package petproject;

import petproject.action.InitAction;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InitAction initAction = new InitAction();
        Map map = initAction.InitMap();
        System.out.println(Arrays.deepToString(map.getMap()));
    }
}
