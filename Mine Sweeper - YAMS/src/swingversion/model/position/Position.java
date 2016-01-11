package swingversion.model.position;

public class Position {

    private final int row;
    private final int column;

    public static final Position NORTHWEST_OFFEST = new Position(-1, -1);
    public static final Position NORTH_OFFEST = new Position(-1, 0);
    public static final Position NORTHEAST_OFFEST = new Position(-1, 1);
    public static final Position WEST_OFFEST = new Position(0, -1);
    public static final Position EAST_OFFEST = new Position(0, 1);
    public static final Position SOUTHWEST_OFFEST = new Position(1, -1);
    public static final Position SOUTH_OFFEST = new Position(1, 0);
    public static final Position SOUTHEAST_OFFEST = new Position(1, 1);

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
