

package in.ashokit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.service.BookService;

@Controller
public class BookController {
@Autowired
	BookService bookService;

@GetMapping("/index")
public ModelAndView index() {
	ModelAndView mav = new ModelAndView();
	mav.addObject("book", new Book());
	mav.setViewName("index");
	return mav;
}

  @PostMapping("/book")
  public ModelAndView saveBook(Book book) {
  ModelAndView mav = new ModelAndView();
  Boolean status = bookService.saveBook(book);
  if(status) {
	  mav.addObject("successmsg", "Your book has saved successfully");
  }else {
	mav.addObject("errormsg", "failed to saved");
}
  
mav.setViewName("index");
   return mav;
}
	@GetMapping("/books")
	public ModelAndView getBooks() {
		ModelAndView mav = new ModelAndView();
	 List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("booksView");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer bookId) {
	             bookService.deleteBook(bookId);
	         ModelAndView mav = new ModelAndView();
	         List<Book> allBooks = bookService.getAllBooks();
	         mav.addObject("books", allBooks);
	         mav.setViewName("booksView");
	return mav;
	}
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId") Integer bookId) {
	Book bookobj = bookService.getBookById(bookId);
	ModelAndView mav = new ModelAndView();
	mav.addObject("book", bookobj);
	mav.setViewName("index");
	return mav;
	}
	}
	
	
	

