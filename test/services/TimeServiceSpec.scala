package services

import org.joda.time.YearMonth
import org.scalacheck.Gen
import org.scalatestplus.play.PlaySpec

class TimeServiceSpec extends PlaySpec {

  "months" should {
    "Return a list of month names" in {

      TimeService.months mustEqual Seq(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
      )
    }
  }

  "daysInMonth" should {
    "return a list of day numbers for any given month" in {
      TimeService.daysInMonth("January") mustEqual (1 to 31).toList
      TimeService.daysInMonth("February") mustEqual (1 to 29).toList
      TimeService.daysInMonth("March") mustEqual (1 to 31).toList
      TimeService.daysInMonth("April") mustEqual (1 to 30).toList
      TimeService.daysInMonth("May") mustEqual (1 to 31).toList
      TimeService.daysInMonth("June") mustEqual (1 to 30).toList
      TimeService.daysInMonth("July") mustEqual (1 to 31).toList
      TimeService.daysInMonth("August") mustEqual (1 to 31).toList
      TimeService.daysInMonth("September") mustEqual (1 to 30).toList
      TimeService.daysInMonth("October") mustEqual (1 to 31).toList
      TimeService.daysInMonth("November") mustEqual (1 to 30).toList
      TimeService.daysInMonth("December") mustEqual (1 to 31).toList
    }
  }

}
