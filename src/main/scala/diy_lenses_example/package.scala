package object diy_lenses_example {

  final case class Lens[A, B](get: A => B, set: (A, B) => A)

  implicit class LensOps[Outer, Inner](outer: Lens[Outer, Inner]) {
    def composeLens[Value](inner: Lens[Inner, Value]): Lens[Outer, Value] = Lens[Outer, Value](
      get = outer.get andThen inner.get,
      set = (obj, value) => outer.set(obj, inner.set(outer.get(obj), value))
    )
  }

}
