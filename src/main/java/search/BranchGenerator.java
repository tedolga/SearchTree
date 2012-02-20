package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchGenerator {

    public static List<Branch> generateBranches(Phrase phrase) {
        List<Branch> branches = new ArrayList<Branch>();
        LinkedList<String> body = phrase.getBody();
        LinkedList<String> tail = phrase.getTail();
        int bodySize = body.size();
        for (int i = 0; i < bodySize; i++) {
            Branch branch = new Branch(i);
            Phrase branchPhrase = new Phrase(body);
            LinkedList<String> newTail = new LinkedList<String>();
            for (String next : tail) {
                newTail.add(next);
            }
            branchPhrase.setTail(newTail);
            tail.addFirst(body.removeLast());
            branch.getElements().add(branchPhrase);
            branches.add(branch);
        }
        return branches;
    }

    public static void main(String[] args) {


    }
}
