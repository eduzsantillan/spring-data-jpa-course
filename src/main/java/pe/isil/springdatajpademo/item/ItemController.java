package pe.isil.springdatajpademo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping("/add")
    public void addItem(@RequestBody Item item){
        itemService.add(item);
    }

    @PostMapping("/update")
    public void updateItem(@RequestBody Item item, @RequestParam Long id){
        itemService.update(item,id);
    }

    @GetMapping({"/getall",""})
    public List<Item> getAllItems(){
        return itemService.getAll();
    }

    @GetMapping("/getbyid")
    public Item getItemById(@RequestParam  Long id){
        return itemService.getItemById(id);
    }

    @GetMapping("/getbyname")
    public Item getCategoryByName(@RequestParam  String name){
        return itemService.getItemByName(name);
    }

}
