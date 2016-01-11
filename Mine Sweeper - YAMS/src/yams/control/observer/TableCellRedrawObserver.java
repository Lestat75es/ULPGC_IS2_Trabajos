package yams.control.observer;

import yams.view.TableCellDrawMethod;
import java.util.Map;
import yams.model.TableCell;
import yams.model.TableCellState;
import yams.view.TableCellDialog;

public class TableCellRedrawObserver implements Observer {

    private final Map<TableCellState, TableCellDrawMethod> tableCellStateDrawMap;

    public TableCellRedrawObserver(Map<TableCellState, TableCellDrawMethod> tableCellStateDrawMap) {
        this.tableCellStateDrawMap = tableCellStateDrawMap;
    }

    public Map<TableCellState, TableCellDrawMethod> getTableCellStateDrawMap() {
        return tableCellStateDrawMap;
    }

    @Override
    public void execute(TableCellDialog tableCellDialog) {
        TableCell tableCell = getTableCell(tableCellDialog);
        getTableCellDrawMethodOf(getStateOf(tableCell)).draw(tableCell);
    }

    private TableCell getTableCell(TableCellDialog tableCellDialog) {
        return tableCellDialog.tableCell();
    }

    private TableCellDrawMethod getTableCellDrawMethodOf(TableCellState tableCellState) {
        return tableCellStateDrawMap.get(tableCellState);
    }

    private TableCellState getStateOf(TableCell tableCell) {
        return tableCell.getState();
    }
}
