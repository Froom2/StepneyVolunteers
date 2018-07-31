package controllers.arrival

import org.scalatest.Matchers
import org.scalatest.prop.PropertyChecks
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers._
import org.scalacheck.Gen
import org.scalacheck.Arbitrary.arbitrary
import services.TimeService

class ArrivalMonthControllerSpec extends PlaySpec with GuiceOneAppPerTest with PropertyChecks {

  def controller = new ArrivalMonthController(stubControllerComponents())

  "ArrivalMonthController" when {
    "arrivalMonth is called" must {
      "respond with OK" in {

        val result = controller.arrivalMonth().apply(FakeRequest(GET, "/"))

        status(result) mustBe OK
        contentType(result) mustBe Some("text/html")

      }
    }

    "selectMonth is called" must {
      "respond with SEE_OTHER" in {

        val monthGenerator = Gen.oneOf(TimeService.months)

        forAll(monthGenerator) {
          month =>

            val result = controller.selectMonth(month).apply(FakeRequest(GET, "/"))

            status(result) mustBe SEE_OTHER
        }
      }
    }
  }
}
