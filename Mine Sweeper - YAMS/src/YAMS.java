
import swingversion.builder.mainframe.MainFrameBuilder;
import swingversion.builder.initialconfiguration.MineSweeperInitialConfigurationBuilder;
import swingversion.model.initialconfiguration.MineSweeperInitialConfiguration;

public class YAMS {

    public static void main(String[] args) {
        getMainFrameBuilder().build();
    }

    private static MainFrameBuilder getMainFrameBuilder() {
        return new MainFrameBuilder(getMineSweeperInitialConfiguration());
    }

    private static MineSweeperInitialConfiguration getMineSweeperInitialConfiguration() {
        return getMineSweeperInitialConfigurationBuilder().build();
    }

    private static MineSweeperInitialConfigurationBuilder getMineSweeperInitialConfigurationBuilder() {
        return new MineSweeperInitialConfigurationBuilder();
    }
}
