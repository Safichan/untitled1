package userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * userinterface.Gui created a GUI to get an overview over trainers and pokemon. Currently in progress.
 */
public class Gui implements ActionListener, ItemListener {

    // all components
    protected JFrame frame;

    protected JPanel contentPane;
    protected JPanel buttonPanel;
    protected JPanel comboPanel;

    protected JLabel comboLabel;

    protected JButton butNew;
    protected JButton butEdit;
    protected JButton butDel;

    protected JComboBox<String> trainer;
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
        this.comboPanel = new JPanel();

        this.trainer = new JComboBox<String>(trainerList);
        trainer.addItemListener(this);
        trainer.setSize(100, 30);
        this.comboPanel.add(trainer, BorderLayout.CENTER);
        this.comboLabel = new JLabel(" ");
        this.comboPanel.add(comboLabel);

        //buttons
        this.buttonPanel = new JPanel();

        this.butNew = new JButton("New");
        this.butNew.setBounds(130, 100, 100, 40);
        this.butNew.addActionListener(this);
        this.buttonPanel.add(butNew);

        this.butEdit = new JButton("Edit");
        this.butEdit.setBounds(130, 100, 100, 40);
        this.butEdit.addActionListener(this);
        this.buttonPanel.add(butEdit);

        this.butDel = new JButton("Delete");
        this.butDel.setBounds(130, 100, 100, 40);
        this.butDel.addActionListener(this);
        this.buttonPanel.add(butDel);

        this.contentPane.add(comboPanel);
        this.contentPane.add(buttonPanel);

        // set Layout
        this.frame.setLayout(new FlowLayout());
        this.frame.setSize(300, 200);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        if (ae.getSource() == butNew) {
          System.out.println("Neuer Trainer wird erstellt!");
        }
        if (ae.getSource() == butEdit) {
          System.out.println("Trainer wird bearbeitet!");
        }
        if (ae.getSource() == butDel) {
          System.out.println("Trainer wird gelöscht!");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == trainer) {
            comboLabel.setText(trainer.getSelectedItem() + " selected");
        }
    }

}
