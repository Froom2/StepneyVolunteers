package models

sealed trait VisitType

case object Arrival extends VisitType

case object Departure extends VisitType