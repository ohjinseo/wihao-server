package com.example.wihao.config.batch;

import com.example.wihao.dto.book.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class LoggingLineMapper<T> extends DefaultLineMapper<T> {

    private static final Logger log = LoggerFactory.getLogger(LoggingLineMapper.class);

    public LoggingLineMapper(Class<T> type, DefaultLineMapper<BookDto> defaultLineMapper) {
        setLineTokenizer(new DelimitedLineTokenizer());
        setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
            {
                setTargetType(type);
            }
        });
    }

    @Override
    public T mapLine(String line, int lineNumber) throws Exception {
        log.info("Reading line: {}", line);
        return super.mapLine(line, lineNumber);
    }
}