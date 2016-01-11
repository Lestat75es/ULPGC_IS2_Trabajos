package yams.control.command;

import java.util.List;
import yams.control.observer.Observer;
import yams.model.Cell;
import yams.model.TableCell;
import yams.view.TableCellDialog;

public class UncoverTableCellNeighboursCommand implements CommandWithObservers {

    private final TableCellDialog tableCellDialog;
    private final List<Observer> observers;

    public UncoverTableCellNeighboursCommand(List<Observer> observers, TableCellDialog tableCellDialog) {
        this.observers = observers;
        this.tableCellDialog = tableCellDialog;
    }

    @Override
    public List<Observer> observers() {
        return observers;
    }

    @Override
    public void execute() {
        getNeighbours().stream().forEach(neighbour -> uncoverNeighbour(neighbour));
    }

    private List<Cell> getNeighbours() {
        return tableCellDialog.tableCell().neigbours();
    }

    private void uncoverNeighbour(Cell neighbour) {
        UncoverTableCellCommand command = new UncoverTableCellCommand(() -> (TableCell) neighbour, observers);
        command.execute();
    }
}
