package monocle_example

import common._
import monocle.macros.GenLens
import common.Example.exampleBond

object MonocleExample {

  // Atomic lenses
  private val bondIssue = GenLens[Bond](_.issue)
  private val issuerFromIssue = GenLens[Issue](_.issuer)
  private val idFromIssuer = GenLens[Issuer](_.issuerId.id)

  // Composite
  private val bondIssuerId = bondIssue composeLens issuerFromIssue composeLens idFromIssuer

  def run(): Unit = {
    val testBond = exampleBond

    // Get issuer id string from a bond
    val issuerId: String = bondIssuerId.get(testBond)

    // Update the issuer id's string component
    val updatedBond = bondIssuerId.set("garply123456")(testBond)

    // Retrieve the new issued id
    val newIssuerId = bondIssuerId.get(updatedBond)

    assert(issuerId == "bazqux987654")
    assert(newIssuerId == "garply123456")
  }

}
