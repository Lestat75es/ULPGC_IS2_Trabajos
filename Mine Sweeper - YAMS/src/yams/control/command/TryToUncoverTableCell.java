package yams.control.command;

import yams.control.command.builder.TryToUncoverTableCellActionsMapBuilder;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import yams.control.observer.Observer;
import yams.model.TableCellState;
import yams.view.TableCellDialog;

public class TryToUncoverTableCell implements CommandWithObservers {

    private final TableCellDialog tableCellDialog;
    private final List<Observer> observers;
    private final Map<TableCellState, CommandWithObservers> actionsMap;

    public TryToUncoverTableCell(TableCellDialog tableCellDialog, List<Observer> observers) {
        this.tableCellDialog = tableCellDialog;
        this.observers = observers;
        this.actionsMap = getTryToUncoverTableCellActionsMapBuilder().execute();
    }

    public TableCellDialog getTableCellDialog() {
        return tableCellDialog;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public Map<TableCellState, CommandWithObservers> getTableCellStateCommandMap() {
        return actionsMap;
    }

    @Override
    public void execute() {
        getValidTableCellStates().forEach(state -> actionsMap.get(state).execute());

    }

    private Stream<TableCellState> getValidTableCellStates() {
        return getTableCellStates().filter(state -> getTableCellState().equals(state));
    }

    private Stream<TableCellState> getTableCellStates() {
        return actionsMap.keySet().stream();
    }

    private TableCellState getTableCellState() {
        return tableCellDialog.tableCell().getState();
    }

    @Override
    public List<Observer> observers() {
        return observers;
    }

    private TryToUncoverTableCellActionsMapBuilder getTryToUncoverTableCellActionsMapBuilder() {
        return new TryToUncoverTableCellActionsMapBuilder(tableCellDialog, observers);
    }
}
