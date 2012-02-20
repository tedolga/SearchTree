package search;

import java.util.LinkedList;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Branch {
    private LinkedList<Phrase> elements = new LinkedList<Phrase>();
    private int level;

    public Branch(int level) {
        this.level = level;
    }


    public LinkedList<Phrase> getElements() {
        return elements;
    }
}
