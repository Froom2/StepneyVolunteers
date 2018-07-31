package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  def controller = new WelcomeController(stubControllerComponents())

  "WelcomeController" should {
    "respond with OK" in {

      val request = FakeRequest(GET, "/welcome")
      val home = controller.welcome().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Welcome!")
    }
  }

}
