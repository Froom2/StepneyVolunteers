package models

import models.VisitPurpose.{JustVisiting, Riding, Volunteering}
import org.scalatest.prop.PropertyChecks
import org.scalatestplus.play.PlaySpec
import org.scalacheck.Gen
import org.scalacheck.Arbitrary.arbitrary


class VisitPurposeSpec extends PlaySpec with PropertyChecks {

  "VisitPurpose bind" must {

    "successfuly bind to a VisitPurpose" in {
      forAll(arbitrary[String]) {
        string =>
          VisitPurpose.pathBinder.bind(string, "justvisiting") mustEqual Right(JustVisiting)
          VisitPurpose.pathBinder.bind(string, "volunteering") mustEqual Right(Volunteering)
          VisitPurpose.pathBinder.bind(string, "riding") mustEqual Right(Riding)
      }
    }

    "return an error when VisitPurpose is invalid" in {
      forAll(arbitrary[String]) {
        string =>
          VisitPurpose.pathBinder.bind(string, string) mustEqual Left("Invalid state")
      }
    }
  }

  "VisitPurpose unbind" must {
    "return a lowercase string" in {

      forAll(arbitrary[String]) {
        string =>
          VisitPurpose.pathBinder.unbind(string, JustVisiting) mustEqual "justvisiting"
          VisitPurpose.pathBinder.unbind(string, Volunteering) mustEqual "volunteering"
          VisitPurpose.pathBinder.unbind(string, Riding) mustEqual "riding"
      }
    }
  }

}
