package addressbook

import java.text.DateFormat
import java.util.Date

object Gender {
  def fromString(s: String) = s match {
    case "Male" => Male
    case "Female" => Female
  }
}

sealed trait Gender

case object Male extends Gender
case object Female extends Gender

case class Entry(name: String, gender: Gender, dob: Date)

object FileContents {
  //hardcoding this here to avoid having to read in from a file.
  val fileContents =
                     """Bill McKnight, Male, 16/03/77
                       |Paul Robinson, Male, 15/01/85
                       |Gemma Lane, Female, 20/11/91
                       |Sarah Stone, Female, 20/09/80
                       |Wes Jackson, Male, 14/08/74""".stripMargin
  }

class AddressBookRepository(csv: String) {  //assume only CSV is needed
  def entries: List[Entry] = {
    (for {
      line <- csv.lines
      cols = line.split(",").map(_.trim)
      entry = Entry(cols(0), Gender.fromString(cols(1)), DateFormat.getDateInstance(DateFormat.SHORT).parse(cols(2)))
    } yield entry).toList
  }

}


class AddressBookQueries(repository: AddressBookRepository) {

  def countMales = repository.entries.count(_.gender == Male)

  def oldestPerson: Option[Entry] = repository.entries.sortBy(_.dob).headOption



}