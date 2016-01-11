package swingversion.builder.tablecellbutton;

import swingversion.builder.calculation.LocationCalculation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import swingversion.model.minesfield.MinesFieldAttributes;
import swingversion.model.position.Position;
import static swingversion.model.position.Position.EAST_OFFEST;
import static swingversion.model.position.Position.NORTHEAST_OFFEST;
import static swingversion.model.position.Position.NORTHWEST_OFFEST;
import static swingversion.model.position.Position.NORTH_OFFEST;
import static swingversion.model.position.Position.SOUTHEAST_OFFEST;
import static swingversion.model.position.Position.SOUTHWEST_OFFEST;
import static swingversion.model.position.Position.SOUTH_OFFEST;
import static swingversion.model.position.Position.WEST_OFFEST;
import swingversion.model.tablecellbutton.TableCellButton;

public class NeighboursListBuilder {

    private final List<TableCellButton> tableCellButtons;
    private final MinesFieldAttributes minesFieldAttributes;

    private static final List<Position> neighbourOffsets
            = Arrays.asList(new Position[]{
                NORTHWEST_OFFEST, NORTH_OFFEST, NORTHEAST_OFFEST,
                WEST_OFFEST, EAST_OFFEST,
                SOUTHWEST_OFFEST, SOUTH_OFFEST, SOUTHEAST_OFFEST});

    public NeighboursListBuilder(List<TableCellButton> tableCellButtons, MinesFieldAttributes minesFieldAttributes) {
        this.tableCellButtons = tableCellButtons;
        this.minesFieldAttributes = minesFieldAttributes;
    }

    List<TableCellButton> execute(int tableCellIndex) {
        ArrayList<TableCellButton> neighbours = new ArrayList<>();
        Position position = indexToPosition(tableCellIndex);
        neighbourOffsets.stream().
                map(neighbourOffset -> getNeighbourPosition(position, neighbourOffset)).
                filter(neighbourPosition -> isValid(neighbourPosition)).
                forEach(neighbourPosition -> addNeighbour(neighbours, neighbourPosition));
        return neighbours;
    }

    private Position getNeighbourPosition(Position position, Position offset) {
        return LocationCalculation.relativePosition(position, offset);
    }

    private void addNeighbour(ArrayList<TableCellButton> neighbours, Position position) {
        neighbours.add(tableCellButtons.get(positionToIndex(position)));
    }

    private Position indexToPosition(int tableCellIndex) {
        return LocationCalculation.indexToPosition(
                tableCellIndex,
                minesFieldAttributes.getColumns());
    }

    private boolean isValid(Position neighbourPosition) {
        return LocationCalculation.isValidPosition(
                neighbourPosition,
                minesFieldAttributes.getRows(),
                minesFieldAttributes.getColumns());
    }

    private int positionToIndex(Position position) {
        return LocationCalculation.positionToIndex(
                position,
                minesFieldAttributes.getRows(),
                minesFieldAttributes.getColumns());
    }
}
