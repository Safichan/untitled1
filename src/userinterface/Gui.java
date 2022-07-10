package userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;

/**
 * userinterface.Gui created a GUI to get an overview over trainers and pokemon. Currently in progress.
 */
public class Gui implements ActionListener {

    // all components
    protected JFrame frame;
    protected JPanel contentPane;
    protected JButton button1;
    protected JComboBox trainer;
    protected String[] trainerList = {"du da", "er da", "Noir", "Han", "Mary", "ich", "du"};

    /**
     * Consturctor places all components at the right place. Currently in progress and without
     * any parameters.
     */
    public Gui() {
        // set frame and contentPane
        this.frame = new JFrame();
        this.contentPane = new JPanel();
        this.frame.setContentPane(contentPane);

        // adding elements
        this.button1 = new JButton("Test");
        this.button1.setBounds(130, 100, 100, 40);
        this.button1.addActionListener(this);
        this.contentPane.add(button1);

    /*this.trainer = new JComboBox(trainerList);
    trainer.setSize(200, 20);
    this.contentPane.add(trainer);*/

        // set Layout
        this.frame.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        this.frame.setSize(300, 400);

        // set visible
        this.frame.setVisible(true);
    }

    /**
     * Overrided method from ActionListener. Currently in progress.
     *
     * @param ae Action Event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button1) {
            System.out.println("Hallo!! Button 1 gedrueckt!");
        }
    }

}
