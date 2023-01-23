package com.yoonsik.libraryapp.repository;

import com.yoonsik.libraryapp.entity.user.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

  UserLoanHistory findByBookNameAndIsReturn(String bookName, boolean isReturn);

}
