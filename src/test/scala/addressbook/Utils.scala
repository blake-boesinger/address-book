package addressbook

import java.text.DateFormat
import java.util.Date

object Utils {

  def dateFromString(s: String): Date = {
    DateFormat.getDateInstance(DateFormat.SHORT).parse(s)
  }

}
