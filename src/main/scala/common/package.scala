import java.time.LocalDate

package object common {

  final case class Bond(
                         securityId: SecurityId,
                         currency: Currency,
                         parValue: Double,
                         coupon: Coupon,
                         issue: Issue,
                         maturity: LocalDate
                       )

  final case class SecurityId(id: String)

  final case class Coupon(
                           couponType: CouponType,
                           couponValue: Double,
                           paymentFrequency: PaymentFrequency
                         )

  final case class Issue(issuer: Issuer, issueDate: LocalDate)

  final case class Issuer(issuerId: IssuerId, name: String, country: Country)

  final case class IssuerId(id: String)

}
