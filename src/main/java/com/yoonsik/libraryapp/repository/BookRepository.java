package com.yoonsik.libraryapp.repository;

import com.yoonsik.libraryapp.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findByName(String bookName);

}
