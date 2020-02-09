import ilarkesto.media.VolumeControl;

public class test {

    public static void main(String... args) {
        System.out.println(VolumeControl.getMasterOutputLine());
        VolumeControl.setMasterOutputVolume(0.4f);
        System.out.println(VolumeControl.getMasterOutputVolume());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
