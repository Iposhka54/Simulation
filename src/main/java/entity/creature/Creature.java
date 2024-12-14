package entity.creature;

import entity.Entity;

public abstract class Creature extends Entity {
    int hp;
    int speed;

    public abstract void makeMove();
}
