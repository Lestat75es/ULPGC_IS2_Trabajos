package yams.view;

import java.util.stream.Stream;
import yams.model.Cell;
import yams.model.TableCell;

public class NeighboursMinesNumberCalculation {

    public static int execute(final TableCell tableCell) {
        return getNumberOfMinesOf(tableCell.neigbours().stream());
    }

    private static int getNumberOfMinesOf(final Stream<Cell> streamOfneighbours) {
        return streamOfNumberOfMines(streamOfneighbours).reduce(0, (a, b) -> a + b);
    }

    private static Stream<Integer> streamOfNumberOfMines(Stream<Cell> streamOfneighbours) {
        return streamOfneighbours.map(cell -> getNumberOfMinesOf((TableCell) cell));
    }

    private static int getNumberOfMinesOf(TableCell tableCell) {
        return tableCell.hasMine() ? 1 : 0;
    }
}
