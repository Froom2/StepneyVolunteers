package views.arrival

import models.{JustVisiting, Riding, Volunteering}
import org.jsoup.Jsoup
import org.scalatestplus.play.PlaySpec
import play.api.test.FakeRequest
import services.TimeService
import testUtil.TestHelpers.checkElement
import play.api.test.CSRFTokenHelper._

class arrival_purposeSpec extends PlaySpec {

  "arrival_month view" should {
    "contain correct content" in {

      val purposes = Seq(Volunteering, Riding, JustVisiting)

      val view = Jsoup.parse(views.html.arrival.arrival_purpose()(FakeRequest().withCSRFToken).toString)

      checkElement(view, "h1", 1, "Why are you visiting today?")
      checkElement(view, "button", 3, purposes mkString " ")

    }
  }
}
