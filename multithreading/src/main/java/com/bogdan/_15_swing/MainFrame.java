package com.bogdan._15_swing;

import com.bogdan.common.Util;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by zoomout on 11/23/16.
 */
public class MainFrame extends JFrame {
    private JLabel countLabel1 = new JLabel("0");
    private JLabel statusLable = new JLabel("Task not completed");
    private JButton startButton = new JButton("Start");


    public MainFrame(String title) {
        super(title);
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridheight = 1;
        gc.gridwidth = 1;

        add(countLabel1, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridheight = 1;
        gc.gridwidth = 1;

        add(statusLable, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridheight = 1;
        gc.gridwidth = 1;

        add(startButton, gc);

        startButton.addActionListener(event -> start());

        setSize(200, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void start() {
        SwingWorker<String, Integer> worker = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                long start = System.currentTimeMillis();
                for (int i = 1; i <= 100; i++) {
                    Util.sleep(100);
                    publish(i);
                }
                long end = System.currentTimeMillis();
                return String.valueOf((end - start));
            }

            @Override
            protected void process(List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                countLabel1.setText(String.valueOf(value));
            }

            @Override
            protected void done() {
                try {
                    String time = get();
                    statusLable.setText("Completed in '" + time + "' ms");
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}


