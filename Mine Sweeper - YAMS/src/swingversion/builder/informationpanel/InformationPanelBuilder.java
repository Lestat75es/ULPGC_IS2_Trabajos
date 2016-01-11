package swingversion.builder.informationpanel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import swingversion.builder.Builder;
import swingversion.model.informationpanel.InformationPanel;

public class InformationPanelBuilder implements Builder {

    public InformationPanelBuilder() {
    }

    @Override
    public InformationPanel build() {
        InformationPanel informationPanel = new InformationPanel();
        informationPanel.setLayout(new FlowLayout());
        informationPanel.add(new JButton());
        return informationPanel;
    }
}
