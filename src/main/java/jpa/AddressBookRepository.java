package jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, String> {

    List<AddressBook> findById(Integer id);
}
