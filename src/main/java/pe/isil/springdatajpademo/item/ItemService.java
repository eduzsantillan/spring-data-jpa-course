package pe.isil.springdatajpademo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.springdatajpademo.category.Category;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    public Item getItemById(Long id){
        return itemRepository.findById(id).get();
    }

    public Item getItemByName(String name){
        return itemRepository.findItemByDescription(name);
    }

    public void add(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void update(Item item, Long id){

        Optional<Item> itemToUpdate = itemRepository.findById(id);

        if(itemToUpdate.isPresent()){

            itemToUpdate.get().setBrand(item.getBrand()!=null? item.getBrand() : itemToUpdate.get().getBrand());
            itemToUpdate.get().setCategory(item.getCategory()!=null? item.getCategory() : itemToUpdate.get().getCategory());
            itemToUpdate.get().setDescription(item.getDescription()!=null? item.getDescription() : itemToUpdate.get().getDescription());
            itemToUpdate.get().setPrice(item.getPrice()!=null? item.getPrice() : itemToUpdate.get().getPrice());

        }else{
            throw new RuntimeException("Item does not exist");
        }
    }

    public void delete(Long id){
        Optional<Item> itemToDelete = itemRepository.findById(id);
        if(itemToDelete.isPresent()){
            itemRepository.delete(itemToDelete.get());
        }else{
            throw new RuntimeException("Item does not exist");
        }
    }


}
