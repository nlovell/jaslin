package net.nlovell.jaslin.nodes.server.mediaplayer;

import java.io.File;

public class MediaUtils {
    public static File getSoundFile(String fileName) {
        File soundFile = new File(fileName);
        if (!soundFile.exists() || !soundFile.isFile())
            throw new IllegalArgumentException("not a file: " + soundFile);
        return soundFile;
    }
}
