package common

import java.time.LocalDate

object Example {
  def exampleBond: Bond =
    Bond(
      SecurityId("foobar123456"),
      USD,
      100.0,
      Coupon(Fixed, 0.03, SemiAnnual),
      Issue(
        Issuer(
          IssuerId("bazqux987654"), "Best Bank Ever", Saint_Vincent_and_the_Grenadines),
        LocalDate.of(2020, 1, 1)
      ),
      LocalDate.of(3020, 1, 1)
    )
}
