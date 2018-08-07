package views

import models.VisitPurpose.{JustVisiting, Riding, Volunteering}
import org.jsoup.Jsoup
import org.scalatestplus.play.PlaySpec
import play.api.test.FakeRequest
import testUtil.TestHelpers.checkElement

class thankyouSpec extends PlaySpec {

  "arrival_month view" should {
    "contain correct content" in {

      val purposes = Seq(Volunteering, Riding, JustVisiting)

      val view = Jsoup.parse(views.html.thankyou().toString())

      checkElement(view, "h1", 1, "Thank you for signing in!")

    }
  }
}
