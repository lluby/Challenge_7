package com.example.Challenge7.request;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ScheduleRequest {
    Timer timer = new Timer();
    public void schedulePromo(Timer timer, String jadwal, int jam, int menit, int detik) {
        schedulePromo(timer, "Makan Siang", 12, 0, 0);
        schedulePromo(timer, "Makan Malam", 19, 0, 0);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.HOUR_OF_DAY, jam);
        calendar.set(java.util.Calendar.MINUTE, menit);
        calendar.set(java.util.Calendar.SECOND, detik);

        long period = 24 * 60 * 60 * 1000;

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                System.out.println("Promo di BinarFud sekarang!\n" +
                        "Jangan lewatkan yaaa!!!!!");
            }
        }, calendar.getTime(), period);
    }
}

