package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

/**
 * This is the view for the splittable list application. As per the
 * MVC architectural pattern, no business logic is found here (all view focused)
 * <p>
 * So this class just contains some boilerplate swing setup code for the
 * application frame and layout logic for the buttons. The class also provides
 * accessors for the controls needed by
 * {@link edu.psu.ist.controller.SplitListController}.
 * <p>
 * <b>NB:</b> this class was updated such that it is manually built using raw
 * swing components (as opposed to the formbuilder).
 */
public class SplitListView extends JFrame {

    /** The {@link javax.swing.JTextField} that users type stuff into. */
    private final JTextField textField;

    /** The {@link javax.swing.JLabel} that displays the state of the list. */
    private final JLabel listValueLabel;

    /** The various controls ({@link JButton}s) for manipulating the list. */
    private final JButton addToRightAtFrontButton,
            removeFromRightAtFrontButton, moveForwardButton,
            moveToBeginningButton, countButton, clearButton;

    // constructor
    public SplitListView(String initialListStringRep) {

        // some initial setup for the frame
        setTitle("Splittable Madness");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting up the buttons & item entry textfield
        this.textField = new JTextField();
        this.addToRightAtFrontButton = new JButton("Add to Right at Front");
        this.removeFromRightAtFrontButton = new JButton("Remove from Right " +
                "at" + " Front");
        this.moveForwardButton = new JButton("Move Forward");
        this.moveToBeginningButton = new JButton("Move to Beginning");
        this.countButton = new JButton("Count # of");
        this.clearButton = new JButton("Clear");

        this.listValueLabel = new JLabel(initialListStringRep);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(listValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(addToRightAtFrontButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(removeFromRightAtFrontButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(moveForwardButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(moveToBeginningButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(countButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(clearButton, gbc);

        // add the panel to the form and finish some of the frame setup
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTextField() { return textField; }
    public JLabel getListValueLabel() { return listValueLabel; }

    public JButton getAddToRightAtFrontButton() {
        return addToRightAtFrontButton;
    }

    public JButton getRemoveFromRightAtFrontButton() {
        return removeFromRightAtFrontButton;
    }

    public JButton getMoveForwardButton() { return moveForwardButton; }
    public JButton getMoveToBeginningButton() { return moveToBeginningButton; }
    public JButton getCountButton() { return countButton; }
    public JButton getClearButton() { return clearButton; }
}
