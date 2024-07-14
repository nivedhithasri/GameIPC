package com.chat.player.api;

import java.io.*;
import java.lang.management.*;
import java.net.*;

import com.chat.player.util.Constant;

public class Player2 {

    static int messageCount = 1;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(Constant.IP, Constant.PORT);
        String messageToSend = Constant.GREETING_MESSAGE;
        FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/messages/Player2Messages.txt");

        fw.write(Constant.STAR + "\n");
        fw.write("                 PLAYER 2 Chat" + "\n");
        fw.write(Constant.STAR + "\n");

        /*
         * The below snippet is used to get the process Id(PID)
         */
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        String jvmName = bean.getName();
        fw.write("PID: " + Long.parseLong(jvmName.split("@")[0]) + "\n");


        while (messageCount <= Constant.MESSAGE_COUNT) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            PrintWriter out = new PrintWriter(outputStreamWriter);

            messageToSend += String.valueOf(messageCount);
            out.println(messageToSend);
            out.flush();

            fw.write("Sending to PLAYER1  :        " + messageToSend + "\n");
            readReceivedMessage(socket, fw);

            messageCount++;
        }
        fw.close();

    }

    /*
     * This method reads the message from PLAYER 2 and
     * write the received message in Player1Messages.txt file.
     */
    static void readReceivedMessage(Socket socket, FileWriter fw) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String receivedMessage = br.readLine();

        fw.write("Message from PLAYER1:        " + receivedMessage + "\n");
    }
}