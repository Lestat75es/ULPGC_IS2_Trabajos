package swingversion.builder.tablecellbutton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import swingversion.builder.Builder;
import swingversion.model.minesfield.MinesFieldAttributes;

public class MinesLocationListBuilder implements Builder {

    private final MinesFieldAttributes minesFieldAttributes;
    private final Boolean[] minesLocationArray;

    public MinesLocationListBuilder(MinesFieldAttributes minesFieldAttributes) {
        this.minesFieldAttributes = minesFieldAttributes;
        this.minesLocationArray = new Boolean[getNumberOfTableCellButtons()];
    }

    @Override
    public List<Boolean> build() {
        return getRandomMinesLocationList();
    }

    private List<Boolean> getRandomMinesLocationList() {
        initializeMinesLocationArray();
        List<Boolean> minesLocationList = new ArrayList<>(Arrays.asList(minesLocationArray));
        Collections.shuffle(minesLocationList);
        return minesLocationList;
    }

    private void initializeMinesLocationArray() {
        Arrays.fill(minesLocationArray, 0, getNumberOfMines(), true);
        Arrays.fill(minesLocationArray, getNumberOfMines(), getNumberOfTableCellButtons(), false);
    }

    private int getColumns() {
        return minesFieldAttributes.getColumns();
    }

    private int getRows() {
        return minesFieldAttributes.getRows();
    }

    private int getNumberOfMines() {
        return minesFieldAttributes.getNumberOfMines();
    }

    private int getNumberOfTableCellButtons() {
        return getRows() * getColumns();
    }
}
