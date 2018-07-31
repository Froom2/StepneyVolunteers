package models

import org.joda.time.LocalDateTime

case class Visit(time: LocalDateTime,
                 visitType: VisitType,
                 visitPurpose: VisitPurpose) {}
