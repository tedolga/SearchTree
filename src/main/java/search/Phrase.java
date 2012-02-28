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

    public LinkedList<String> getBody() {
        return body;
    }

    public void setBody(LinkedList<String> body) {
        this.body = body;
    }

    public void copyBody(List<String> body) {
        LinkedList<String> newBody = new LinkedList<String>();
        for (String next : body) {
            newBody.add(next);
        }
        this.body = newBody;
    }

    public void copyTail(List<String> tail) {
        LinkedList<String> newTail = new LinkedList<String>();
        for (String next : tail) {
            newTail.add(next);
        }
        this.tail = newTail;
    }

    public LinkedList<String> getTail() {
        return tail;
    }

    public void setTail(LinkedList<String> tail) {
        this.tail = tail;
    }
}
