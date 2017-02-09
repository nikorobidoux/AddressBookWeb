package jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, String> {

    List<BuddyInfo> findByName(String name);
}