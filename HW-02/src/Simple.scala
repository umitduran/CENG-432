

object Simple {
    def myNewArray(callback: () => Unit) {
    callback(); Thread.sleep(1000)
  }


  def changeMyArray() {

    var myList = Array(10,25,30)
    for (i <- 0 to 2) {
      if (myList(i) % 2 == 0){
        println(myList(i) * 2)
      }else
        println((myList(i) * 3))
    }
  }

  def main(args: Array[String]) {
    myNewArray(changeMyArray)
  }
}