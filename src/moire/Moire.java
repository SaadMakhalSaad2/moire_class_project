package moire;

import moire.MoirePanel;

import javax.swing.*;
import java.awt.*;

public class Moire extends JFrame {
    private static final int FRAME_WIDTH = 512;
    private static final int FRAME_HEIGHT = 512;

    public Moire(){
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Moire Drawer");

        Container contentPane = this.getContentPane();
        MoirePanel moirePanel = new MoirePanel();

        contentPane.add(moirePanel);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Moire();
    }
}