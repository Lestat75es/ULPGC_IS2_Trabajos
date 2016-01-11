package swingversion.model.menu.menuparameters;

import swingversion.model.menu.menuattributes.GenericMenuItemAttributes;
import swingversion.model.menu.creationinterface.GenericMenuItemCreationInterface;

public class GenericMenuItemParameters {

    private final GenericMenuItemCreationInterface itemCreationClass;
    private final GenericMenuItemAttributes itemAttributes;

    public GenericMenuItemParameters(GenericMenuItemCreationInterface itemCreationClass, GenericMenuItemAttributes itemAttributes) {
        this.itemCreationClass = itemCreationClass;
        this.itemAttributes = itemAttributes;
    }

    public GenericMenuItemCreationInterface getItemCreationClass() {
        return itemCreationClass;
    }

    public GenericMenuItemAttributes getItemAttributes() {
        return itemAttributes;
    }
}
