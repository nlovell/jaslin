package net.nlovell.jaslin.nodes.server.mediaplayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;


public class UDPReceiver {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            // play a file passed via the command line
            File soundFile = MediaUtils.getSoundFile(args[0]);
            System.out.println("Client: " + soundFile);
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(soundFile))) {
                play(in);
            }
        } else {
            // play soundfile from server
            System.out.println("Client: reading from 127.0.0.1:6666");
            try (Socket socket = new Socket("127.0.0.1", 6666)) {
                if (socket.isConnected()) {
                    InputStream in = new BufferedInputStream(socket.getInputStream());
                    play(in);
                }
            }
        }

        System.out.println("Client: end");
    }


    private static synchronized void play(final InputStream in) throws Exception {
        AudioInputStream ais = AudioSystem.getAudioInputStream(in);
        try (Clip clip = AudioSystem.getClip()) {
            clip.open(ais);
            clip.start();
            Thread.sleep(100); // given clip.drain a chance to start
            clip.drain();
        }
    }
}