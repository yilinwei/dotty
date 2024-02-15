object Test:

  def main(args: Array[String]): Unit =
    val r1 = R1("asd", 2)
    val R1(s, _) = r1
    println(s)
    // r match:
    //   case R1(s) => s
