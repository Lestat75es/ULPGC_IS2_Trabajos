package swingversion.builder.calculation;

import swingversion.model.position.Position;

public class LocationCalculation {

    public static Position indexToPosition(int tableCellIndex, int maxColumns) {
        return new Position(
                tableCellIndex / maxColumns,
                tableCellIndex % maxColumns);
    }

    public static int positionToIndex(Position position, int maxRows, int maxColumns) {
        return position.getRow() * maxColumns + position.getColumn();
    }

    public static Position relativePosition(Position position, Position offset) {
        return new Position(
                position.getRow() + offset.getRow(),
                position.getColumn() + offset.getColumn());
    }

    public static boolean isValidPosition(Position neighbourPosition, int maxRows, int maxColumns) {
        int row = neighbourPosition.getRow();
        int column = neighbourPosition.getColumn();
        return row > 0 && row < maxRows && column > 0 && column < maxColumns;
    }
}
