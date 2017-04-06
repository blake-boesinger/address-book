package addressbook

class AddressBookQueries(repository: AddressBookRepository) {

  def countMales: Int = repository.entries.count(_.gender == Male)

  def oldestPerson: Option[Entry] = repository.entries.sortBy(_.dob).headOption

}
