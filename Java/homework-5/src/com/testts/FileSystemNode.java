package com.testts;

public interface FileSystemNode {
    FileSystemNode getParent();
    String getPath();
    String getName();
    void setParent(FileSystemNode newParent);
    String getExtension();
}
