package vanilla_example

import common._
import common.Example.exampleBond

object VanillaExample {

  // No lenses at all

  def run(): Unit = {
    val testBond = exampleBond

    // Get issuer id string from a bond
    val issuerId: String = testBond.issue.issuer.issuerId.id

    // Update the issuer id's string component
    val updatedBond = testBond.copy(
      issue = testBond.issue.copy(
        issuer = testBond.issue.issuer.copy(
          issuerId = IssuerId("garply123456")
        )
      )
    )

    // Retrieve the new issued id
    val newIssuerId = updatedBond.issue.issuer.issuerId.id

    assert(issuerId == "bazqux987654")
    assert(newIssuerId == "garply123456")
  }

}
