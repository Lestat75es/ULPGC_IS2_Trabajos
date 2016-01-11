package swingversion.builder.tablecellbutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import swingversion.builder.Builder;
import swingversion.builder.mine.MineBuilder;
import swingversion.control.TableCellButtonCommand;
import swingversion.control.TableCellMouseButton1Command;
import swingversion.control.TableCellMouseButton2Command;
import swingversion.control.TableCellMouseButton3Command;
import swingversion.model.tablecellbutton.TableCellButton;
import yams.control.observer.Observer;
import yams.model.Cell;
import yams.model.Mine;
import yams.model.TableCellState;

public class TableCellButtonBuilder implements Builder {

    private final TableCellState tableCellState;
    private final Boolean hasMine;
    private final List<Cell> neigbours;
    private final int cellSideLength;

    public TableCellButtonBuilder(TableCellState tableCellState, Boolean hasMine, List<Cell> neigbours, int cellSideLength) {
        this.tableCellState = tableCellState;
        this.hasMine = hasMine;
        this.neigbours = neigbours;
        this.cellSideLength = cellSideLength;
    }

    @Override
    public TableCellButton build() {
        TableCellButton tableCellButton = new TableCellButton(
                tableCellState,
                getMine(),
                neigbours,
                cellSideLength);
        addMouseListeners(tableCellButton);
        return tableCellButton;
    }

    private void addMouseListeners(TableCellButton tableCellButton) {

        List<Observer> observers = null;
        new TableCellButtonMouseAdapter(tableCellButton, observers);
        tableCellButton.addMouseListener(new MouseAdapter() {
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
        });
    }

    private Mine getMine() {
        return hasMine ? getMineBuilder().build() : null;
    }

    private MineBuilder getMineBuilder() {
        return new MineBuilder();
    }
}
