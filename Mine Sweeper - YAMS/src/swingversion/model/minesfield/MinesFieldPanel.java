package swingversion.model.minesfield;

import java.util.List;
import javax.swing.JPanel;
import swingversion.model.tablecellbutton.TableCellButton;

public class MinesFieldPanel extends JPanel {

    private final List<TableCellButton> tableCellButtons;

    public MinesFieldPanel(List<TableCellButton> tableCellButtons) {
        this.tableCellButtons = tableCellButtons;
    }

    public List<TableCellButton> getTableCellButtons() {
        return tableCellButtons;
    }
}
