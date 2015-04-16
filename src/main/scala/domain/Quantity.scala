package domain

case class Quantity(i: Int) {
  require(i >= 0, "Quantity must be positive or zero")
}
