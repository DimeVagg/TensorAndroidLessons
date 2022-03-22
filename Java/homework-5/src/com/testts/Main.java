package com.testts;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // создаем корневую папку
        Folder folder = new Folder("Root");
        // создаем 3 папки с файлами
        Folder folder1 = new Folder("Folder1");
        folder1.addChildren(new File("filename1.txt"),
                            new File("filename2.pdf"));
        Folder folder2 = new Folder("Folder2");
        folder2.addChildren(new File("filename3.bin"),
                            new File("filename4.doc"),
                            new File("filename5.tar"),
                            new File("filename6.dmg"));
        Folder folder3 = new Folder("Folder3");
        folder3.addChildren(new File("filename7.exe"),
                            new File("filename8.com"));
        // 3-ю помещаем во 2-ю
        folder2.addChildren(folder3);
        // помещаем все в корневую папку
        folder.addChildren(folder1, folder2);

        // возьмем filename7 из 3-й папки и выведем путь до него
        FileSystemNode filename7 = folder3.getChildren().get(0);
        String filePath = filename7.getPath();
        System.out.println(filename7.getPath());
        // возьмем filename6 из 2-й папки и выведем его расширение
        FileSystemNode filename6 = folder2.getChildren().get(3);
        System.out.println(filename6.getExtension());

    }
}
