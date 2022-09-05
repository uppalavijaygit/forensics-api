package uk.co.which.forensicsapi.model;

public enum Direction {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0, -1),
    WEST(-1, 0);
    Direction(int x, int y) {
    }
}
