package net.nlovell.jaslin.nodes.server.mediaplayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class UDPBroadcaster {

    static String fileLoc = "D:/test/test.wav";
    AtomicBoolean play = new AtomicBoolean(false);

    public static void main(String[] args) throws IOException {
        new UDPBroadcaster().playMusic(fileLoc);
    }

    void playMusic(String loc) {
        try {
            final File audioFile = new File(loc);

            if (audioFile.exists()) {
                Thread t = new Thread(new clipStreamer(audioFile));
                t.start();
            }
            while (true) {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class clipStreamer implements Runnable {
        private File file;

        public clipStreamer(File parameter) {
            this.file = parameter;
        }

        public void run() {
            try {
                AudioInputStream aui = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(aui);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}