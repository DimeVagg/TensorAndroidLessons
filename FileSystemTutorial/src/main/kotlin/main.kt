fun main(args: Array<String>) {
    val folder = Folder(
        "Root",
        Folder(
            "Folder1",
            File("filename1.txt"),
            File("filename2.pdf")
        ),
        Folder(
            "Folder2",
            File("filename3.bin"),
            File("filename4.doc"),
            File("filename5.tar"),
            File("filename6.dmg"),
            Folder(
                "Folder3",
                File("filename7.exe"),
                File("filename8.com")
            )
        )
    )
    // найдем файл filename8.com, вернем путь до него и его расширение
    // найдем файл filename8.com, вернем путь до него и его расширение
    val foundFile: File? = folder.searchFile("filename8.com")
    if (foundFile == null) {
        println("Файл не найден")
        return
    }
    println(foundFile.getNodePath())
    println(foundFile.getNodeExtension())
}