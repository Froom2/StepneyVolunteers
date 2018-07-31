package controllers.arrival

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._

class ArrivalMonthControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  def controller = new ArrivalMonthController(stubControllerComponents())

  "ArrivalMonthController" must {
    "respond with OK" in {

      val request = FakeRequest(GET, "/arrival-month")
      val home = controller.arrivalMonth().apply(FakeRequest(GET, "/"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")

    }
  }

}
