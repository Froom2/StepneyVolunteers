package views

import org.jsoup.Jsoup
import org.scalatestplus.play.PlaySpec
import testUtil.TestHelpers.checkElement

class welcomeSpec extends PlaySpec {

  "welcome view" should {
    "contain correct content" in {

      val view = Jsoup.parse(views.html.welcome().toString)

      checkElement(view, "h1", 1, "Welcome!")
      checkElement(view, "h2", 1, "Never visited before?")
      checkElement(view, "p", 1, "Please go to reception, where we will be happy to welcome you.")
      checkElement(view, "button", 2, "I'm arriving I'm leaving")

    }
  }

}
