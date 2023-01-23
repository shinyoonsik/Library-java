package com.yoonsik.libraryapp.controller.book;

import com.yoonsik.libraryapp.dto.book.request.BookLoanRequest;
import com.yoonsik.libraryapp.dto.book.request.BookRequest;
import com.yoonsik.libraryapp.dto.book.request.BookReturnRequest;
import com.yoonsik.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void saveBook(@RequestBody BookRequest request) {
        bookService.saveBook(request);
    }

    @PostMapping("/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @PutMapping("/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        bookService.returnBook(request);
    }

}
