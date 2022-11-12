package pe.isil.springdatajpademo.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findItemByDescription(String description);
}
