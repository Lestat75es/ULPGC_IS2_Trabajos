package swingversion.model.minesfield;

import javax.swing.JPanel;

public class MinesFieldPanelContainer extends JPanel {

    private final MinesFieldPanel minesFieldPanel;
    private final JPanel mineFieldOuterSpaceNorthPanel;
    private final JPanel mineFieldOuterSpaceSouthPanel;
    private final JPanel mineFieldOuterSpaceWestPanel;
    private final JPanel mineFieldOuterSpaceEastPanel;

    public MinesFieldPanelContainer(
            MinesFieldPanel minesFieldPanel,
            JPanel mineFieldOuterSpaceNorthPanel,
            JPanel mineFieldOuterSpaceSouthPanel,
            JPanel mineFieldOuterSpaceWestPanel,
            JPanel mineFieldOuterSpaceEastPanel) {
        this.minesFieldPanel = minesFieldPanel;
        this.mineFieldOuterSpaceNorthPanel = mineFieldOuterSpaceNorthPanel;
        this.mineFieldOuterSpaceSouthPanel = mineFieldOuterSpaceSouthPanel;
        this.mineFieldOuterSpaceWestPanel = mineFieldOuterSpaceWestPanel;
        this.mineFieldOuterSpaceEastPanel = mineFieldOuterSpaceEastPanel;
    }

    public MinesFieldPanel getMinesFieldPanel() {
        return minesFieldPanel;
    }

    public JPanel getMineFieldOuterSpaceNorthPanel() {
        return mineFieldOuterSpaceNorthPanel;
    }

    public JPanel getMineFieldOuterSpaceSouthPanel() {
        return mineFieldOuterSpaceSouthPanel;
    }

    public JPanel getMineFieldOuterSpaceWestPanel() {
        return mineFieldOuterSpaceWestPanel;
    }

    public JPanel getMineFieldOuterSpaceEastPanel() {
        return mineFieldOuterSpaceEastPanel;
    }
}
