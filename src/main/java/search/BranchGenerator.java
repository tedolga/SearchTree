package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchGenerator {

//    public static List<Branch> generateBranches(Phrase phrase, Branch parentBranch) {
//        List<Branch> branches = new ArrayList<Branch>();
//        Phrase tempPhrase = new Phrase();
//        tempPhrase.copyTail(phrase.getTail());
//        LinkedList<String> tail = tempPhrase.getTail();
//        LinkedList<String> newTail = new LinkedList<String>();
//        final int tailSize = tail.size();
//        for (int i = 0; i < tailSize; i++) {
//            Phrase childPhrase = new Phrase();
//            childPhrase.copyBody(tail);
//            childPhrase.copyTail(newTail);
//            newTail.addFirst(tail.removeLast());
//            if (tail.size() > 0) {
//                Branch childBranch = new Branch();
//                childBranch.copyFromParent(parentBranch.getElements());
//                childBranch.getElements().add(childPhrase);
//                branches.add(childBranch);
//            } else {
//                parentBranch.getElements().add(childPhrase);
//            }
//        }
//
//        return branches;
//    }

    public static List<BranchElement> receiveLeaves(BranchElement element) {
        List<BranchElement> leaves = new ArrayList<BranchElement>();
        List<BranchElement> children = element.getChildren();
        for (BranchElement childElement : children) {
            if (childElement.getChildren().size() > 0) {
                children = receiveLeaves(childElement);
            } else {
                leaves.add(childElement);
            }
        }
        return leaves;
    }

//    public static boolean checkLeaves(List<BranchElement> branchElements) {
//        boolean isCompleted = true;
//        for (BranchElement nextElement : branchElements) {
//            Phrase lastElement = nextBranch.getElements().getLast();
//            if (lastElement.getTail().size() >= 1) {
//                isCompleted = false;
//            }
//        }
//        return isCompleted;
//    }

//    public static void main(String[] args) {
//        List<String> words = new ArrayList<String>();
//        words.add("The");
//        words.add("Best");
//        words.add("Film");
//        Phrase phrase = new Phrase();
//        phrase.copyTail(words);
//        Branch branch = new Branch();
//        BranchElement root=new BranchElement(null);
//        root.setValue(phrase);
//        branch.getElements().add(root);
//        List<Branch> newBranches = new LinkedList<Branch>();
//        while (!checkBranches(branches)) {
//            for (Branch nextBranch : branches) {
//                Phrase lastElement = nextBranch.getElements().getLast();
//                List<Branch> generatedBranches = generateBranches(lastElement, nextBranch);
//                for (Branch generatedBranch : generatedBranches) {
//                    newBranches.add(generatedBranch);
//                }
//            }
//
//
//            for (Branch newBranch : newBranches) {
//                branches.add(newBranch);
//            }
//            System.out.println(branches.size());
//        }
//    }
}
