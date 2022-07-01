
import main.scala.com.h2.entities._
import java.time.localDate
import java.util.UUID

object BankOfScala{
  def main(args: Array[String]): Unit = {
    println("Instantiating Bank")

    val coreChecking = new CoreChecking(bal = 1000, rate= 0.025)
    val studentCheckings = new Student Checkings(bal = 0, rate = 0.010)
    val rewardsSaving = new RewardsSavings(bal = 10000, rate = 0.10, trans = 1)
    val creditCard = new CreditCard(fee = 99.00, rate = 14.23, pct= 20.00)
    val products = Set(coreChecking, studentCheckings, rewardsSaving, creditCard)

    val bobMartin = new Customer("Bob", "Martin", "bob@martin.com",
      LocalDate.of(year = 1983, month= 8, dayOfMonth=22 ))
    val bobCheckingAccount = new Account(bobMartin, coreChecking, 1000)
    val bobSavingsAccount = new Account(bobMartin, rewardsSaving, 20000)
    val bobCreditAccount = new Account(bobMartin, creditCard, 4500)
    val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)

    val bank = new Bank("Bank of Scala", "Auckland", co= "New Zealand", "bank@scala.com", products, Set(bobMartin), accounts)



    println(bobCheckingAccount)

    bobCheckingAccount.deposit(amount = 100)
    println(bobCheckingAccount)

    bobCheckingAccount.withdraw(amounty = 200)
    println(bobCheckingAccount)
  }
}




