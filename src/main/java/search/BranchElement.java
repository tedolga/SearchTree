package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class BranchElement {
    private List<BranchElement> children = new ArrayList<BranchElement>();
    private BranchElement parent;
    private Phrase value;

    public BranchElement(BranchElement parent) {
        this.parent = parent;
        if (parent != null) {
            parent.getChildren().add(this);
        }
    }

    public List<BranchElement> getChildren() {
        return children;
    }

    public void setChildren(List<BranchElement> children) {
        this.children = children;
    }

    public BranchElement getParent() {
        return parent;
    }

    public void setParent(BranchElement parent) {
        this.parent = parent;
    }

    public Phrase getValue() {
        return value;
    }

    public void setValue(Phrase value) {
        this.value = value;
    }
}
