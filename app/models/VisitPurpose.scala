package models

sealed trait VisitPurpose

case object Volunteering extends VisitPurpose

case object Riding extends VisitPurpose

case object JustVisiting extends VisitPurpose
