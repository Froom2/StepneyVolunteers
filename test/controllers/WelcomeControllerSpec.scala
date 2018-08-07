package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  def controller = new WelcomeController(stubControllerComponents())

  "welcome" should {
    "respond with OK" in {

      val request = FakeRequest(GET, "/welcome")
      val result = controller.welcome().apply(FakeRequest(GET, "/"))

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("Welcome!")
    }
  }

  "thankyou" should {
    "respond with OK" in {

      val request = FakeRequest(GET, "/thankyou")
      val result = controller.thankyou().apply(FakeRequest(GET, "/"))

      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      contentAsString(result) must include ("Thank you for signing in!")
    }
  }

}
