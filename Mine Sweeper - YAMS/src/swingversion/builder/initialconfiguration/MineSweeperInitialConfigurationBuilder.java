package swingversion.builder.initialconfiguration;

import java.awt.Color;
import swingversion.builder.Builder;
import swingversion.model.initialconfiguration.MineSweeperInitialConfiguration;

public class MineSweeperInitialConfigurationBuilder implements Builder {

    private static final String title = "YAMS (Yet Another Mine Sweeper)";
    private static final int rows = 10;
    private static final int columns = 20;
    private static final int cellSideLength = 20;
    private static final int numberOfMines = rows * columns / 10;
    private static final Color mineFieldOuterSpaceColor = Color.BLUE;

    @Override
    public MineSweeperInitialConfiguration build() {
        return new MineSweeperInitialConfiguration(
                title,
                rows,
                columns,
                cellSideLength,
                numberOfMines,
                mineFieldOuterSpaceColor);
    }
}
