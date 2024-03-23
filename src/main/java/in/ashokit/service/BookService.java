package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Boolean saveBook(Book book);
	public void deleteBook(Integer bookId);
    public Book getBookById(Integer bookId);
}
