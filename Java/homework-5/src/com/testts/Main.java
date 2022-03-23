package com.dimevagg.homework5;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // создаем корневую папку
        Folder folder = new Folder("Root",
                            new Folder("Folder1",
                                new File("filename1.txt"),
                                new File("filename2.pdf")),
                            new Folder("Folder2",
                                new File("filename3.bin"),
                                new File("filename4.doc"),
                                new File("filename5.tar"),
                                new File("filename6.dmg"),
                                new Folder("Folder3",
                                        new File("filename7.exe"),
                                        new File("filename8.com"))));
        // найдем файл filename6.dmg, вернем путь до него и его расширение
        File foundFile = folder.searchFile("filename81.com");
        if( foundFile == null ) {
            System.out.println("Файл не найден");
            return;
        }
        System.out.println(foundFile.getPath());
        System.out.println(foundFile.getExtension());
    }
}
