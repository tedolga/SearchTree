package search;

import java.util.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchString = scanner.nextLine();
        List<String> phraseTail = Arrays.asList(searchString.split(" "));
        Phrase phrase = new Phrase();
        phrase.setTail(copyList(phraseTail));
        BranchElement root = new BranchElement(null);
        root.setValue(phrase);
        generateBranches(root);
        LinkedList<String> branches = receiveChains(root);
        System.out.println();
    }

    public static BranchElement generateBranches(BranchElement root) {
        List<BranchElement> leaves = receiveLeaves(root);
        while (!checkLeaves(leaves)) {
            for (BranchElement leave : leaves) {
                LinkedList<String> tail = copyList(leave.getValue().getTail());
                LinkedList<String> newTail = new LinkedList<String>();
                final int tailSize = tail.size();
                for (int i = 0; i < tailSize; i++) {
                    BranchElement newChild = new BranchElement(leave);
                    Phrase childPhrase = new Phrase();
                    childPhrase.setBody(copyList(tail));
                    childPhrase.setTail(copyList(newTail));
                    newTail.addFirst(tail.removeLast());
                    newChild.setValue(childPhrase);
                }
            }
            leaves = receiveLeaves(root);
        }
        return root;
    }

    /**
     * This method returns all the leaves of element
     *
     * @param element which leaves you want to get
     * @return list of leaves
     */
    public static List<BranchElement> receiveLeaves(BranchElement element) {
        List<BranchElement> leaves = new ArrayList<BranchElement>();
        List<BranchElement> children = element.getChildren();
        if (children.size() > 0) {
            for (BranchElement childElement : children) {
                if (childElement.getChildren().size() > 0) {
                    children = receiveLeaves(childElement);
                    for (BranchElement child : children) {
                        leaves.add(child);
                    }
                } else {
                    leaves.add(childElement);
                }
            }
        } else {
            leaves.add(element);
        }
        return leaves;
    }

    /**
     * This method checks, if branch processing is completed (all leaves values haven't tails)
     *
     * @param leaves leaves of a branch
     * @return true in case of all leaves values haven't tails, false - in other case
     */
    public static boolean checkLeaves(List<BranchElement> leaves) {
        boolean isCompleted = true;
        for (BranchElement leave : leaves) {
            if (leave.getValue().getTail().size() > 0) {
                isCompleted = false;
            }
        }
        return isCompleted;
    }


    public static LinkedList<String> copyList(List<String> list) {
        LinkedList<String> newList = new LinkedList<String>();
        for (String next : list) {
            newList.add(next);
        }
        return newList;
    }

    public static LinkedList<String> receiveChains(BranchElement tree) {
        LinkedList<String> result = new LinkedList<String>();
        List<BranchElement> leaves = BranchGenerator.receiveLeaves(tree);
        StringBuilder builder = new StringBuilder();
        for (BranchElement leave : leaves) {
            builder.append(leave.getValue().getBody().toString());
            BranchElement parent = leave.getParent();
            while (parent != null) {
                builder.append(parent.getValue().getBody().toString());
                parent = parent.getParent();
            }
            result.addFirst(builder.toString());
            builder.setLength(0);
        }
        return result;
    }


}
