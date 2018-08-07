package models

import play.api.mvc.PathBindable

sealed trait VisitPurpose

object VisitPurpose {

  case object Volunteering extends VisitPurpose
  case object Riding extends VisitPurpose
  case object JustVisiting extends VisitPurpose

  implicit lazy val pathBinder: PathBindable[VisitPurpose] =
    new PathBindable[VisitPurpose] {

      override def bind(key: String, value: String): Either[String, VisitPurpose] =
        value match {
          case "volunteering" => Right(Volunteering)
          case "riding"       => Right(Riding)
          case "justvisiting" => Right(JustVisiting)
          case _              => Left("Invalid state")
        }

      override def unbind(key: String, value: VisitPurpose): String =
        value.toString.toLowerCase
    }
}

