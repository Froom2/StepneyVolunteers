package models

sealed trait VolunteerType

case object JuniorVolunteer extends VolunteerType

case object SeniorVolunteer extends VolunteerType

case object AdultVolunteer extends VolunteerType