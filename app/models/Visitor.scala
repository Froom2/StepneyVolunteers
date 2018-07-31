package models

import org.joda.time.LocalDate

case class Visitor(firstName: String,
                   lastName: String,
                   dateOfBirth: LocalDate,
                   volunteerType: VolunteerType,
                   visits: Seq[Visit]) {}
