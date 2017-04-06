package addressbook

import java.text.DateFormat

object FileContents {
  //hardcoding this here to avoid having to read in from a file.
  val fileContents: String =
                     """Bill McKnight, Male, 16/03/77
                       |Paul Robinson, Male, 15/01/85
                       |Gemma Lane, Female, 20/11/91
                       |Sarah Stone, Female, 20/09/80
                       |Wes Jackson, Male, 14/08/74""".stripMargin
  }

class AddressBookRepository(csv: String) { //assume only CSV is needed.
  //strictly speaking repository could be separated from parsing, but will keep them as one
  //for a simple toy problem like this
  def entries: List[Entry] = {
    (for {
      line <- csv.lines
      cols = line.split(",").map(_.trim)
      entry = Entry(cols(0), Gender.fromString(cols(1)), DateFormat.getDateInstance(DateFormat.SHORT).parse(cols(2)))
      //assuming no error handling needed for parsing
    } yield entry).toList
  }

}


