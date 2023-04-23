package com.example.wihao.repository.book;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.book.QBook;
import com.example.wihao.dto.book.BookReadCondition;
import com.example.wihao.dto.book.BookResponseDto;
import com.example.wihao.utils.Status;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.wihao.domain.book.QBook.book;

@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<BookResponseDto> findAllByCondition(BookReadCondition condition) {
        QBook book = QBook.book;

        List<Book> result = jpaQueryFactory
                .selectFrom(book)
                .where(eqISBN(condition.getISBN()), eqCategory(condition.getCategory()), eqAuthor(condition.getAuthor())
                        , eqPublisher(condition.getPublisher()), eqTitle(condition.getTitle()), eqStatus(Status.ACTIVE)).stream().toList();

        List<BookResponseDto> content = result.stream().map(BookResponseDto::toDto).collect(Collectors.toList());
        return content;
    }

    private BooleanExpression eqISBN(String ISBN) {
        if (ISBN != null) {
            return book.ISBN.contains(ISBN);
        }
        return null;
    }

    private BooleanExpression eqTitle(String title) {
        if (title != null) {
            return book.title.contains(title);
        }
        return null;
    }

    private BooleanExpression eqCategory(String category) {
        if (category != null) {
            return book.category.contains(category);
        }
        return null;
    }

    private BooleanExpression eqAuthor(String author) {
        if (author != null) {
            return book.author.contains(author);
        }
        return null;
    }

    private BooleanExpression eqPublisher(String publisher) {
        if (publisher != null) {
            return book.publisher.contains(publisher);
        }
        return null;
    }

    private BooleanExpression eqStatus(Status status) {
        if (status != null) {
            return book.status.eq(status);
        }
        return null;
    }
}
