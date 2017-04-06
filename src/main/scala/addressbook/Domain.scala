package addressbook

import java.util.Date

  object Gender {
    def fromString(s: String): Gender = s match {
      case "Male" => Male
      case "Female" => Female
    }
  }

  sealed trait Gender

  case object Male extends Gender
  case object Female extends Gender

  case class Entry(name: String, gender: Gender, dob: Date)

