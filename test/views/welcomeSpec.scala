package views

import org.scalatest.matchers.{MatchResult, Matcher}
import org.scalatestplus.play.PlaySpec
import org.jsoup.nodes.{Attributes, Document, Element}
import org.jsoup.select.Elements
import org.scalatest.matchers.{MatchResult, Matcher}

class welcomeSpec extends PlaySpec {

  "welcome view" should {
    "contain correct content" in {



    }
  }



}

trait JsoupMatchers {

  class TagWithTextMatcher(expectedContent: String, tag: String) extends Matcher[Document] {
    def apply(left: Document): MatchResult = {
      val elements: List[String] =
        left.getElementsByTag(tag)
          .toList
          .map(_.text)

      lazy val elementContents = elements.mkString("\t", "\n\t", "")

      MatchResult(
        elements.contains(expectedContent),
        s"[$expectedContent] not found in '$tag' elements:[\n$elementContents]",
        s"'$tag' element found with text [$expectedContent]"
      )
    }
  }

  def haveHeadingWithText (expectedText: String) = new TagWithTextMatcher(expectedText, "h1")

}