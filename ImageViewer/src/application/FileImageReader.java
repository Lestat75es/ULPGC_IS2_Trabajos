package application;

import imageviewer.model.Image;
import imageviewer.view.ImageReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.imageio.ImageIO;

public class FileImageReader implements ImageReader {

    private final File[] files;

    private static final String[] ImageExtensions = {".jpg", ".png", ".gif"};

    public FileImageReader(String path) {
        this(new File(path));
    }

    public FileImageReader(File folder) {
        this.files = folder.listFiles(withImageExtension());
    }

    @Override
    public Image read() {
        return imageAt(0);
    }

    private FilenameFilter withImageExtension() {
        return (File dir, String name) -> {
            return imageExtensionsStream().
                    filter(extension -> name.endsWith(extension)).
                    count() > 0;
        };
    }

    private Stream<String> imageExtensionsStream() {
        return Arrays.asList(ImageExtensions).stream();
    }

    private Image imageAt(final int index) {
        return new Image() {

            @Override
            public Object bitMap() {
                try {
                    return ImageIO.read(files[index]);
                } catch (IOException ex) {
                    Logger.getLogger(FileImageReader.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }

            @Override
            public Image previous() {
                return imageAt(index > 0 ? index - 1 : files.length - 1);
            }

            @Override
            public Image next() {
                return imageAt(index < files.length - 1 ? index + 1 : 0);
            }
        };
    }
}
