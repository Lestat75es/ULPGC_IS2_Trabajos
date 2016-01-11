package swingversion.builder.mine;

import swingversion.builder.Builder;
import yams.model.Mine;
import yams.model.MineState;

public class MineBuilder implements Builder {

    public MineBuilder() {
    }

    @Override
    public Mine build() {
        return new Mine() {

            private MineState state = MineState.INTACT;

            @Override
            public MineState state() {
                return state;
            }
        };
    }
}
