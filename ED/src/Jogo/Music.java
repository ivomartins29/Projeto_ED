/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;

/**
 * Classe que permite a introdução de uma música
 *
 * @author 8150121 e 8150133
 */
public class Music {

    private final int MAX_VOLUME = 50;
    private Clip clip;

    /**
     * Método construtor de Music
     */
    public Music() {
    }

    /**
     * Método que lê o ficheiro com a música
     *
     * @param filePath nome do ficheiro que contém a música
     */
    public void readMusic(String filePath) throws IOException {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
            } else {
                JOptionPane.showMessageDialog(null, "Can't find music file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que altera o volume da música
     * 
     * @param vol valor para o qual o volume vai ser alterado
     */
    public void setVolume(final int vol) {

        int volume = vol;
        if (volume < 0) {
            volume = MAX_VOLUME;
        }
        float gainDb = 0.0f;
        final FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        if (volume == 0) {
            gainDb = gain.getMinimum();

        } else if (volume < MAX_VOLUME) {

            // The volume algorithm is subtractive: The implementation assumes that
            // the sound is already at maximum volume, so we avoid distortion by
            // making the amplitude values
            // The scaling factor for the volume would be 20 normally, but
            // it seems that 13 is better
            gainDb = (float) (Math.log10(MAX_VOLUME - volume) * 13.0);
        }
        gain.setValue(-gainDb);
    }

    /**
     * Get de clip
     * 
     * @return o clip
     */
    public Clip getClip() {
        return clip;
    }

}
