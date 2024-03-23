package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepository;

@Service
public class BookImplService implements BookService{
@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
		
		//return bookRepo.findAll();
		return bookRepo.findByActiveSW("y");
	}

	@Override
	public Boolean saveBook(Book book) {
		book.setActiveSW("y");
		Book savedBook = bookRepo.save(book);
		if(savedBook.getBookId()!=null) {
			return true;
		}
		  return false;
	}

	@Override
	public void deleteBook(Integer bookId) {
		//bookRepo.deleteById(bookId);
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			Book book = findById.get();
			book.setActiveSW("N");
			bookRepo.save(book);
		}
	}

	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	
	
	
	
}
