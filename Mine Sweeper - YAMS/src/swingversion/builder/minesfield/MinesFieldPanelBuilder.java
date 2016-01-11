package swingversion.builder.minesfield;

import java.awt.GridLayout;
import java.util.List;
import swingversion.builder.Builder;
import swingversion.builder.calculation.MinesFieldPanelSizeCalculation;
import swingversion.model.minesfield.MinesFieldAttributes;
import swingversion.model.minesfield.MinesFieldPanel;
import swingversion.model.tablecellbutton.TableCellButton;

public class MinesFieldPanelBuilder implements Builder {

    private final MinesFieldAttributes minesFieldAttributes;
    private final List<TableCellButton> tableCellButtons;

    public MinesFieldPanelBuilder(MinesFieldAttributes minesFieldAttributes, List<TableCellButton> tableCellButtons) {
        this.minesFieldAttributes = minesFieldAttributes;
        this.tableCellButtons = tableCellButtons;
    }

    @Override
    public MinesFieldPanel build() {
        MinesFieldPanel minesFieldPanel = new MinesFieldPanel(tableCellButtons);
        setLayout(minesFieldPanel);
        setPreferredSize(minesFieldPanel);
        buildButtonsGrid(minesFieldPanel);
        return minesFieldPanel;
    }

    private void setLayout(MinesFieldPanel minesFieldPanel) {
        minesFieldPanel.setLayout(
                new GridLayout(
                        minesFieldAttributes.getRows(),
                        minesFieldAttributes.getColumns()));
    }

    private void setPreferredSize(MinesFieldPanel minesFieldPanel) {
        minesFieldPanel.setPreferredSize(getMinesFieldPanelSizeCalculation().execute());
    }

    private MinesFieldPanelSizeCalculation getMinesFieldPanelSizeCalculation() {
        return new MinesFieldPanelSizeCalculation(minesFieldAttributes);
    }

    private void buildButtonsGrid(MinesFieldPanel minesFieldPanel) {
        tableCellButtons.stream().forEachOrdered(tableCellButton -> minesFieldPanel.add(tableCellButton));
    }
}
