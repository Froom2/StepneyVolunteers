package views.arrival

import org.jsoup.Jsoup
import org.scalatestplus.play.PlaySpec
import services.TimeService
import testUtil.TestHelpers.checkElement


class arrival_monthSpec extends PlaySpec {

  "arrival_month view" should {
    "contain correct content" in {

      val months = TimeService.months

      val view = Jsoup.parse(views.html.arrival.arrival_month(months).toString)

      checkElement(view, "h1", 1, "What month were you born in?")
      checkElement(view, "button", 12, months mkString " ")

    }
  }

}
