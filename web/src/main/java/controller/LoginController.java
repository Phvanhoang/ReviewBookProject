package controller;

import entity.BookEntity;
import entity.MyBooksEntity;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BookEntityService;
import service.UserEntityService;

import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    private BookEntityService bookEntityService;

    @Autowired
    private UserEntityService userEntityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage(Pageable pageable){
        Page<BookEntity> books = bookEntityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("home_page");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //-----book details-----
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
    public ModelAndView bookDetails(@PathVariable long id){
        BookEntity bookEntity = bookEntityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("book_details_page");
        modelAndView.addObject("book", bookEntity);
        return modelAndView;
    }

    //-----my book-----
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public ModelAndView myBook(@PathVariable long id, @PageableDefault(size = 5, page = 0 ) Pageable pageable){
        UserEntity userEntity = userEntityService.findById(id);
        Set<MyBooksEntity> myBooksEntity = userEntity.getMyBooks();

        ModelAndView modelAndView = new ModelAndView("my_book_page");
        modelAndView.addObject("myBooks", myBooksEntity);
        modelAndView.addObject("userId", userEntity.getId());
        modelAndView.addObject("notifications", userEntity.getNotifications());
        return modelAndView;
    }

    @RequestMapping(value = "/user/{userId}/delete/{bookId}", method = RequestMethod.POST)
    public String deleteBook(@PathVariable long userId, @PathVariable long bookId){
        UserEntity userEntity = userEntityService.findById(userId);
        Set<MyBooksEntity> myBooksEntities = userEntity.getMyBooks();
        BookEntity book = bookEntityService.findById(bookId);
       myBooksEntities.remove(book);
        return "redirect:/list/{userId}";
    }
}
