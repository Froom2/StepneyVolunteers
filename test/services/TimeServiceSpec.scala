package services

import org.joda.time.YearMonth
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

}
