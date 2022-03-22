package com.testts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class AbstractFileSystemNode implements FileSystemNode{
    FileSystemNode parent = null;
    String name = null;

    @Override
    public final FileSystemNode getParent() {
        return parent;
    };

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getPath() {
        FileSystemNode ancestor = this;
        ArrayList<String> folders = new ArrayList<String>();
        do {
            ancestor = ancestor.getParent();
            folders.add(ancestor.getName());
        } while (ancestor.getParent() != null);
        Collections.reverse(folders);
        return folders.stream().collect(
                Collectors.joining("/"));
    }

    @Override
    public void setParent(FileSystemNode newParent) {
        this.parent = newParent;
    }

    @Override
    public String getExtension() {
        String[] filenameParts = this.name.split("\\.");
        return filenameParts.length > 1 ? filenameParts[1] : filenameParts[0];
    }
}
