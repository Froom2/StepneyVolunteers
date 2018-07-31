package services

import org.joda.time.{LocalDate, YearMonth}

import scala.collection.immutable

object TimeService {

  def months: Seq[String] = {
    val monthNumbers = 1 to 12
    val thisYear = new LocalDate().getYear
    monthNumbers.map(i => new YearMonth(thisYear, i).monthOfYear().getAsText)
  }

}
