package foo

trait Profunctor[F[_, _]]
trait Cartesian[F[_, _]] extends Profunctor[F]
trait Cocartesian[F[_, _]] extends Profunctor[F]

case class Optic[-C[_[_, _]], -S, +T, +A, -B]() {
  def <<<[U, V, C1[F[_, _]] <: C[F]](other: Optic[C1, U, V, S, T]): Optic[C1, U, V, A, B] = ???
}

type Lens[-S, +T, +A, -B] = Optic[Cartesian, S, T, A, B]
type Prism[-S, +T, +A, -B] = Optic[Cocartesian, S, T, A, B]
type Optional[-S, +T, +A, -B] = Optic[[F[_, _]] =>> Cartesian[F] & Cocartesian[F], S, T, A, B]

type MLens[S, A] = Optic[Cartesian, S, S, A, A]
type MPrism[S, A] = Optic[Cocartesian, S, S, A, A]
type MOptional[S, A] = Optic[[F[_, _]] =>> Cartesian[F] & Cocartesian[F], S, S, A, A]

val lens: MLens[String, String] = ???
val prism: MPrism[String, Int] = ???

val what: MOptional[String, Int] = prism <<< lens
