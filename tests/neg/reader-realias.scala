type Id[A] = A

case class ReaderT[F[_], A, B](run: A => F[B]) {
  def flatMap[BB](f: B => ReaderT[F, A, BB]): ReaderT[F, B, BB] = ???
}

type Reader[A, B] = ReaderT[Id, A, B]

object Reader {
  def apply[A, B](f: A => B): Reader[A, B] = ReaderT(f)
}

val provided: ReaderT[Id, String, String] = ???
val problem = Reader[Int, String](_.toString).flatMap(_ => provided)
