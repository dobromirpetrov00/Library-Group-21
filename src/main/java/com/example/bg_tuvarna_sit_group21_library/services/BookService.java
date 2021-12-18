package com.example.bg_tuvarna_sit_group21_library.services;

import com.example.bg_tuvarna_sit_group21_library.database.Entities.*;
import com.example.bg_tuvarna_sit_group21_library.database.repositories.BookRepository;

public class BookService {
    private final BookRepository repository = BookRepository.getInstance();

    public static BookService getInstance() {
        return BookService.BookServiceHolder.INSTANCE;
    }

    private static class BookServiceHolder {
        public static final BookService INSTANCE = new BookService();
    }

    public boolean alreadySetForLater(Books book) { return repository.alreadySetToArchiveLater(book); }

    public void archiveBookLater(Books book){ repository.archiveBookForLater(book); }

    public void addBook(Books b, Booksstored bs, Exemplars ex){
        repository.addBook(b, bs, ex);
    }

    public void deleteBook(Books books, Booksstored booksstored, Exemplars exemplars){
        repository.deleteBook(books,booksstored,exemplars);
    }

    public void rmvOneBookFromAvailable(Books book) { repository.removeBookFromAvailable(book); }

    public void rmvBookUserLend(Books book, Users reader, Lendbooks lendbook) { repository.removeBookUserLend(book, reader, lendbook); }

    public int getLndBkID(Users reader, Lendbooks lendbook) { return repository.getLendBookId(reader,lendbook); }

    public boolean checkIfLendBookIDExists(Lendbooks lendbook) { return repository.ifLendbookIDExists(lendbook); }

    public void addBookAvailable(Books book) { repository.addBookToAvailable(book); }

    public boolean ifLeftEn(Books book, Booksstored booksstored) { return repository.ifLeftEnough(book, booksstored); }

    public boolean ifExist(Books book){
        return repository.ifExists(book);
    }

    public boolean ifArchive(Books book, Bookstates bookstate){ return repository.ifArchived(book, bookstate); }

    public void archivedBook(Books book, Exemplars exemplar, Booksstored booksstored){
        repository.archiveBook(book, exemplar, booksstored);
    }
}
