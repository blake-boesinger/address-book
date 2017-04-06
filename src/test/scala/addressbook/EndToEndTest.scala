package addressbook

import org.scalatest.FunSuite

class EndToEndTest extends FunSuite {

  test("end to end test to check integration") {

    assert (new AddressBookQueries(new AddressBookRepository(FileContents.fileContents)).countMales == 3)
  }

}
