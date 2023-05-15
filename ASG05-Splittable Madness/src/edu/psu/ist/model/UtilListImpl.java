package edu.psu.ist.model;

import edu.psu.ist.model.ISplittableList;

import java.util.*;

public class UtilListImpl<E> implements ISplittableList<E> {
    // "propagating" this   ^ generic E up into the       ^ interface

    private List<E> left = new ArrayList<>()/* either new ArrayList<>() OR new LinkedList<>() .. decide carefully */;
    private List<E> right = new LinkedList<>()/* either new ArrayList<>() OR new LinkedList<>() .. decide carefully */;

    // HINT: update this map whenever additions and removals are made to this.left or this.right.
    //       Then, when someone calls countOf(x), you can just lookup x in the map below and return
    //       the int count that comes back.
    private Map<E, Integer> countingMap = new HashMap<>();

    private Stack<ISplittableList<E>> undoStack = new Stack<>();

    private int firstFlag = 0;
    // (no constructor needed... unless you do the optional challenge)

    public UtilListImpl(){
        this.left = new ArrayList<>();
        this.right = new LinkedList<>();
        this.countingMap = new HashMap<>();
        this.undoStack = new Stack<>();

    }



    // TODO: method implementations go here...

    // here's a toString that renders the splittable list..

    @Override public String toString() { // O(n)
        StringBuilder sb = new StringBuilder("<");
        boolean first = true;
        for (E e : left) { // O(n) -- all calls to append(..) are O(1)
            // assuming you're just appending a fixed number of chars
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        sb.append("><");
        first = true;
        for (E e : right) { // O(n)
            if (first) {
                sb.append(e);
                first = false;
            } else {
                sb.append(", ").append(e);
            }
        }
        return sb.append(">").toString();
    }

    public List<E> getLeft() {
        return this.left;
    }

    public List<E> getRight() {
        return this.right;
    }

    public Map<E, Integer> getCountingMap() {
        return countingMap;
    }

    /**
     * Adds the element to the beginning of the right list
     * @param e the entry to add.
     * O(1)
     */
    @Override
    public void addToRightAtFront(E e) {

        this.right.add(0,e);
        if(countingMap.containsKey(e)){ // if the map has the value it adds 1 to it
            countingMap.put(e,countingMap.get(e)+1);
        }
        countingMap.putIfAbsent(e,1); // if map doesn't have value already sets
                                        // it to 1
    }

    /**
     * Takes the front element of the right list and returns it while
     * removing it from the right list
     *O(1)
     * @return
     */
    @Override
    public E removeFromRightAtFront() {
        if(this.right.isEmpty()){       // security check for  the right list being empty.
            throw new NoSuchElementException();
        }

        E valuetoReturn = right.get(0);
        right.remove(0);
        countingMap.put(valuetoReturn, countingMap.get(valuetoReturn)-1);
        return valuetoReturn;
    }

    /**
     * Moves the cursor to the beginning of the Lists by moving
     * all the elements to the right list.
     * O(n)
     */
    @Override
    public void moveToVeryBeginning() {

        LinkedList<E> tempRight = new LinkedList<>(this.right);
        this.right = new LinkedList<>(this.left);   //adds back left list first
        this.right.addAll(tempRight);               //adds back the right list after. for full list
        this.left.clear();
    }

    /**
     * Gets the count value of the input element from both
     * left and right list
     * O(n)
     * @param e
     * @return
     */
    @Override
    public int countOf(E e) {
        int countValue = this.countingMap.getOrDefault(e,0);
        return countValue;
    }

    /**
     * Moves the cursor to the right by putting the next element from right
     * list to the left.
     * O(1)
     */
    @Override
    public void moveForward() {
        if(this.right.isEmpty()){       //security check
            throw new IllegalStateException();
        }
        this.left.add(this.right.get(0));
        this.right.remove(0);
    }

    /**
     * Return the length of the left list.
     * O(n)
     * @return
     */
    @Override
    public int leftLength() {
        return this.left.size();
    }

    /**
     * Return the length of the right list.
     * O(n)
     * @return
     */
    @Override
    public int rightLength() {
        return this.right.size();
    }

    /**
     * Clears both the right and left list
     * O(1)
     */
    @Override
    public void clear() {

        this.left.clear();
        this.right.clear();
        this.countingMap.clear();

    }

    /**
     * This method is an undo button for the last interaction.
     * 5 hours spent on this method and still didn't get it.
     */

    @Override
    public void undo(){
        if(this.firstFlag == 0){
            throw new IndexOutOfBoundsException();
        }
        ISplittableList<E> undoCopy = this.undoStack.pop();
        int undoLeftLength = undoCopy.leftLength();
        int undoRightLength = undoCopy.rightLength();
        this.left.clear();
        this.right.clear();
        undoCopy.moveToVeryBeginning();
        for (int i = 0; i < undoLeftLength + undoRightLength; i++){
            this.addToRightAtFront(undoCopy.removeFromRightAtFront());
        }
        for (int i = 0; i < undoLeftLength; i++){
            this.moveForward();
        }

    }
}