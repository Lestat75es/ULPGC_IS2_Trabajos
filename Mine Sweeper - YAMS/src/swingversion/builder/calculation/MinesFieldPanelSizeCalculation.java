package swingversion.builder.calculation;

import java.awt.Dimension;
import swingversion.model.minesfield.MinesFieldAttributes;

public class MinesFieldPanelSizeCalculation {

    private final MinesFieldAttributes minesFieldAttributes;

    public MinesFieldPanelSizeCalculation(MinesFieldAttributes minesFieldAttributes) {
        this.minesFieldAttributes = minesFieldAttributes;
    }

    public Dimension execute() {
        return new Dimension(
                calculateMinesFieldWidth(),
                calculateMinesFieldHeight());
    }

    private int calculateMinesFieldWidth() {
        return getColumns() * getCellSideLength();
    }

    private int calculateMinesFieldHeight() {
        return getRows() * getCellSideLength();
    }

    private int getColumns() {
        return minesFieldAttributes.getColumns();
    }

    private int getRows() {
        return minesFieldAttributes.getRows();
    }

    private int getCellSideLength() {
        return minesFieldAttributes.getCellSideLength();
    }
}
