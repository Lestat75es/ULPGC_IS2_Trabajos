package swingversion.builder.menu;

import java.awt.Component;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import swingversion.builder.Builder;
import swingversion.model.menu.creationinterface.GenericMenuItemCreationInterface;
import swingversion.model.menu.menuattributes.GenericMenuItemAttributes;
import swingversion.model.menu.menuattributes.MenuAttributes;
import swingversion.model.menu.menuattributes.MenuItemAttributes;
import swingversion.model.menu.menuitems.GenericMenuItem;
import swingversion.model.menu.menuitems.Menu;
import swingversion.model.menu.menuitems.MenuItem;
import swingversion.model.menu.menuitems.MenuSeparator;
import swingversion.model.menu.menuparameters.GenericMenuItemParameters;

public class MenuItemParametersListBuilder implements Builder {

    public MenuItemParametersListBuilder() {
    }

    @Override
    public List<GenericMenuItemParameters> build() {
        GenericMenuItemParametersBuilder menuOptionsParametersBuilder
                = new GenericMenuItemParametersBuilder(
                        new GenericMenuItemCreationInterface() {

                            @Override
                            public GenericMenuItem execute(GenericMenuItemAttributes itemAttributes) {
                                Menu menuElement = new Menu();
                                setParameters(menuElement, (MenuAttributes) itemAttributes);
                                setSubMenuItems(menuElement, ((MenuAttributes) itemAttributes).getSubItemsParameters());
                                return menuElement;
                            }

                            private void setParameters(JMenu menuElement, MenuAttributes itemAttributes) {
                                menuElement.setText(itemAttributes.getText());
                                menuElement.setMnemonic(itemAttributes.getMnemonic());
                                menuElement.setToolTipText(itemAttributes.getToolTipText());
                                menuElement.setIcon(itemAttributes.getIcon());
                            }

                            private void setSubMenuItems(Menu menuElement, List<GenericMenuItemParameters> subItemsParameters) {
                                // Falla para Elementos Menu, .... corregir si hay tiempo, aunque no hace falta, ya que no se da el error
                                // porque niguna subopción tiene supopciones
                                subItemsParameters.stream().forEachOrdered(subMenuItemParameters
                                        -> menuElement.add(
                                                (Component) subMenuItemParameters.getItemCreationClass().execute(
                                                        subMenuItemParameters.getItemAttributes()))
                                );
                            }
                        },
                        new GenericMenuItemCreationInterface() {

                            @Override
                            public GenericMenuItem execute(GenericMenuItemAttributes itemAttributes) {
                                MenuItem menuElement = new MenuItem();
                                setParameters(menuElement, (MenuItemAttributes) itemAttributes);
                                return menuElement;
                            }

                            private void setParameters(JMenuItem menuElement, MenuItemAttributes itemAttributes) {
                                menuElement.setText(itemAttributes.getText());
                                menuElement.setMnemonic(itemAttributes.getMnemonic());
                                menuElement.setToolTipText(itemAttributes.getToolTipText());
                                menuElement.setAccelerator(itemAttributes.getKeyStroke());
                                menuElement.setIcon(itemAttributes.getIcon());
                                menuElement.addActionListener(itemAttributes.getActionListener());
                            }
                        }, (GenericMenuItemAttributes itemAttributes) -> {
                            MenuSeparator menuElement = new MenuSeparator();
                            return menuElement;
                        });
        return menuOptionsParametersBuilder.build();
    }
}
