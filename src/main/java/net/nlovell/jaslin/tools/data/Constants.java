package net.nlovell.jaslin.tools.data;

import java.util.Scanner;

public class Constants {

    public static final Scanner userInput = new Scanner(System.in);
    /**
     * The timeout for manual check if the application is being ran by a client, in milliseconds
     */
    public static final int IS_CLIENT_TIMER = 5000;

    /**
     * The timer for checking the client status periodically, in milliseconds.
     */
    public static final int IS_CLIENT_TIMER_CHECK = 500;

    /**
     *
     */
    public static final String FFMPEGWindows = "https://ffmpeg.zeranoe.com/builds/win64/static/ffmpeg-4.2.2-win64-static.zip";

    public static final String JASLIN_LOGO = '\n' +
            "                        ██              \n" +
            "    ██  Just Another    ██  ██          \n" +
            "    ██                  ██  ██          \n" +
            "        ██  ██  ██  ██  ██      ██      \n" +
            "    ██  ██  ██  ██  ██  ██  ██  ██  ██  \n" +
            "    ██      ██  ██      ██  ██  ██  ██  \n" +
            "    ██  ██  ██      ██  ██  ██  ██  ██  \n" +
            "    ██  ██  ██  ██  ██  ██  ██  ██  ██  \n" +
            "    ██  ██  ██  ██  ██  ██  ██  ██  ██  \n" +
            "    ██                                  \n" +
            "    ██  Speaker Link Network            \n" +
            "    ██     by nlovell.net               \n";


    //All of this below is used only to produce the JASLiN logo in colour.
    //It really wasn't worth the effort.
    private static final int jaslin_xterm_1 = 208;
    private static final int jaslin_xterm_2 = 214;

    private static final String jaslin_fg_1 = (char) 27 + "[48;05;" + jaslin_xterm_1 + ";38;05;" + jaslin_xterm_1 + "m";
    private static final String jaslin_fg_2 = (char) 27 + "[48;05;" + jaslin_xterm_2 + ";38;05;" + jaslin_xterm_2 + "m";
    private static final String bold_1 = (char) 27 + "[1;38;05;" + jaslin_xterm_1 + "m";
    private static final String bold_2 = (char) 27 + "[1;38;05;" + jaslin_xterm_2 + "m";
    private static final String nls = (char) 27 + "[2;38;05;240m";

    private static final String reset = (char) 27 + "[0m";

    //TODO document guide https://dev.to/mudasobwa/256-color-term-nightmare-level-6f7
    // https://jonasjacek.github.io/colors/

    /**
     * Jaslin Block "character"
     */
    private static final String jbl = "██";

    private static final String JBL1 = jaslin_fg_1 + jbl;
    private static final String JBL2 = jaslin_fg_2 + jbl;

    /**
     * Reset Single Space "character"
     */
    private static final String rssp = reset + new String(new char[jbl.length()]);

    /**
     * Jaslin End of Line "character"
     */
    private static final String jeol = reset + "\n" + rssp + rssp;

    public static final String JASLIN_LOGO_COLOUR = jeol +
            rssp + rssp + rssp + rssp + rssp + rssp + rssp + rssp + rssp + rssp + JBL2 + jeol +
            JBL1 + rssp + bold_1 + "J" + reset + "ust " + bold_2 + "A" + reset + "nother" + rssp + rssp + JBL2 + rssp + JBL1 + jeol +
            JBL1 + rssp + rssp + rssp + rssp + rssp + rssp + rssp + rssp + rssp + JBL2 + rssp + JBL1 + jeol +
            rssp + rssp + JBL2 + rssp + JBL2 + rssp + JBL1 + rssp + JBL1 + rssp + JBL2 + rssp + rssp + rssp + JBL2 + jeol +
            JBL1 + rssp + JBL2 + rssp + JBL2 + rssp + JBL1 + rssp + JBL1 + rssp + JBL2 + rssp + JBL1 + rssp + JBL2 + rssp + JBL2 + jeol +
            JBL1 + rssp + rssp + rssp + JBL2 + rssp + JBL1 + rssp + rssp + rssp + JBL2 + rssp + JBL1 + rssp + JBL2 + rssp + JBL2 + jeol +
            JBL1 + rssp + JBL2 + rssp + JBL2 + rssp + rssp + rssp + JBL1 + rssp + JBL2 + rssp + JBL1 + rssp + JBL2 + rssp + JBL2 + jeol +
            JBL1 + rssp + JBL2 + rssp + JBL2 + rssp + JBL1 + rssp + JBL1 + rssp + JBL2 + rssp + JBL1 + rssp + JBL2 + rssp + JBL2 + jeol +
            JBL1 + rssp + JBL2 + rssp + JBL2 + rssp + JBL1 + rssp + JBL1 + rssp + JBL2 + rssp + JBL1 + rssp + JBL2 + rssp + JBL2 + jeol +
            JBL1 + jeol +
            JBL1 + rssp + bold_1 + "S" + reset + "peaker " + bold_2 + "L" + bold_1 + "i" + reset + "nk " + bold_2 + "N" + reset + "etwork"+ jeol +
            JBL1 + rssp + rssp + nls + " by nlovell.net" + jeol;


    public static final int PORT = 4571;
}