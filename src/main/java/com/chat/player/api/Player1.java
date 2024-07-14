package com.chat.player.api;

import java.io.*;
import java.lang.management.*;
import java.net.*;

import com.chat.player.util.Constant;

public class Player1 {

    static int messageCount = 1;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Constant.PORT);
        Socket socket = serverSocket.accept();
        FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/messages/Player1Messages.txt");

        fw.write(Constant.STAR + "\n");
        fw.write("                 PLAYER 1 Chat" + "\n");
        fw.write(Constant.STAR + "\n");

        /*
         * The below snippet is used to get the process Id(PID)
         */

        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        String jvmName = bean.getName();
        fw.write("PID: " + Long.parseLong(jvmName.split("@")[0]) + "\n");


        while (messageCount <= Constant.MESSAGE_COUNT) {
            String messageReceived = readReceivedMessage(socket, fw);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(outputStreamWriter);

            String messageToSend = messageReceived + "*";
            out.println(messageToSend);
            out.flush();
            fw.write("Sending to PLAYER2  :        " + messageToSend + "\n");
            messageCount++;
        }
        fw.close();

    }


    /*
     * This method reads the message from PLAYER 1 and
     * write the received message in Player2Messages.txt file.
     */

    static String readReceivedMessage(Socket socket, FileWriter fw) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receivedMessage = br.readLine();
        fw.write("Message from PLAYER2:        " + receivedMessage + "\n");
        return receivedMessage;
    }

}

