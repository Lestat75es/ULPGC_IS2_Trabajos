package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;

public class PrevImageCommand implements Command {

    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(previousImage());
    }

    private Image previousImage() {
        return imageDisplay.image().previous();
    }
}
