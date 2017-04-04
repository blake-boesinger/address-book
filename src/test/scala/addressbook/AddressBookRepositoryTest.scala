package addressbook

import java.text.DateFormat

import org.scalatest._

class AddressBookRepositoryTest extends FunSuite {

  test("should parse a single entry") {
    val parsed: Seq[Entry] = new AddressBookRepository("Bill McKnight, Male, 16/03/77").entries
    assert (parsed == List(Entry("Bill McKnight", Male, DateFormat.getDateInstance(DateFormat.SHORT).parse("16/03/77"))))
  }

  test("should parse multiple entries") {
    val parsed: Seq[Entry] = new AddressBookRepository("Bill McKnight, Male, 16/03/77\nPaul Robinson, Male, 15/01/85").entries
    val expected = List(Entry("Bill McKnight", Male, DateFormat.getDateInstance(DateFormat.SHORT).parse("16/03/77")),
      Entry("Paul Robinson", Male, DateFormat.getDateInstance(DateFormat.SHORT).parse("15/01/85"))
    )
    assert (parsed == expected)
  }

}
