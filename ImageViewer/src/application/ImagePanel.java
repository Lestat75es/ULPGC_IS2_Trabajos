package application;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageDisplay {

    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Rectangle bounds = getBounds();
        g.clearRect(bounds.x, bounds.y, bounds.width, bounds.height);
        g.drawImage((BufferedImage) image.bitMap(), 0, 0, this);
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void show(Image image) {
        this.image = image;
        repaint();
    }
}
