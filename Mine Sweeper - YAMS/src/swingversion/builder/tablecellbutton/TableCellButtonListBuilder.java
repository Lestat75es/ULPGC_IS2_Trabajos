package swingversion.builder.tablecellbutton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import swingversion.builder.Builder;
import swingversion.model.minesfield.MinesFieldAttributes;
import swingversion.model.tablecellbutton.TableCellButton;
import yams.model.TableCellState;

public class TableCellButtonListBuilder implements Builder {

    private final List<Boolean> minesLocationList;
    private final MinesFieldAttributes minesFieldAttributes;

    public TableCellButtonListBuilder(List<Boolean> minesLocationList, MinesFieldAttributes minesFieldAttributes) {
        this.minesLocationList = minesLocationList;
        this.minesFieldAttributes = minesFieldAttributes;
    }

    @Override
    public List<TableCellButton> build() {
        List<TableCellButton> tableCellButtons = buildTableCellButtons();
        setNeighboursTo(tableCellButtons);
        return tableCellButtons;
    }

    private void setNeighboursTo(List<TableCellButton> tableCellButtons) {
        NeighboursListBuilder neighboursListBuilder = getNeighboursListBuilder(tableCellButtons);
        getMinesLocationListIndexes().forEachOrdered(index -> {
            tableCellButtons.get(index).neigbours().
                    addAll(neighboursListBuilder.execute(index));
        });
    }

    private IntStream getMinesLocationListIndexes() {
        return IntStream.range(0, minesLocationList.size());
    }

    private NeighboursListBuilder getNeighboursListBuilder(List<TableCellButton> tableCellButtons) {
        return new NeighboursListBuilder(tableCellButtons, minesFieldAttributes);
    }

    private List<TableCellButton> buildTableCellButtons() {
        List<TableCellButton> tableCellButtons = new ArrayList<>();
        minesLocationList.stream().forEachOrdered(hasMine -> tableCellButtons.add(buildTableCellButton(hasMine)));
        return tableCellButtons;
    }

    private TableCellButton buildTableCellButton(Boolean hasMine) {
        return getTableCellButtonBuilder(hasMine).build();
    }

    private TableCellButtonBuilder getTableCellButtonBuilder(Boolean hasMine) {
        return new TableCellButtonBuilder(
                TableCellState.COVERED_NOMARK,
                hasMine,
                new ArrayList<>(),
                minesFieldAttributes.getCellSideLength());
    }
}
