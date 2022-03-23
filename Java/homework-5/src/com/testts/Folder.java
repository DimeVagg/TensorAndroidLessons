package com.dimevagg.homework5;

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

    public File searchFile(String name) {
        // не самый лучший вариант поиска, но всё же
        File result = null;
        for(FileSystemNode node: this.getChildren()){
            if(node instanceof File) {
                if(node.getName() != name)
                    continue;
                result = (File)node;
                break;
            }
            Folder recursive = (Folder)node;
            result = recursive.searchFile(name);
            if(result != null)
                break;
        }
        return result;
    }
}
