package swingversion.model.menu.menuattributes;

import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.KeyStroke;

public class MenuItemAttributes implements GenericMenuItemAttributes {

    private final String text;
    private final char mnemonic;
    private final String toolTipText;
    private final KeyStroke keyStroke;
    private final Icon icon;
    private final ActionListener actionListener;

    public MenuItemAttributes(String text, char mnemonic, String toolTipText, KeyStroke keyStroke, Icon icon, ActionListener actionListener) {
        this.text = text;
        this.mnemonic = mnemonic;
        this.toolTipText = toolTipText;
        this.keyStroke = keyStroke;
        this.icon = icon;
        this.actionListener = actionListener;
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

    public KeyStroke getKeyStroke() {
        return keyStroke;
    }

    public Icon getIcon() {
        return icon;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }
}
