package springdata.envers.COntroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springdata.envers.Entity.Book;
import springdata.envers.Repository.BookRepo;

@RestController
public class BookController {
    @Autowired
    BookRepo repository;


    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @PutMapping("/update/{id}/{pages}")
    public String updateBook(@PathVariable int id, @PathVariable int pages) {
        Book book = repository.findById(id).get();
        book.setPages(pages);
        repository.save(book);
        return "Book updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "Book deleted";
    }
    @GetMapping("/getInfo/{id}")
    public void getInfo(@PathVariable  int id){
        System.out.println(repository.findLastChangeRevision(id));
    }
}
