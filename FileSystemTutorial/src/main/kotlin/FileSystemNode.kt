interface FileSystemNode {
    fun getNodeParent(): FileSystemNode?
    fun getNodePath(): String?
    fun getNodeName(): String?
    fun setNodeParent(newParent: FileSystemNode?)
    fun getNodeExtension(): String?
}