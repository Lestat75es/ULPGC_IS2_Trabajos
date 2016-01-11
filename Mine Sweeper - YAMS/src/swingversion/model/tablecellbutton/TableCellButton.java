package swingversion.model.tablecellbutton;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import yams.model.Cell;
import yams.model.Mine;
import yams.model.TableCell;
import yams.model.TableCellState;

public class TableCellButton extends JButton implements TableCell {

    private TableCellState state;
    private final Mine mine;
    private final List<Cell> neigbours;

    public TableCellButton(TableCellState state, Mine mine, List<Cell> neigbours, int cellSideLength) {
        this.state = state;
        this.mine = mine;
        this.neigbours = neigbours;
        buildTableCellButton(cellSideLength);
    }

    @Override
    public TableCellState getState() {
        return state;
    }

    @Override
    public void setState(TableCellState state) {
        this.state = state;
    }

    @Override
    public Mine mine() {
        return mine;
    }

    @Override
    public boolean hasMine() {
        return mine != null;
    }

    @Override
    public List<Cell> neigbours() {
        return neigbours;
    }

    private void buildTableCellButton(int cellSideLength) {
        setPreferredSize(new Dimension(cellSideLength, cellSideLength));
    }
}
