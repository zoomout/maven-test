package com.bogdan._15_swing;


import javax.swing.*;

/**
 * Created by zoomout on 11/23/16.
 */
public class App {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new MainFrame("Swing worker demo");
        });
    }
}
