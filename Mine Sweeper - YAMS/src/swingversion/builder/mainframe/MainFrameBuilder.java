package swingversion.builder.mainframe;

import swingversion.builder.informationpanel.InformationPanelBuilder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import swingversion.builder.Builder;
import swingversion.builder.menu.JMenuBarBuilder;
import swingversion.builder.minesfield.MinesFieldPanelContainerBuilder;
import swingversion.builder.menu.MenuItemParametersListBuilder;
import swingversion.model.informationpanel.InformationPanel;
import swingversion.model.initialconfiguration.MineSweeperInitialConfiguration;
import swingversion.model.mainframe.MainFrame;
import swingversion.model.minesfield.MinesFieldAttributes;
import swingversion.model.minesfield.MinesFieldPanelContainer;

public class MainFrameBuilder implements Builder {

    private final MineSweeperInitialConfiguration mineSweeperInitialConfiguration;

    public MainFrameBuilder(MineSweeperInitialConfiguration mineSweeperInitialConfiguration) {
        this.mineSweeperInitialConfiguration = mineSweeperInitialConfiguration;
    }

    @Override
    public MainFrame build() {
        JMenuBar jMenuBar = jMenuBar();
        JPanel informationPanel = informationPanel();
        JPanel minesFieldContainerPanel = minesFieldPanelContainer();

        MainFrame mainFrame = new MainFrame(jMenuBar, informationPanel, minesFieldContainerPanel);
        deployUI(mainFrame);
        return mainFrame;
    }

    private void deployUI(MainFrame mainFrame) {
        setGeneralAttributes(mainFrame);
        setContent(mainFrame);
        mainFrame.pack();
    }

    private void setGeneralAttributes(MainFrame mainFrame) {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle(getTitle());
        mainFrame.setLocationByPlatform(true);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private void setContent(MainFrame mainFrame) {
        mainFrame.getContentPane().add(mainFrame.getInformationPanel(), BorderLayout.NORTH);
        mainFrame.getContentPane().add(mainFrame.getMinesFieldContainerPanel(), BorderLayout.CENTER);
    }

    private String getTitle() {
        return mineSweeperInitialConfiguration.getTitle();
    }

    private JMenuBar jMenuBar() {
        return getJMenuBarBuilder().build();
    }

    private JMenuBarBuilder getJMenuBarBuilder() {
        return new JMenuBarBuilder(getMenuItemParametersListBuilder().build());
    }

    private MenuItemParametersListBuilder getMenuItemParametersListBuilder() {
        return new MenuItemParametersListBuilder();
    }

    private InformationPanel informationPanel() {
        return getInformationPanelBuilder().build();
    }

    private InformationPanelBuilder getInformationPanelBuilder() {
        return new InformationPanelBuilder();
    }

    private MinesFieldPanelContainer minesFieldPanelContainer() {

        return getMinesFieldPanelContainerBuilder().build();
    }

    private MinesFieldPanelContainerBuilder getMinesFieldPanelContainerBuilder() {
        return new MinesFieldPanelContainerBuilder(getMinesfieldAttributes());
    }

    private MinesFieldAttributes getMinesfieldAttributes() {
        return new MinesFieldAttributes(
                mineSweeperInitialConfiguration.getRows(),
                mineSweeperInitialConfiguration.getColumns(),
                mineSweeperInitialConfiguration.getCellSideLength(),
                mineSweeperInitialConfiguration.getNumberOfMines());
    }

}
