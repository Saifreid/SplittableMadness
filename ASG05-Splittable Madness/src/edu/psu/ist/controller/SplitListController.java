package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;

public class SplitListController {

    private ISplittableList<String> listModel;
    private SplitListView view;

    public SplitListController(ISplittableList<String> m,
                               SplitListView v) {
        this.listModel = m;
        this.view = v;

        //view.form.getLastRemovedLabel().setText("Last Removed: N/A");
        //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
        //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");

        // TODO: will need to handle updating the value labels once
        //       Jlabels for them are added to the view
        view.getAddToRightAtFrontButton().addActionListener(e -> {
            if(view.getTextField().getText().isBlank()){
                JOptionPane.showMessageDialog(view, "Please enter a value to add");
                return;
            }
            listModel.addToRightAtFront(view.getTextField().getText());
            view.getListValueLabel().setText(listModel.toString());
            //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
        });

        view.getRemoveFromRightAtFrontButton().addActionListener(e ->{
            if(listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "Right list is empty");
                return;
            }
            //view.form.getLastRemovedLabel().setText("Last Removed:" + listModel.removeFromRightAtFront());
            //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.getListValueLabel().setText(listModel.toString());
        });

        view.getMoveForwardButton().addActionListener(e ->{
            if(listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "Right list is empty cannot go forward!");
                return;
            }
            listModel.moveForward();
            //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.getListValueLabel().setText(listModel.toString());
        });

        view.getMoveToBeginningButton().addActionListener(e ->{
            listModel.moveToVeryBeginning();
            //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.getListValueLabel().setText(listModel.toString());
        });

        view.getClearButton().addActionListener(e -> {
            listModel.clear();
            //view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            //view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.getListValueLabel().setText(listModel.toString());
        });

        view.getCountButton().addActionListener(e -> {
            throw new UnsupportedOperationException("not implemented");
        });
        /*view.form.getUndoButton().addActionListener(e -> {
            listModel.undo();
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());
        });
        */
    }
}