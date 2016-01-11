package swingversion.builder.tablecellbutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swingversion.control.TableCellButtonCommand;
import swingversion.control.TableCellMouseButton1Command;
import swingversion.control.TableCellMouseButton2Command;
import swingversion.control.TableCellMouseButton3Command;
import swingversion.model.tablecellbutton.TableCellButton;
import yams.control.observer.Observer;

public class TableCellButtonMouseAdapter extends MouseAdapter {

    private final TableCellButton tableCellButton;
    private final List<Observer> observers;

    // TableCellButtonMouseAcionts, ... en lugar de Observers
    public TableCellButtonMouseAdapter(TableCellButton tableCellButton, List<Observer> observers) {
        this.tableCellButton = tableCellButton;
        this.observers = observers;
    }

    public TableCellButton getTableCellButton() {
        return tableCellButton;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Pasar este desde mapa fuera, ...
        Map<Integer, TableCellButtonCommand> tableCellCommands = new HashMap();
        List<Observer> observers = null;
        tableCellCommands.put(MouseEvent.BUTTON1, new TableCellMouseButton1Command(observers));
        tableCellCommands.put(MouseEvent.BUTTON2, new TableCellMouseButton2Command());
        tableCellCommands.put(MouseEvent.BUTTON1, new TableCellMouseButton3Command());

        tableCellCommands.get(e.getButton()).execute(tableCellButton);

    }
}
