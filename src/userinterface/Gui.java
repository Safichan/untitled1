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
    protected JPanel editPanel;
    protected JPanel newPanel;
    protected JPanel pokePanel;
    protected JPanel bottomPanel;

    protected JLabel comboLabel;

    protected JButton butNew;
    protected JButton butEdit;
    protected JButton butDel;
    protected JButton butBack;
    protected JButton butBackPoke;
    protected JButton butContinue;

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
        trainer.setMaximumSize(this.trainer.getPreferredSize());
        this.comboPanel.add(trainer);
        this.comboLabel = new JLabel(" ");
        this.comboPanel.add(comboLabel);

        //buttons
        this.buttonPanel = new JPanel();
        this.bottomPanel = new JPanel();

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
      
        this.butContinue = new JButton("Continue");
        this.butContinue.setBounds(130, 100, 100, 40);
        this.butContinue.addActionListener(this);
        this.bottomPanel.add(butContinue);
        this.buttonPanel.setMaximumSize(this.buttonPanel.getPreferredSize());

        this.butBack = new JButton("Back");
        this.butBack.setBounds(130, 100, 100, 40);
        this.butBack.addActionListener(this);

        this.butBackPoke = new JButton("Back");
        this.butBackPoke.setBounds(130, 100, 100, 40);
        this.butBackPoke.addActionListener(this);

        //edit Layout
        this.editPanel = new JPanel();
        this.editPanel.add(butBack);

        //pokemon Layout
        this.pokePanel = new JPanel();
        this.pokePanel.add(butBackPoke);

        this.contentPane.add(comboPanel);
        this.contentPane.add(buttonPanel);
        this.contentPane.add(bottomPanel);

        // set Layout
        this.frame.setTitle("PokéDexReloaded");
        this.frame.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        this.frame.setLayout(new FlowLayout());
        this.frame.setSize(290, 200);
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
          this.contentPane.setVisible(false);
          this.pokePanel.setVisible(false);
          editPanel.setVisible(true);
          this.frame.setContentPane(editPanel);
          this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (ae.getSource() == butDel) {
          System.out.println("Trainer wird gelöscht!");
        }
        if (ae.getSource() == butBack || ae.getSource() == butBackPoke) {
          System.out.println("Zurück");
          this.editPanel.setVisible(false);
          this.pokePanel.setVisible(false);
          this.contentPane.setVisible(true);
          this.frame.setContentPane(contentPane);
        }
        if (ae.getSource() == butContinue) {
          System.out.println("Weiter");
          this.contentPane.setVisible(false);
          this.pokePanel.setVisible(true);
          this.frame.setContentPane(pokePanel);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == trainer) {
            comboLabel.setText(trainer.getSelectedItem() + " selected");
        }
    }

}
