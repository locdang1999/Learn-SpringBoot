package danggialoc.springboot.tutorial.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import danggialoc.springboot.tutorial.datajpa.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long	>{

}
