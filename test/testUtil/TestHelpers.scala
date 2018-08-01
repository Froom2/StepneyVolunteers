package testUtil

import org.jsoup.nodes.Document
import org.scalatest.MustMatchers

object TestHelpers extends MustMatchers {

  def checkElement(view: Document, tag: String, size: Int, text: String) = {
    val h1s = view.getElementsByTag(tag)

    h1s.size mustBe size
    h1s.text must include(text)
  }

}
