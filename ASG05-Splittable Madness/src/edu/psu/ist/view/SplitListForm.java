package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JPanel myPanel;
    private JButton addToRightAtButton;
    private JTextField textField1;
    private JLabel listValueLabel;
    private JButton removeFromRightAtButton;

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JButton getAddToRightAtButton() {
        return addToRightAtButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JLabel getListValueLabel() {
        return listValueLabel;
    }

    public JButton getRemoveFromRightAtButton() {
        return removeFromRightAtButton;
    }

    public JLabel getLastRemovedLabel() {
        return lastRemovedLabel;
    }

    public JButton getMoveForwardButton() {
        return moveForwardButton;
    }

    public JLabel getLeftLengthLabel() {
        return leftLengthLabel;
    }

    public JButton getMoveToBeginningButton() {
        return moveToBeginningButton;
    }

    public JLabel getRightLengthLabel() {
        return rightLengthLabel;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JButton getCountOfButton() {
        return countOfButton;
    }

    private JLabel lastRemovedLabel;
    private JButton moveForwardButton;
    private JLabel leftLengthLabel;
    private JButton moveToBeginningButton;
    private JLabel rightLengthLabel;
    private JButton clearButton;
    private JButton undoButton;
    private JButton countOfButton;
}
