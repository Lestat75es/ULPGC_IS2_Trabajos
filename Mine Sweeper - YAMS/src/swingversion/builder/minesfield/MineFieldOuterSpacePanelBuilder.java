package swingversion.builder.minesfield;

import java.awt.Dimension;
import javax.swing.JPanel;
import swingversion.builder.Builder;

public class MineFieldOuterSpacePanelBuilder implements Builder {

    private final Dimension size;

    public MineFieldOuterSpacePanelBuilder(Dimension size) {
        this.size = size;
    }

    @Override
    public JPanel build() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(size);
        return panel;
    }
}
