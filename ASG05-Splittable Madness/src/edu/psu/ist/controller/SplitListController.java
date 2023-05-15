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

        // first thing we'll do in the constructor
        // (remember: this runs only once per run of the app) is set the initial
        // text rendering the (empty) list
        view.form.getListValueLabel().setText(listModel.toString());
        view.form.getLastRemovedLabel().setText("Last Removed: N/A");
        view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
        view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");

        // TODO: (Start this only once the form is built --
        //        and the App class runs and displays your form)
        //   add action listeners to the various buttons and manipulate the listModel,
        //   updating the various components on the view when needed
        view.form.getAddToRightAtButton().addActionListener(e -> {
            if(view.form.getTextField1().getText().isBlank()){
                JOptionPane.showMessageDialog(view, "Please enter a value to add");
                return;
            }
            listModel.addToRightAtFront(view.form.getTextField1().getText());
            view.form.getListValueLabel().setText(listModel.toString());
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");

        });

        view.form.getRemoveFromRightAtButton().addActionListener(e ->{
            if(listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "Right list is empty");
                return;
            }
            view.form.getLastRemovedLabel().setText("Last Removed:" + listModel.removeFromRightAtFront());
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());

        });

        view.form.getMoveForwardButton().addActionListener(e ->{
            if(listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "Right list is empty cannot go forward!");
                return;
            }
            listModel.moveForward();
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());
        });

        view.form.getMoveToBeginningButton().addActionListener(e ->{
            listModel.moveToVeryBeginning();
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());
        });

        view.form.getClearButton().addActionListener(e -> {
            listModel.clear();
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());
        });

        view.form.getCountOfButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(view, "Number of times " + view.form.getTextField1().getText() + " occurs:" + listModel.countOf(view.form.getTextField1().getText()));
        });
/*
        view.form.getUndoButton().addActionListener(e -> {
            listModel.undo();
            view.form.getLeftLengthLabel().setText("Left Length: " + listModel.leftLength()+"");
            view.form.getRightLengthLabel().setText("Right Length: " + listModel.rightLength()+"");
            view.form.getListValueLabel().setText(listModel.toString());
        });
*/
    }
}