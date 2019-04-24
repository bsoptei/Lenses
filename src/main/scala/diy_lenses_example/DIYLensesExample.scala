package diy_lenses_example

import common._
import common.Example.exampleBond

object DIYLensesExample {

  // Atomic lenses
  private val bondIssue = Lens[Bond, Issue](_.issue, (bond, issue) => bond.copy(issue = issue))
  private val issuerFromIssue = Lens[Issue, Issuer](_.issuer, (issue, issuer) => issue.copy(issuer = issuer))
  private val idFromIssuer = Lens[Issuer, String](_.issuerId.id, (issuer, id) => issuer.copy(issuerId = IssuerId(id)))

  // Composite
  private val bondIssuerId = bondIssue composeLens issuerFromIssue composeLens idFromIssuer

  def run(): Unit = {
    val testBond = exampleBond

    // Get issuer id string from a bond
    val issuerId: String = bondIssuerId.get(testBond)

    // Update the issuer id's string component
    val updatedBond = bondIssuerId.set(testBond, "garply123456")

    // Retrieve the new issued id
    val newIssuerId = bondIssuerId.get(updatedBond)

    assert(issuerId == "bazqux987654")
    assert(newIssuerId == "garply123456")
  }

}
