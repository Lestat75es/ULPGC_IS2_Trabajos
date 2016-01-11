package swingversion.model.mainframe;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private final JPanel informationPanel;
    private final JPanel minesFieldContainerPanel;

    public MainFrame(JMenuBar jMenuBar, JPanel informationPanel, JPanel minesFieldContainerPanel) {
        this.setJMenuBar(jMenuBar);
        this.informationPanel = informationPanel;
        this.minesFieldContainerPanel = minesFieldContainerPanel;
    }

    public JPanel getInformationPanel() {
        return informationPanel;
    }

    public JPanel getMinesFieldContainerPanel() {
        return minesFieldContainerPanel;
    }
}
