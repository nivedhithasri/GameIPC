package com.chat.player.api;

public class MainClassApp {

    public static void main(String[] args) throws Exception {


        Thread thread1 = new Thread(() -> {
            try {
                Player1.main(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                Player2.main(new String[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}