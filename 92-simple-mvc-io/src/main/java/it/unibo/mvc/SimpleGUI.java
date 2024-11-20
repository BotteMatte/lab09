package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first java graphical interface");

    public SimpleGUI(final Controller ctrl) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);

        final JTextArea textArea = new JTextArea("");
        canvas.add(textArea, BorderLayout.CENTER);

        final JButton saveButton = new JButton("save");
        canvas.add(saveButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event){
                try {
                    ctrl.saveContentToFile(textArea.getText());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //frame size and location
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int)screen.getWidth();
        final int sh = (int)screen.getHeight();
        frame.setSize( sw/2, sh/2);
        frame.setLocationByPlatform(true);
    }

    private void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }

}
