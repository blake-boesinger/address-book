package addressbook

import java.text.DateFormat

import org.scalatest.FunSuite

class AddressBookQueriesTest extends FunSuite {

  test("should count males") {
    assert (new AddressBookQueries(new AddressBookRepository(FileContents.fileContents)).countMales == 3)
  }

  test("should find oldest person") {
    assert (new AddressBookQueries(new AddressBookRepository(FileContents.fileContents)).oldestPerson == Some(Entry("Wes Jackson", Male, DateFormat.getDateInstance(DateFormat.SHORT).parse("14/08/74"))))
  }

  test("should find oldest person in empty address book") {
    assert (new AddressBookQueries(new AddressBookRepository("")).oldestPerson.isEmpty)
  }





}
