package yams.control.command.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yams.control.command.CommandWithObservers;
import yams.control.command.UncoverTableCellCommand;
import yams.control.observer.Observer;
import yams.model.TableCellState;
import yams.view.TableCellDialog;

public class TryToUncoverTableCellActionsMapBuilder {

    private final TableCellDialog tableCellDialog;
    private final List<Observer> observers;

    public TryToUncoverTableCellActionsMapBuilder(TableCellDialog tableCellDialog, List<Observer> observers) {
        this.tableCellDialog = tableCellDialog;
        this.observers = observers;
    }

    public Map<TableCellState, CommandWithObservers> execute() {
        Map<TableCellState, CommandWithObservers> actions = new HashMap<>();
        UncoverTableCellCommand uncoverTableCellCommand = new UncoverTableCellCommand(tableCellDialog, observers);
        actions.put(TableCellState.COVERED_NOMARK, uncoverTableCellCommand);
        actions.put(TableCellState.COVERED_DOUBTFUL, uncoverTableCellCommand);
        return actions;
    }
}
