
abstract class IyteImmutableSet {
  def add(x: Int): IyteImmutableSet = this match {
    case Empty => new NonEmpty(x, Empty, Empty)
    case NonEmpty(head, left, right) => {
      if (x > head) new NonEmpty(head, left, right.add(x))
      else if (x < head) new NonEmpty(head, left.add(x), right)
      else this
    }
  }

  def contains(x: Int): Boolean = this match {
    case Empty => false
    case NonEmpty(head, left, right) =>
      if (head > x) left.contains(x)
      else if (head < x) right.contains(x)
      else true
  }

  override def toString: String = this match {
    case Empty => ""
    case NonEmpty(head, left, right) =>
      var str = new String
      var first = true
      def traverse(branch: IyteImmutableSet): Unit = branch match {
        case Empty => return
        case NonEmpty(head, left, right) =>
          traverse(left)
          if (first) first = false else str = str + ","
          str = str + head
          traverse(right)
      }
      traverse(this)
      str
  }
}

case class NonEmpty(head: Int, left: IyteImmutableSet, right: IyteImmutableSet) extends IyteImmutableSet
case object Empty extends IyteImmutableSet

object IyteImmutableSet {
  def apply() = Empty
}