trait :<:[A, B] {

}



given left[A, B]: (A :<: Either[A, B]) = ???
given right[A, B]: (B :<: Either[A, B]) = ???

given transitivity[A, B, C](using ab: A :<: B, bc: B <:< C): (A :<: C) = ???

object Moo {
  val x = summon[Int :<: Either[String, Either[Boolean, Int]]]
}

