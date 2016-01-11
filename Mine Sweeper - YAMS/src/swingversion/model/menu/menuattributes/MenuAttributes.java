package swingversion.model.menu.menuattributes;

import java.util.List;
import javax.swing.Icon;
import swingversion.model.menu.menuparameters.GenericMenuItemParameters;

public class MenuAttributes implements GenericMenuItemAttributes {

    private final String text;
    private final char mnemonic;
    private final String toolTipText;
    private final Icon icon;
    private final List<GenericMenuItemParameters> subItemsParameters;

    public MenuAttributes(String text, char mnemonic, String toolTipText, Icon icon, List<GenericMenuItemParameters> subItemsParameters) {
        this.text = text;
        this.mnemonic = mnemonic;
        this.toolTipText = toolTipText;
        this.icon = icon;
        this.subItemsParameters = subItemsParameters;
    }

    public String getText() {
        return text;
    }

    public char getMnemonic() {
        return mnemonic;
    }

    public String getToolTipText() {
        return toolTipText;
    }

    public Icon getIcon() {
        return icon;
    }

    public List<GenericMenuItemParameters> getSubItemsParameters() {
        return subItemsParameters;
    }
}
