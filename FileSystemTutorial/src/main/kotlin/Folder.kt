import java.util.ArrayList

class Folder(name: String, vararg childNodes: FileSystemNode) : AbstractFileSystemNode() {
    var childrenList = ArrayList<FileSystemNode>()

    fun addChildren(vararg childNodes: FileSystemNode) {
        for (i in 0 until childNodes.size) {
            val children = childNodes[i]
            children.setNodeParent(this)
            childrenList.add(children)
        }
    }

    fun searchFile(name: String): File? {
        // не самый лучший вариант поиска, но всё же
        var result: File? = null
        for (node in childrenList) {
            if (node is File) {
                if (node.getNodeName() !== name) continue
                result = node
                break
            }
            val recursive = node as Folder
            result = recursive.searchFile(name)
            if (result != null) break
        }
        return result
    }

    init {
        this.name = name
        addChildren(*childNodes)
    }
}