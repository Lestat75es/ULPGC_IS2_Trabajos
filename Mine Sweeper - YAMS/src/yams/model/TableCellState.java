package yams.model;

public class TableCellState {

    public final static TableCellState UNCOVERED_SAFE = new TableCellState(0);
    public final static TableCellState UNCOVERED_DETONATED = new TableCellState(1);
    public final static TableCellState COVERED_NOMARK = new TableCellState(2);
    public final static TableCellState COVERED_FLAGGED = new TableCellState(3);
    public final static TableCellState COVERED_DOUBTFUL = new TableCellState(4);

    private final int stateValue;

    public TableCellState(int stateValue) {
        this.stateValue = stateValue;
    }

    public int getStateValue() {
        return stateValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.stateValue;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TableCellState other = (TableCellState) obj;
        return this.stateValue == other.stateValue;
    }
}
