package addressbook

import Utils._
import java.text.DateFormat

import org.mockito.Mockito
import org.scalatest.FunSuite

class AddressBookQueriesTest extends FunSuite {

  test("should count males") {
    val mockRepo = setUpMock(
      List(Entry("younger person", Male, dateFromString("14/08/74")),
        Entry("older person", Female, dateFromString("14/08/73"))
      ))

    assert (new AddressBookQueries(mockRepo).countMales == 1)
  }

  test("should find oldest person") {
    val mockRepo = setUpMock(
      List(Entry("younger person", Male, dateFromString("14/08/74")),
        Entry("older person", Female, dateFromString("14/08/73"))
      ))

    assert (new AddressBookQueries(mockRepo).oldestPerson == Some(Entry("older person", Female, dateFromString("14/08/73"))))
  }

  test("should find oldest person in empty address book") {
    val mockRepo = Mockito.mock(classOf[AddressBookRepository])

    Mockito.when(mockRepo.entries).thenReturn(List())

    assert (new AddressBookQueries(mockRepo).oldestPerson.isEmpty)
  }

  private def setUpMock(entries: List[Entry]) = {
    val mockRepo = Mockito.mock(classOf[AddressBookRepository])
    Mockito.when(mockRepo.entries).thenReturn(
      entries)
    mockRepo
  }


}
