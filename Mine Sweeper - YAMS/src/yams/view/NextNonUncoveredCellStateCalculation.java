package yams.view;

import java.util.Arrays;
import yams.model.TableCellState;
import static yams.model.TableCellState.COVERED_NOMARK;
import static yams.model.TableCellState.COVERED_DOUBTFUL;
import static yams.model.TableCellState.COVERED_FLAGGED;

public class NextNonUncoveredCellStateCalculation {

    private static final TableCellState[] nonUncoveredCellStates = new TableCellState[]{COVERED_NOMARK, COVERED_FLAGGED, COVERED_DOUBTFUL};

    public static TableCellState execute(final TableCellState currentCellState) {
        return nonUncoveredCellStates[nextCellStateIndexOf(currentCellState)];
    }

    private static int nextCellStateIndexOf(final TableCellState currentCellState) {
        return (currentIndexOf(currentCellState) + 1) % nonUncoveredCellStates.length;
    }

    private static int currentIndexOf(final TableCellState currentCellState) {
        return Arrays.asList(nonUncoveredCellStates).indexOf(currentCellState);
    }
}
