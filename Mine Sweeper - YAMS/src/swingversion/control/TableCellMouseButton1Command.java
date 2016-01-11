package swingversion.control;

import java.util.List;
import swingversion.model.tablecellbutton.TableCellButton;
import yams.control.command.TryToUncoverTableCell;
import yams.control.observer.Observer;

public class TableCellMouseButton1Command implements TableCellButtonCommand {

    private final List<Observer> observers;

    public TableCellMouseButton1Command(List<Observer> observers) {
        this.observers = observers;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void execute(TableCellButton tableCellButton) {

        getTryToUncoverTableCell(tableCellButton).execute();
    }

    private TryToUncoverTableCell getTryToUncoverTableCell(TableCellButton tableCellButton) {
        return new TryToUncoverTableCell(() -> tableCellButton, observers);
    }
}
