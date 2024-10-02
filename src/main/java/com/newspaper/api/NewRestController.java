package com.newspaper.api;


import com.newspaper.entity.New;
import com.newspaper.entity.User;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_new")
public class NewRestController {

    @Autowired
    private NewService newService;

    //Crud
    @GetMapping("/list_news")
    public List<New> getAllNews() {
        return newService.getAll();
    }

    @GetMapping("/get_new/{id}")
    public ResponseEntity<New> getNewById(@PathVariable("id") Long id){
        New news = newService.getNewById(id);
        if( news != null){
            return new ResponseEntity<>(news, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create_new")
    public ResponseEntity<New> createUser(@RequestBody New news){
        New createdNew = newService.saveNew(news);
        return  new ResponseEntity<>(createdNew, HttpStatus.CREATED);
    }

    @PutMapping("/update_new/{id}")
    public ResponseEntity<New> updateNew(@PathVariable(name = "id") Long id, @RequestBody New news){
        New updatedNew = newService.updateNew(id, news);
        if (updatedNew != null){
            return new ResponseEntity<>(updatedNew, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_new/{id}")
    public  ResponseEntity<New> deleteNew(@PathVariable("id") Long id){
        newService.deleteNew(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO LISTO http://localhost:8083/api_new/category_new/1?offset=0&limit=5 si no sirve preguntele a faiber
    @GetMapping("/category_new/{id_category}")
    public ResponseEntity<Page<New>> getNewsByCategory(@PathVariable("id_category") Long categoryId,
                                                       @RequestParam("offset") int offset,
                                                       @RequestParam("limit") int limit) {
        if (offset < 0 || limit <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Page<New> newsList = newService.getNewByCategory(categoryId, offset, limit);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    // pageNumber qué página obtener.
    // pageSize cuántos mostrar.
    @GetMapping("/recent_new")
    public ResponseEntity<Page<New>> getRecentNew(@RequestParam("page_number") int pageNumber, @RequestParam("page_size") int pageSize){
        Page<New> mostRecentNews = newService.getMostRecentNews(pageNumber,pageSize);
        return new ResponseEntity<>(mostRecentNews, HttpStatus.OK);
    }

    // retorna muchos datos pero funcional
    @GetMapping("/search")
    public ResponseEntity<List<New>> getByTitle(@RequestParam("title") String title) {
        Optional<List<New>> foundNew = newService.getByTitle(title);
        return foundNew
                .map(news -> new ResponseEntity<>(news, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // fino, si no sirve juan no sabe.
    @GetMapping("/list_news/{user_id}")
    public ResponseEntity<Page<New>> getNewsByUser(@PathVariable("user_id") Long userId,int offset, int limit) {
        Page<New> newsFound = newService.findAllByUser(userId,offset,limit);
        return new ResponseEntity<>(newsFound, HttpStatus.OK);
    }

   /* @GetMapping("/get_new")
    public List<NewDto> getAllUser(){
        return newService.getAllNew();
    }

    @GetMapping("/get_new/{id}")
    public NewDto getUserById(@PathVariable("id") Long id){
        return newService.getNewById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        newService.deleteById(id);
    }

//    @PutMapping("/update/{id}")
//    public void takeAttendance(@PathVariable("id") Long id) {
//        newService.saveEventArrivalTime(id);
//    }

    @GetMapping("/recent")
    public NewDto mostRecentNew(){
        return newService.getNewMostRecent();
    }*/
}
