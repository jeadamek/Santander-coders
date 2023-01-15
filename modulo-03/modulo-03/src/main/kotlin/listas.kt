data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(
    var head: Node<T>? = null
) {
    private var lastNode: Node<T>? = null

    fun addFirst(value:T) {
        val newNode = Node(value = value, null)
        newNode.next = head
        head = newNode
    }

    fun addLast(value: T) {
        val newNode = Node(value = value, null)

        if (head == null) {
            head = newNode
            lastNode = newNode
            return
        } else {
            val current = lastNode
            current?.next = newNode
            lastNode = newNode
        }
    }

    fun remove(value: T): Boolean {
        if (head?.value == value) {
            head = head?.next
            return true
        }
        var current = head?.next
        var previous = head

        while(current != null && current.value != value) {
            previous = current
            current = current.next
        }

        if (current != null) {
            previous?.next = current.next
            return true
        }

        return false
    }

    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }

        while(current != null) {
            println(current.value)
            current = current.next
        }
    }

    fun find(value:T): Boolean{
        if (head?.value == value) {
            return true
        }

        var current = head?.next

        while (current != null){
            if(current.value == value){
                return true
            }

            current = current.next
        }

        return false
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}
