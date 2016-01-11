package swingversion.builder.menu;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.KeyStroke;
import swingversion.builder.Builder;
import swingversion.model.menu.menuattributes.MenuAttributes;
import swingversion.model.menu.menuattributes.MenuItemAttributes;
import swingversion.model.menu.menuattributes.MenuSeparatorAttributes;
import swingversion.model.menu.menuparameters.GenericMenuItemParameters;
import swingversion.model.menu.creationinterface.GenericMenuItemCreationInterface;

public class GenericMenuItemParametersBuilder implements Builder {

    private final GenericMenuItemCreationInterface menuBuilder;
    private final GenericMenuItemCreationInterface menuItemBuilder;
    private final GenericMenuItemCreationInterface menuSeparatorBuilder;

    public GenericMenuItemParametersBuilder(GenericMenuItemCreationInterface menuBuilder, GenericMenuItemCreationInterface menuItemBuilder, GenericMenuItemCreationInterface menuSeparatorBuilder) {
        this.menuBuilder = menuBuilder;
        this.menuItemBuilder = menuItemBuilder;
        this.menuSeparatorBuilder = menuSeparatorBuilder;
    }

    @Override
    public List<GenericMenuItemParameters> build() {
        List<GenericMenuItemParameters> menuItems = new ArrayList<>();
        menuItems.add(gameGenericItemParameters());
        menuItems.add(helpGenericItemParameters());
        return menuItems;
    }

    private GenericMenuItemParameters gameGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuBuilder,
                new MenuAttributes(
                        "Game",
                        'G',
                        null,
                        null,
                        gameMenuSubItems()));
    }

    private GenericMenuItemParameters helpGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuBuilder,
                new MenuAttributes(
                        "Help",
                        'H',
                        null,
                        null,
                        helpMenuSubItems()));
    }

    private List<GenericMenuItemParameters> gameMenuSubItems() {
        List<GenericMenuItemParameters> subItem = new ArrayList<>();
        subItem.add(newGameGenericItemParameters());
        subItem.add(preferencesGenericItemParameters());
        subItem.add(menuSeparatorParameters());
        subItem.add(exitGenericItemParameters());
        return subItem;
    }

    private GenericMenuItemParameters newGameGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuItemBuilder,
                new MenuItemAttributes(
                        "New Game",
                        'N',
                        "Start a new game",
                        KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0),
                        null, // Falta Icon
                        null)); // Falta Action
    }

    private GenericMenuItemParameters preferencesGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuItemBuilder,
                new MenuItemAttributes(
                        "Preferences",
                        'P',
                        "Setup configuration options of the game",
                        KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0),
                        null, // Falta Icon
                        null)); // Falta Action
    }

    private GenericMenuItemParameters menuSeparatorParameters() {
        return new GenericMenuItemParameters(
                menuSeparatorBuilder,
                new MenuSeparatorAttributes());
    }

    private GenericMenuItemParameters exitGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuItemBuilder,
                new MenuItemAttributes(
                        "Exit",
                        'x',
                        "Exit from Mine Sweeper",
                        KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK),
                        null, // Falta Icon
                        (ActionEvent ae) -> {
                            System.exit(0);
                        }));
    }

    private List<GenericMenuItemParameters> helpMenuSubItems() {
        List<GenericMenuItemParameters> subItem = new ArrayList<>();
        subItem.add(aboutGenericItemParameters());
        subItem.add(topTenGenericItemParameters());
        return subItem;
    }

    private GenericMenuItemParameters aboutGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuItemBuilder,
                new MenuItemAttributes(
                        "About",
                        'A',
                        "Information about the Mine Sweeper",
                        null,
                        null,
                        null)); // Falta Action
    }

    private GenericMenuItemParameters topTenGenericItemParameters() {
        return new GenericMenuItemParameters(
                menuItemBuilder,
                new MenuItemAttributes(
                        "Top 10 Players",
                        'T',
                        "Show the 10 best players",
                        null,
                        null,
                        null)); // Falta Action
    }
}
