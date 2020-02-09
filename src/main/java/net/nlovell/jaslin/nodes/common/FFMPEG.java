package net.nlovell.jaslin.nodes.common;

import net.nlovell.jaslin.tools.OSUtils;
import net.nlovell.jaslin.tools.data.Constants;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class FFMPEG {

    public boolean isFFMPEGAvailable() {
        Logger logger = Logger.getLogger(FFMPEG.class);
        File dir = new File("ffmpeg");
        dir.mkdirs();
        File[] folders = dir.listFiles(File::isDirectory);
        System.out.println(Arrays.toString(folders));

        for (File folder : folders) {
            if (folder != null && Files.exists(Paths.get(folder + "/bin/ffmpeg.exe"))) {
                logger.info("FFMPEG is available.");
                return true;
            }
        }

        logger.info("FFMPEG is not available.");
        return false;

    }

    public boolean downloadFFMPEG() {
        Logger logger = Logger.getLogger(FFMPEG.class);

        //Download FFMPEG for Windows
        if (OSUtils.getOsType().equals("windows")) {
            String url = Constants.FFMPEGWindows;
            try {
                File dir = new File(String.valueOf(Paths.get("ffmpeg")));
                dir.mkdirs();
                logger.debug("Attempting to download FFMPEG to " + dir);
                downloadUsingNIO(url, Paths.get("ffmpeg") + "/ffmpeg.zip");
                unzip(Paths.get("ffmpeg") + "/ffmpeg.zip", dir);
            } catch (IOException e) {
                logger.debug("Download failed.");
                e.printStackTrace();
            }


        }

        return Files.exists(Paths.get("ffmpeg"));
    }

    private void unzip(final String zip, final File destination) throws IOException {
        File srcFile = new File(zip);

        destination.mkdir();

        ZipFile zipFile = null;

        try {

            zipFile = new ZipFile(srcFile);

            // get an enumeration of the ZIP file entries
            Enumeration<? extends ZipEntry> e = zipFile.entries();

            while (e.hasMoreElements()) {

                ZipEntry entry = e.nextElement();

                File destinationPath = new File(destination, entry.getName());

                //create parent directories
                destinationPath.getParentFile().mkdirs();

                // if the entry is a file extract it
                if (entry.isDirectory()) {
                    continue;
                } else {

                    System.out.println("Extracting file: " + destinationPath);
             
                    BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));

                    int b;
                    byte buffer[] = new byte[1024];

                    FileOutputStream fos = new FileOutputStream(destinationPath);

                    BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);

                    while ((b = bis.read(buffer, 0, 1024)) != -1) {
                        bos.write(buffer, 0, b);
                    }

                    bos.close();
                    bis.close();

                }

            }

        } catch (IOException ioe) {
            System.out.println("Error opening zip file" + ioe);
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing zip file" + ioe);
            }
        }
    }


    private static void downloadUsingNIO(final String urlStr, final String file) throws IOException {
        URL url = new URL(urlStr);
        System.setProperty("http.agent", "Chrome");
        try (ReadableByteChannel rbc = Channels.newChannel(url.openStream());
             FileOutputStream fos = new FileOutputStream(file);) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }


}
