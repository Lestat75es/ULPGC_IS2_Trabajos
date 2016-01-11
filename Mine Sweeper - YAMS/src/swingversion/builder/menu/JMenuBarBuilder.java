package swingversion.builder.menu;

import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import swingversion.builder.Builder;
import swingversion.model.menu.creationinterface.GenericMenuItemCreationInterface;
import swingversion.model.menu.menuattributes.GenericMenuItemAttributes;
import swingversion.model.menu.menuparameters.GenericMenuItemParameters;

public class JMenuBarBuilder implements Builder {

    private final List<GenericMenuItemParameters> menuItemParametersList;

    public JMenuBarBuilder(List<GenericMenuItemParameters> menuItemParametersList) {
        this.menuItemParametersList = menuItemParametersList;
    }

    @Override
    public JMenuBar build() {
        JMenuBar jMenuBar = new JMenuBar();
        menuItemParametersList.stream().
                forEachOrdered(menuItemParameters -> {
                    addItemToMenuBar(jMenuBar, menuItemParameters);
                });
        return jMenuBar;
    }

    private void addItemToMenuBar(JMenuBar jMenuBar, GenericMenuItemParameters menuItemParameters) {
        GenericMenuItemCreationInterface itemCreationClass = menuItemParameters.getItemCreationClass();
        GenericMenuItemAttributes itemAttributes = menuItemParameters.getItemAttributes();
        jMenuBar.add((JMenu) itemCreationClass.execute(itemAttributes));
    }
}
