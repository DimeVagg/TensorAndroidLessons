
import java.util.stream.Collectors

import java.util.Collections

import java.util.ArrayList


abstract class AbstractFileSystemNode() : FileSystemNode {
    var parent: FileSystemNode? = null
    var name: String? = null

    override fun getNodeParent(): FileSystemNode? {
        return parent
    }

    override fun getNodeName(): String? {
        return name
    }

    override fun getNodePath(): String? {
        var ancestor: FileSystemNode? = this
        val folders = ArrayList<String?>()
        do {
            ancestor = ancestor!!.getNodeParent()
            folders.add(ancestor!!.getNodeName())
        } while (ancestor!!.getNodeParent() != null)
        Collections.reverse(folders)
        return folders.stream().collect(
            Collectors.joining("/")
        )
    }

    override fun setNodeParent(newParent: FileSystemNode?) {
        parent = newParent
    }

    override fun getNodeExtension(): String? {
        val filenameParts = name!!.split("\\.").toTypedArray()
        return if (filenameParts.size > 1) filenameParts[1] else filenameParts[0]
    }
}