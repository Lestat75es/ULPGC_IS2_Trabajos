package swingversion.model.initialconfiguration;


import java.awt.Color;

public class MineSweeperInitialConfiguration {

    private final String title;
    private final int rows;
    private final int columns;
    private final int cellSideLength;
    private final int numberOfMines;
    private final Color mineFieldOuterSpaceColor;

    public MineSweeperInitialConfiguration(String title, int rows, int columns, int cellSideLength, int numberOfMines, Color mineFieldOuterSpaceColor) {
        this.title = title;
        this.rows = rows;
        this.columns = columns;
        this.cellSideLength = cellSideLength;
        this.numberOfMines = numberOfMines;
        this.mineFieldOuterSpaceColor = mineFieldOuterSpaceColor;
    }

    public String getTitle() {
        return title;
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

    public Color getMineFieldOuterSpaceColor() {
        return mineFieldOuterSpaceColor;
    }
}
