package swingversion.builder.calculation;

import java.awt.Dimension;
import swingversion.model.minesfield.MinesFieldAttributes;

public class OuterSpaceSizePanelCalculation {

    private final MinesFieldAttributes minesFieldAttributes;

    public OuterSpaceSizePanelCalculation(MinesFieldAttributes minesFieldAttributes) {
        this.minesFieldAttributes = minesFieldAttributes;
    }

    public Dimension getHorizontalPanelSize() {
        return new Dimension(
                horizontalLength(),
                shortLength());
    }

    public Dimension getVerticalPanelSize() {
        return new Dimension(
                shortLength(),
                verticalLength());
    }

    private int shortLength() {
        return minesFieldAttributes.getCellSideLength() * 2;
    }

    private int horizontalLength() {
        return getMinesFieldPanelSize().width + shortLength() * 2;
    }

    private int verticalLength() {
        return getMinesFieldPanelSize().height + shortLength() * 2;
    }

    private Dimension getMinesFieldPanelSize() {
        return new MinesFieldPanelSizeCalculation(minesFieldAttributes).execute();
    }
}
