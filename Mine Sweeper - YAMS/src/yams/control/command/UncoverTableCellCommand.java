package yams.control.command;

import java.util.List;
import yams.control.observer.Observer;
import static yams.model.TableCellState.UNCOVERED_SAFE;
import yams.view.TableCellDialog;

public class UncoverTableCellCommand implements CommandWithObservers {

    private final TableCellDialog tableCellDialog;
    private final List<Observer> observers;

    public UncoverTableCellCommand(TableCellDialog tableCellDialog, List<Observer> observers) {
        this.tableCellDialog = tableCellDialog;
        this.observers = observers;
    }

    @Override
    public List<Observer> observers() {
        return observers;
    }

    @Override
    public void execute() {
        tableCellDialog.tableCell().setState(UNCOVERED_SAFE);
        observers.stream().forEach(observer -> observer.execute(tableCellDialog));
    }
}
