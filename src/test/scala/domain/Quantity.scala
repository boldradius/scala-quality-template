package domain

import org.scalactic._
import TripleEquals._

import org.scalatest.FreeSpec

class QuantityTest extends FreeSpec {
  "a quantity" - {
    "equals another identical quantity" in {
      assert(Quantity(5) === Quantity(5))
    }
    "may not be negative" in {
      //We could use an intercept here, but Wart remover won't allow it (Statement must return Unit)
      try {
        new Quantity(-1)
        fail("Should have thrown")
      } catch {
        case ie: IllegalArgumentException => {}
      }
    }
  }
}
