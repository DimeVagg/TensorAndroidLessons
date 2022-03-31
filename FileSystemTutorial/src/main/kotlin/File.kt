class File(filename: String) : AbstractFileSystemNode() {
    init {
        super.name = filename
    }
}