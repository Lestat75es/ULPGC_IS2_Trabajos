package swingversion.builder.minesfield;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import swingversion.builder.Builder;
import swingversion.builder.tablecellbutton.MinesLocationListBuilder;
import swingversion.builder.tablecellbutton.TableCellButtonListBuilder;
import swingversion.builder.calculation.OuterSpaceSizePanelCalculation;
import swingversion.model.minesfield.MinesFieldAttributes;
import swingversion.model.minesfield.MinesFieldPanelContainer;
import swingversion.model.minesfield.MinesFieldPanel;
import swingversion.model.tablecellbutton.TableCellButton;

public class MinesFieldPanelContainerBuilder implements Builder {

    private final MinesFieldAttributes minesFieldAttributes;
    private final MinesFieldPanel minesFieldPanel;
    private final List<TableCellButton> tableCellButtons;
    private final JPanel mineFieldOuterSpaceNorthPanel;
    private final JPanel mineFieldOuterSpaceSouthPanel;
    private final JPanel mineFieldOuterSpaceWestPanel;
    private final JPanel mineFieldOuterSpaceEastPanel;

    public MinesFieldPanelContainerBuilder(MinesFieldAttributes minesFieldAttributes) {

        this.minesFieldAttributes = minesFieldAttributes;
        tableCellButtons = getTableCellButtonsList();
        minesFieldPanel = getMinesFieldPanel();

        OuterSpaceSizePanelCalculation outerSpaceSizePanelCalculation = outerSpaceSizePanelCalculation();
        Dimension horizontalOuterSpaceSize = outerSpaceSizePanelCalculation.getHorizontalPanelSize();
        Dimension verticalOuterSpaceSize = outerSpaceSizePanelCalculation.getVerticalPanelSize();
        MineFieldOuterSpacePanelBuilder mineFieldHorizontalOuterSpacePanelBuilder = mineFieldOuterSpacePanelBuilder(horizontalOuterSpaceSize);
        MineFieldOuterSpacePanelBuilder mineFieldVerticalOuterSpacePanelBuilder = mineFieldOuterSpacePanelBuilder(verticalOuterSpaceSize);
        mineFieldOuterSpaceNorthPanel = mineFieldHorizontalOuterSpacePanelBuilder.build();
        mineFieldOuterSpaceSouthPanel = mineFieldHorizontalOuterSpacePanelBuilder.build();
        mineFieldOuterSpaceWestPanel = mineFieldVerticalOuterSpacePanelBuilder.build();
        mineFieldOuterSpaceEastPanel = mineFieldVerticalOuterSpacePanelBuilder.build();
    }

    @Override
    public MinesFieldPanelContainer build() {

        MinesFieldPanelContainer minesFieldPanelContainer
                = new MinesFieldPanelContainer(
                        minesFieldPanel,
                        mineFieldOuterSpaceNorthPanel,
                        mineFieldOuterSpaceSouthPanel,
                        mineFieldOuterSpaceWestPanel,
                        mineFieldOuterSpaceEastPanel);

        setLayout(minesFieldPanelContainer);
        setPreferredSize(minesFieldPanelContainer);
        addPanels(minesFieldPanelContainer);
        return minesFieldPanelContainer;
    }

    private void setLayout(MinesFieldPanelContainer minesFieldPanelContainer) {
        minesFieldPanelContainer.setLayout(new BorderLayout());
    }

    private void addPanels(MinesFieldPanelContainer minesFieldPanelContainer) {
        minesFieldPanelContainer.add(minesFieldPanel, BorderLayout.CENTER);
        minesFieldPanelContainer.add(mineFieldOuterSpaceNorthPanel, BorderLayout.NORTH);
        minesFieldPanelContainer.add(mineFieldOuterSpaceSouthPanel, BorderLayout.SOUTH);
        minesFieldPanelContainer.add(mineFieldOuterSpaceWestPanel, BorderLayout.WEST);
        minesFieldPanelContainer.add(mineFieldOuterSpaceEastPanel, BorderLayout.EAST);
    }

    private void setPreferredSize(MinesFieldPanelContainer minesFieldPanelContainer) {
        minesFieldPanelContainer.setPreferredSize(calculateMinesFieldContainerSize());
    }

    private Dimension calculateMinesFieldContainerSize() {
        return new Dimension(
                mineFieldOuterSpaceNorthPanel.getPreferredSize().width,
                mineFieldOuterSpaceWestPanel.getPreferredSize().height);
    }

    private MinesFieldPanel getMinesFieldPanel() {
        return getMinesFieldPanelBuilder().build();
    }

    private MinesFieldPanelBuilder getMinesFieldPanelBuilder() {
        return new MinesFieldPanelBuilder(minesFieldAttributes, tableCellButtons);
    }

    private List<TableCellButton> getTableCellButtonsList() {
        return getTableCellButtonListBuilder().build();
    }

    private TableCellButtonListBuilder getTableCellButtonListBuilder() {
        return new TableCellButtonListBuilder(
                getMinesLocationList(),
                minesFieldAttributes);
    }

    private List<Boolean> getMinesLocationList() {
        return getMinesLocationListBuilder().build();
    }

    private MinesLocationListBuilder getMinesLocationListBuilder() {
        return new MinesLocationListBuilder(minesFieldAttributes);
    }

    private MineFieldOuterSpacePanelBuilder mineFieldOuterSpacePanelBuilder(Dimension size) {
        return new MineFieldOuterSpacePanelBuilder(size);
    }

    private OuterSpaceSizePanelCalculation outerSpaceSizePanelCalculation() {
        return new OuterSpaceSizePanelCalculation(minesFieldAttributes);
    }
}
