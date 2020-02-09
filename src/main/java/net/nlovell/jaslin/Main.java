package net.nlovell.jaslin;

import net.nlovell.jaslin.nodes.client.Client;
import net.nlovell.jaslin.nodes.server.Server;
import net.nlovell.jaslin.tools.OSUtils;
import net.nlovell.jaslin.tools.data.ClientServerEnum;
import net.nlovell.jaslin.tools.data.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String... args){
        System.out.println(Constants.JASLIN_LOGO_COLOUR);

        boolean isServer = false;
        boolean isClient = false;

        ClientServerEnum csa = getServerClientFromArgs(args);

        if(csa == ClientServerEnum.SERVER || csa == ClientServerEnum.BOTH) {
            isServer = true;
        }
        if(csa == ClientServerEnum.CLIENT || csa == ClientServerEnum.BOTH) {
            isClient = true;
        }

        if (csa == null) {
            isServer = promptIsServer();
        }

        if (isServer) {
            System.out.println("Attempting to launch node as Server.");
            startServer(args);
            System.out.println('\n');
        } else {
            isClient = true;
        }

        if (csa == null && !isClient) {
            isClient = promptIsClient();
        }

        if (isClient) {
            if (isServer) {
                System.out.println("Attempting to launch Client on Server node!");
            } else {
                System.out.println("Attempting to launch node as Client.");
            }
            startClient();
        }
    }

    private static boolean startClient() {
        String os = OSUtils.getOSName();
        String ip = OSUtils.getIP();

        if (OSUtils.supportedOSContains(os)) {
            Client client = new Client();
         } else {
            System.out.println("Sorry, operating system " + os
                    + " is currently unsupported to run as a JASLiN client!");
            return false;
        }
        System.out.println("JASLiN node at " + ip + " is starting as Client");
        return true;
    }

    private static boolean startServer(String[] args) {
        String os = OSUtils.getOSName();
        String ip = OSUtils.getIP();

        if (OSUtils.supportedOSContains(os)) {
            Server server = new Server();
            System.out.println("JASLiN node at " + ip + " is starting as Server");
            return true;
        } else {
            System.out.println("Sorry, operating system " + os
                    + " is currently unsupported to run as a JASLiN server!");
            return false;
        }
    }

    private static ClientServerEnum getServerClientFromArgs(String[] args) {
        //User can pass in "Server" or "Client" as an argument
        boolean server = false;
        boolean client = false;
        if (args.length > 0) for (String arg : args) {
            if (arg.equalsIgnoreCase("server")) {
                server = true;
            } else if (arg.equalsIgnoreCase("client")) {
                client = true;
            }
        }

        if (client && server) {
            return ClientServerEnum.BOTH;
        } else if (client) {
            return ClientServerEnum.CLIENT;
        } else if (server) {
            return ClientServerEnum.SERVER;
        }
        return null;
    }


    private static boolean promptIsServer() {
        AtomicBoolean isServer = new AtomicBoolean(false);
        AtomicBoolean validInput = new AtomicBoolean(false);


        //If the user hasn't set it as a client, offer a way to manually set it at run-time
        if (!validInput.get()) {
            System.out.println("SERVER argument not set when launched");
            System.out.println("If no input is detected, the system will default to a client node in "
                    + Constants.IS_CLIENT_TIMER / 1000 + " seconds.\n" +
                    "Type [Y] followed by ENTER if this node is intended to be a JASLiN server.\n" +
                    "Type [N] followed by ENTER if this node is intended to be a JASLiN client.\n");

            Thread uip = userInputThread(validInput, isServer);
            uip.start();

            final int timer = Constants.IS_CLIENT_TIMER;
            final int iter = timer / Constants.IS_CLIENT_TIMER_CHECK;
            int s = 0;
            for (int i = iter; i < timer; i += iter) {
                try {
                    if (s != (timer - i) / 1000) {
                        s = (timer - i) / 1000;
                        System.out.print("\r[" + (timer - i) / 1000 + "] Is Server? Y or N: ");
                    }
                    Thread.sleep(iter);
                    if (validInput.get()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            uip.interrupt();
        }

        if (!validInput.get()) {
            validInput.set(true);
            System.out.println("\nNo " +
                    "valid input was detected. Node defaulting to Client.");

        }
        return isServer.get();
    }

    private static boolean promptIsClient() {
        //TODO would be interesting to have it just boot into whatever was the last "mode" but you can use keyboard to switch it at start up

        AtomicBoolean isClient = new AtomicBoolean(true);
        AtomicBoolean validInput = new AtomicBoolean(false);

        //If the user hasn't set it as a client, offer a way to manually set it at run-time
        if (!validInput.get()) {
            System.out.println("CLIENT argument not set when launched");
            System.out.println("If no input is detected, the system will default to a client node in "
                    + Constants.IS_CLIENT_TIMER / 1000 + " seconds.\n" +
                    "Type [Y] followed by ENTER if this node is intended to be a JASLiN client.\n" +
                    "Type [N] followed by ENTER if this node is not intended to be a JASLiN client.\n");

            Thread uip = userInputThread(validInput, isClient);
            uip.start();

            final int timer = Constants.IS_CLIENT_TIMER;
            final int iter = timer / Constants.IS_CLIENT_TIMER_CHECK;
            int s = 0;
            for (int i = iter; i < timer; i += iter) {
                try {
                    if (s != (timer - i) / 1000) {
                        s = (timer - i) / 1000;
                        System.out.print("\r[" + (timer - i) / 1000 + "] Is Client? Y or N: ");
                    }
                    Thread.sleep(iter);
                    if (validInput.get()) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            uip.interrupt();
        }

        if (!validInput.get()) {
            pressEnter();
            validInput.set(true);
            System.out.println("\nNo valid input was detected. Node defaulting to Client.");
        }
        return isClient.get();
    }

    private static void pressEnter() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            System.out.println("beep boop");
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static Thread userInputThread(AtomicBoolean validInput, AtomicBoolean isInput) {
        return new Thread(() -> {
            while (!validInput.get()) {
                String input = Constants.userInput.nextLine();
                if (input != null) {
                    if (input.toUpperCase().equals("Y")) {
                        isInput.set(true);
                        validInput.set(true);
                    } else if (input.toUpperCase().equals("N")) {
                        isInput.set(false);
                        validInput.set(true);
                    }
                }
            }
        });

    }
}