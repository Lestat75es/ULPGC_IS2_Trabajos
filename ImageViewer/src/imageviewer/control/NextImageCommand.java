package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;

public class NextImageCommand implements Command {
    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.show(nextImage());
    }

    private Image nextImage() {
        return imageDisplay.image().next();
    }
    
}
