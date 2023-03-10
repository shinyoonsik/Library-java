package com.yoonsik.libraryapp.service.book;

import com.yoonsik.libraryapp.entity.book.Book;
import com.yoonsik.libraryapp.repository.BookRepository;
import com.yoonsik.libraryapp.entity.user.User;
import com.yoonsik.libraryapp.repository.UserRepository;
import com.yoonsik.libraryapp.repository.UserLoanHistoryRepository;
import com.yoonsik.libraryapp.dto.book.request.BookLoanRequest;
import com.yoonsik.libraryapp.dto.book.request.BookRequest;
import com.yoonsik.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public BookService(
            BookRepository bookRepository,
            UserRepository userRepository,
            UserLoanHistoryRepository userLoanHistoryRepository
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveBook(BookRequest request) {
        Book newBook = new Book(request.getName());
        bookRepository.save(newBook);
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        if (userLoanHistoryRepository.findByBookNameAndIsReturn(request.getBookName(), false) != null) {
            throw new IllegalArgumentException("이미 대출되어 있는 책입니다");
        }

        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.loanBook(book);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
    }

}
