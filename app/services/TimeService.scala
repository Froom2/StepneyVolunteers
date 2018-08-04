package services

import org.joda.time.format.DateTimeFormat
import org.joda.time.{LocalDate, Months, YearMonth}
import java.time.Month

object TimeService {

  def months: Seq[String] = {
    val monthNumbers = 1 to 12
    val thisYear = new LocalDate().getYear
    monthNumbers.map(i => new YearMonth(thisYear, i).monthOfYear().getAsText)
  }


  def daysInMonth(month: String): Seq[Int] = {

    val monthFormatter = DateTimeFormat.forPattern("MMMM")
    val monthNumber = monthFormatter.parseDateTime(month).getMonthOfYear
    val maxDays = Month.of(monthNumber).maxLength()

    (1 to maxDays).toList
  }

}
