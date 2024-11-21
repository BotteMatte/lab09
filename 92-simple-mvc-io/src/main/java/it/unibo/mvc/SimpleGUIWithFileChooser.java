package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My second Jframe");

    private SimpleGUIWithFileChooser(final Controller ctrl){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        
        JTextField textArea = new JTextField();
        final JButton saveButton = new JButton();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                try {
                    ctrl.saveContentToFile(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e, "error message", 0);
                }
            }
        });

        panel1.add(textArea, BorderLayout.CENTER);
        panel1.add(saveButton, BorderLayout.SOUTH);

        //aggiungo text field per inserie il precorso e bottone per salvarlo
        final JTextField filepath  = new JTextField(ctrl.getCurrentFile());
        filepath.setEditable(false);
    }


    private void display() {
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param a
     *            unused
     */
    public static void main(final String... a) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();
    }
}
