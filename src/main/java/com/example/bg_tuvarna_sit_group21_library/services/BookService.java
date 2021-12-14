package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.Books;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Booksstored;
import com.example.bg_tuvarna_sit_group21_library.database.Entities.Exemplars;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.BookRepository;

public class BookService {
    private final BookRepository repository = BookRepository.getInstance();

    public static BookService getInstance() {
        return BookService.BookServiceHolder.INSTANCE;
    }

    private static class BookServiceHolder {
        public static final BookService INSTANCE = new BookService();
    }

    public void addBook(Books b, Booksstored bs, Exemplars ex){
        repository.addBook(b, bs, ex);
    }

    public void deleteBook(Books books, Booksstored booksstored, Exemplars exemplars){
        repository.deleteBook(books,booksstored,exemplars);
    }

    public boolean ifExist(Books book){
        return repository.ifExists(book);
    }

    public boolean ifArchive(Books book){ return repository.ifArchived(book); }

    public void archivedBook(Books book, Exemplars exemplar, Booksstored booksstored){
        repository.archiveBook(book, exemplar, booksstored);
    }
}
