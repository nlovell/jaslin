package net.nlovell.jaslin.nodes.server.mediaplayer;

import javax.sound.sampled.*;

public class NetworkDataLine implements SourceDataLine {

    @Override
    public void open(final AudioFormat format, final int bufferSize) throws LineUnavailableException {

    }

    @Override
    public void open(final AudioFormat format) throws LineUnavailableException {

    }

    @Override
    public int write(final byte[] b, final int off, final int len) {
        return 0;
    }

    @Override
    public void drain() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public AudioFormat getFormat() {
        return null;
    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public int available() {
        return 0;
    }

    @Override
    public int getFramePosition() {
        return 0;
    }

    @Override
    public long getLongFramePosition() {
        return 0;
    }

    @Override
    public long getMicrosecondPosition() {
        return 0;
    }

    @Override
    public float getLevel() {
        return 0;
    }

    @Override
    public Line.Info getLineInfo() {
        return null;
    }

    @Override
    public void open() throws LineUnavailableException {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public Control[] getControls() {
        return new Control[0];
    }

    @Override
    public boolean isControlSupported(final Control.Type control) {
        return false;
    }

    @Override
    public Control getControl(final Control.Type control) {
        return null;
    }

    @Override
    public void addLineListener(final LineListener listener) {

    }

    @Override
    public void removeLineListener(final LineListener listener) {

    }
}
