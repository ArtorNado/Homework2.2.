package Node;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Tree {
    @XmlElement(name = "node")
    KnotNode root;

    public KnotNode getRoot() {
        return root;
    }

    @XmlRootElement(name = "root")
    @XmlAccessorType(XmlAccessType.FIELD)
    @JsonIgnoreProperties({"parentReference"})
    public static class KnotNode {
        @XmlElement(name = "title")
        private String title;
        @XmlTransient
        private KnotNode parentReference;
        @XmlElement(name = "childrenList")
        private ArrayList<KnotNode> childrenList;
        @XmlElement(name = "type")
        private Type type;
        @XmlElement(name = "priority")
        private Integer priority;

        private KnotNode() {
        }

        public KnotNode(String title, KnotNode parentReference, ArrayList<KnotNode> childrenList, Type type, Integer priority) {
            this.title = title;
            this.parentReference = parentReference;
            this.childrenList = childrenList;
            this.type = type;
            this.priority = priority;
        }

        public void deleteChildren(KnotNode children) {
            this.childrenList.remove(children);
            children.parentReference = null;
        }

        public String getTitle() {
            return title;
        }

        public static Builder newBuilder() {
            return new KnotNode().new Builder();
        }

        public KnotNode getParentReference() {
            return parentReference;
        }

        public ArrayList<KnotNode> getChildrenList() {
            return childrenList;
        }

        public Type getType() {
            return type;
        }

        public Integer getPriority() {
            return priority;
        }

        public class Builder {

            private Builder() {

            }

            public Builder setParentReference(KnotNode parentReference) {
                KnotNode.this.parentReference = parentReference;
                return this;
            }

            public Builder setChildrenList(ArrayList<KnotNode> childrenList) {
                KnotNode.this.childrenList = childrenList;
                return this;
            }

            public Builder setTitle(String title) {
                KnotNode.this.title = title;
                return this;
            }

            public Builder setType(Type type) {
                KnotNode.this.type = type;
                return this;
            }

            public Builder setPriority(Integer priority) {
                KnotNode.this.priority = priority;
                return this;
            }

            public KnotNode build() {
                return KnotNode.this;
            }
        }

    }
}
