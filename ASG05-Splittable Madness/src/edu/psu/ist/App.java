package edu.psu.ist;

import edu.psu.ist.controller.SplitListController;
import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.model.UtilListImpl;
import edu.psu.ist.view.SplitListView;

public class App {
    public static void main(String[] args) {

        ISplittableList<String> model = new UtilListImpl<>();

        // pass in the toString for the splittable list (we don't hardcode it in
        // the view class since we don't know what shape it might take in
        // UtilListImpl)
        SplitListView view = new SplitListView(model.toString());
        SplitListController controller =
                new SplitListController(model, view);
    }
}

