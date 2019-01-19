package com.gmail.erofeev.st.alexei.homework12.impl;

import com.gmail.erofeev.st.alexei.homework12.enums.Volume;

public class MediaBox {
    private Volume currentVolume;

    public MediaBox(Volume currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        Volume[] volumes = Volume.values();
        for (int i = 0; i < volumes.length; i++) {
            Volume volume = volumes[i];
            if (volume == currentVolume) {
                if (i < volumes.length - 1) {
                    currentVolume = volumes[i + 1];
                    System.out.println("Volume was increase: " + currentVolume);
                } else {
                    System.out.println("MAX VOLUME!!");
                }
            }
        }
    }

    public void decreaseVolume() {
        Volume[] volumes = Volume.values();
        for (int i = 0; i < volumes.length; i++) {
            Volume volume = volumes[i];
            if (volume == currentVolume) {
                if (i > 0) {
                    currentVolume = volumes[i - 1];
                    System.out.println("Volume was decrease: " + currentVolume);
                } else {
                    System.out.println("MIN VOLUME!!");
                }
            }
        }
    }
}
