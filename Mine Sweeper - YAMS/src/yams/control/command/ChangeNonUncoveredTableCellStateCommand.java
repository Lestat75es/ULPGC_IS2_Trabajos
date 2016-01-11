package yams.control.command;

import java.util.ArrayList;
import java.util.List;
import yams.control.observer.Observer;
import yams.model.TableCell;
import yams.model.TableCellState;
import yams.view.NextNonUncoveredCellStateCalculation;
import yams.view.TableCellDialog;

public class ChangeNonUncoveredTableCellStateCommand implements CommandWithObservers {

    private final TableCellDialog tableCellDialog;
    private final List<Observer> observers;

    public ChangeNonUncoveredTableCellStateCommand(TableCellDialog tableCellDialog) {
        this.observers = new ArrayList<>();
        this.tableCellDialog = tableCellDialog;
    }

    @Override
    public void execute() {
        getTableCell().setState(getNextTableCellState());
        observers.stream().forEach(observer -> observer.execute(tableCellDialog));
    }

    @Override
    public List<Observer> observers() {
        return observers;
    }

    private TableCellState getNextTableCellState() {
        return NextNonUncoveredCellStateCalculation.execute(getTableCellState());
    }

    private TableCellState getTableCellState() {
        return getTableCell().getState();
    }

    private TableCell getTableCell() {
        return tableCellDialog.tableCell();
    }
}
