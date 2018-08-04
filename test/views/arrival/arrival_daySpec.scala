package views.arrival

import org.jsoup.Jsoup
import org.scalatestplus.play.PlaySpec
import services.TimeService
import testUtil.TestHelpers.checkElement


class arrival_daySpec extends PlaySpec {

  "arrival_day view" should {
    "contain correct content" in {

      def checkDayView(month: String) = {
        val days = TimeService.daysInMonth(month)
        val view = Jsoup.parse(views.html.arrival.arrival_day(
          days, month).toString)

        checkElement(view, "h1", 1, "What day were you born on?")
        checkElement(view, "button", days.max, "1 2 3 4")
      }

      checkDayView("January")
      checkDayView("February")
      checkDayView("March")
      checkDayView("April")
      checkDayView("May")
      checkDayView("June")
      checkDayView("July")
      checkDayView("August")
      checkDayView("September")
      checkDayView("October")
      checkDayView("November")
      checkDayView("December")

    }
  }

}
