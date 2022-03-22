package com.testts;

import java.util.ArrayList;

public class Folder extends AbstractFileSystemNode {
    ArrayList<FileSystemNode> childrenList = new ArrayList<FileSystemNode>();
    public Folder(String name, FileSystemNode ... childNodes) {
        this.name = name;
        addChildren(childNodes);
    }

    public void addChildren(FileSystemNode ... childNodes) {
        for(int i=0; i < childNodes.length; i++) {
            FileSystemNode children = childNodes[i];
            children.setParent(this);
            childrenList.add(children);
        }
    }

    public ArrayList<FileSystemNode> getChildren() {
        return childrenList;
    }
}
