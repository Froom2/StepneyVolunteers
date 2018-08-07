package controllers.arrival

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.TimeService
import play.api.test.CSRFTokenHelper._

class ArrivalControllerSpec extends PlaySpec with GuiceOneAppPerTest with PropertyChecks {

  def controller = new ArrivalController(stubControllerComponents())

  "ArrivalMonthController" when {

    "arrivalMonth is called" must {
      "respond with OK" in {
        val result = controller.arrivalMonth().apply(FakeRequest(GET, "/").withCSRFToken)
        status(result) mustBe OK
        contentType(result) mustBe Some("text/html")
      }
    }
    "selectArrivalMonth is called" must {
      "respond with SEE_OTHER" in {
        val monthGenerator = Gen.oneOf(TimeService.months)
        forAll(monthGenerator) {
          month =>
            val result = controller.selectArrivalMonth(month).apply(FakeRequest(POST, "/").withCSRFToken)
            status(result) mustBe SEE_OTHER
            redirectLocation(result) mustBe Some(controllers.arrival.routes.ArrivalController.arrivalDay(month).url)
        }
      }
    }

    "arrivalDay is called" must {
      "respond with OK" in {
        val monthGenerator = Gen.oneOf(TimeService.months)
        forAll(monthGenerator) {
          month =>
            val result = controller.arrivalDay(month).apply(FakeRequest(GET, "/").withCSRFToken)
            status(result) mustBe OK
            contentType(result) mustBe Some("text/html")
        }
      }
    }
    "selectArrivalDay is called" must {
      "respond with SEE_OTHER" in {
        val dayGenerator = Gen.oneOf(1 to 31)
        forAll(dayGenerator) {
          day =>
            val result = controller.selectArrivalDay(day).apply(FakeRequest(POST, "/").withCSRFToken)
            status(result) mustBe SEE_OTHER
            redirectLocation(result) mustBe Some(controllers.arrival.routes.ArrivalController.arrivalPurpose.url)
        }
      }
    }

    "arrivalPurpose is called" must {
      "respond with OK" in {
        val result = controller.arrivalPurpose().apply(FakeRequest(GET, "/").withCSRFToken)
        status(result) mustBe OK
        contentType(result) mustBe Some("text/html")
      }
    }
  }
}
