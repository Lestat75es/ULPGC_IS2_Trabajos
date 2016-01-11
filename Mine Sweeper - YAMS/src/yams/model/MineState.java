package yams.model;

public class MineState {

    public final static MineState INTACT = new MineState(0);
    public final static MineState DETONATED = new MineState(1);

    private final int stateValue;

    public MineState(int stateValue) {
        this.stateValue = stateValue;
    }

    public int getStateValue() {
        return stateValue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.stateValue;
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
        final MineState other = (MineState) obj;
        return this.stateValue == other.stateValue;
    }
}
