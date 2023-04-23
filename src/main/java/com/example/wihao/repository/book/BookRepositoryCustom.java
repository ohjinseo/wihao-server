package com.example.wihao.repository.book;

import com.example.wihao.dto.book.BookReadCondition;
import com.example.wihao.dto.book.BookResponseDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BookRepositoryCustom {
    List<BookResponseDto> findAllByCondition(BookReadCondition bookReadCondition);
}
