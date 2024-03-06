package danggialoc.springboot.tutorial.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import danggialoc.springboot.tutorial.datajpa.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
