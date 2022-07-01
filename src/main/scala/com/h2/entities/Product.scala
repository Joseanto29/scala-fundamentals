package main.scala.com.h2.entities

import java.util.UUID

sealed trait ProductCategory
case object DepositsP extends ProductCategory
case object LendingP extends ProductCategory

abstract class Product {
  val id: UUID = UUID.randomUUID()
  val category: ProductCategory
  val name: String

  override def toString: String = "product=" + name
}

/* --------------------- Deposits Products -------------------- */
abstract class Deposits extends Product {
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Int
}

abstract class Checkings extends Deposits

abstract class Savings extends Deposits {
  val transactionsAllowedPerMonth: Int
}

/* ------ Checkings Products ------ */
class CoreChecking(bal: Int, rate: Double) extends Checkings {
  println("Created Core Checking Product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Student Checking"
}

class StudentChecking(bal: Int, rate: Double) extends Checkings {
  println("Created Student Checking Product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Student Checking"
}

/* ------ Savings Products ------ */
class RewardsSavings(val minimumBalancePerMonth: Dollars,
                     val interestRatePerYear: Double,
                     val transactionsAllowedPerMonth: Int) extends Savings {
  println("Created Rewards Savings Product")
  override val name: String = "Rewards Savings"
}


/* --------------------- Lending Products -------------------- */
abstract class Lending extends Product {
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(fee: Double, rate: Double, pct: Double) extends Lending{
  println("Created Credit Card Product")
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardsPercent: Double = pct
  override val name: String = "Credit Card"
}