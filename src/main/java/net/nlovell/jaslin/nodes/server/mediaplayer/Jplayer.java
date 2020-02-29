package net.nlovell.jaslin.nodes.server.mediaplayer;

public class Jplayer {
    String fileLoc = "C:\\Users\\alan.lovell\\IdeaProjects\\untitled2\\src\\main\\resources\\audio\\example.mp3";


    static boolean isPlaying = false;

    public Jplayer(){

    }

    public void play(){
        System.out.println("Playing audio");
        //TODO make play
    };
    public void pause(){
        System.out.println("Pausing audio");
        //TODO make pause
    };

    public static boolean toggleState(){
        isPlaying = !isPlaying;
        if(isPlaying){
            //play();
        } else {
            //pause();
        }
        return isPlaying;
    }


}