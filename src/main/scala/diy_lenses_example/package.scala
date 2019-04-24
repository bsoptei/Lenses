package object diy_lenses_example {

  final case class Lens[A, B](get: A => B, set: (A, B) => A)

  implicit class LensOps[Outer, Inner](outer: Lens[Outer, Inner]) {
    def composeLens[Value](inner: Lens[Inner, Value]): Lens[Outer, Value] = Lens[Outer, Value](
      get = outer.get andThen inner.get,
      set = (obj, value) => outer.set(obj, inner.set(outer.get(obj), value))
    )
  }

  // Lens laws

  // Identity 
  def getSet[S, A](lens: Lens[S, A], s: S): Boolean = lens.set(s, lens.get(s)) == s

  // Retention 
  def setGet[S, A](lens: Lens[S, A], s: S, a: A): Boolean = lens.get(lens.set(s, a)) == a

  // Double set 
  def putPut[S, A](lens: Lens[S, A], s: S, a: A, b: A): Boolean = lens.get(lens.set(lens.set(s, a), b)) == b

}
