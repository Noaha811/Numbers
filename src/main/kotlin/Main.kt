//Noah Anderson

//importing DecimalFormat class for formatting numbers
import java.text.DecimalFormat

fun main() {
    //initializes necessary variables
    val taxRate = .025
    val tipRate = .175
    var userInput: Double
    var total = 0.0
    val twoDigits = DecimalFormat("$###,###,###.00")
    var totalStr = twoDigits.format(total)

    //loop that allows user to endlessly add items until they are finished
    while(true){
        println("The total cost so far is $totalStr")

        //try-catch statement to validate user input
        try{
            println("Please enter the dollar-cost value of the next item, or enter 0 to exit and add up the total: ")
            userInput = readLine()!!.toDouble()
            //ends the loop if value is equal to 0
            if(userInput == 0.0){
                break
            }
            //discards user input if less than 0
            if(userInput < 0.0){
                println("Error: value less than 0, please enter a positive number")
            }
            else {
                total+=userInput
                totalStr = twoDigits.format(total)
            }
        }
        catch(e: Exception){
            println("Invalid input! Value must be numerical")
        }
    }

    //calculates and prints out each total cost, with tax, without tax, and with tax+tip
    val tipTotal = total*tipRate
    val tipTotalStr = twoDigits.format(tipTotal)
    println("Total: $totalStr")
    total += total * taxRate
    totalStr = twoDigits.format(total)
    println("Total with tax: $totalStr")
    println("Suggested tip of 17.5%: $tipTotalStr")
    total+=tipTotal
    totalStr = twoDigits.format(total)
    println("Overall total with tip: $totalStr")

}