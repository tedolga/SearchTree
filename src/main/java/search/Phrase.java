package search;

import java.util.LinkedList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class Phrase {

    private LinkedList<String> body = new LinkedList<String>();
    private LinkedList<String> tail = new LinkedList<String>();

    public Phrase(List<String> phrase) {
        for (String word : phrase) {
            body.add(word);
        }
    }

    public LinkedList<String> getBody() {
        return body;
    }

    public LinkedList<String> getTail() {
        return tail;
    }

    public void setTail(LinkedList<String> tail) {
        this.tail = tail;
    }
}
