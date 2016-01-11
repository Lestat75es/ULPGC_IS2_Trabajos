package swingversion.model.minesfield;

public class MinesFieldAttributes {

    private final int rows;
    private final int columns;
    private final int cellSideLength;
    private final int numberOfMines;

    public MinesFieldAttributes(int rows, int columns, int cellSideLength, int numberOfMines) {
        this.rows = rows;
        this.columns = columns;
        this.cellSideLength = cellSideLength;
        this.numberOfMines = numberOfMines;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getCellSideLength() {
        return cellSideLength;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public int getMinesFieldOuterSpaceWidth() {
        return cellSideLength * 2;
    }
}
