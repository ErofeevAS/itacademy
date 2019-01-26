package com.gmail.erofeev.st.alexei.homework16.thread;

import com.gmail.erofeev.st.alexei.homework16.ThreadService;

public class TaskThreeTread extends Thread {
    private ThreadService threadService;

    public TaskThreeTread(ThreadService threadService) {
        this.threadService = threadService;
    }

    @Override
    public void run() {
        threadService.showCurrentThreadAndTime();
    }
}
