class IyteMutableSet {
  var head: Int = 0
  var left: IyteMutableSet = null
  var right: IyteMutableSet = null
  var empty = true

  def this(value: Int) = {
    this()
    head = value
    empty = false
  }

  def add(newValue: Int): Unit = {
    if (empty) {
      head = newValue
      empty = false
    } else {
      if (newValue < this.head && left == null) {
        this.left = new IyteMutableSet(newValue)
        //        this.left.empty = false
      } else if (newValue > this.head && right == null) {
        this.right = new IyteMutableSet(newValue)
        //        this.right.empty = false
      } else if (newValue > this.head) right.add(newValue)
      else if (newValue < this.head) left.add(newValue)
    }
  }

  def contains(x: Int): Boolean = {
    if (empty) false
    else {
      if (x == head) true
      else if (x > head && right != null) right.contains(x)
      else if (x < head && left != null) left.contains(x)
      else false
    }
  }

  override def toString: String = {
    if (empty) ""
    else {
      var str = new String()
      var first = true
      def traverse(tree: IyteMutableSet): Unit = {
        if (tree.left != null) traverse(tree.left)
        if (first) first = false else str = str + ","
        str = str + tree.head
        if (tree.right != null) traverse(tree.right)
      }
      traverse(this)
      str
    }
  }
}

object IyteMutableSet {
  def apply() = new IyteMutableSet()
}