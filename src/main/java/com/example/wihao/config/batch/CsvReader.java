package com.example.wihao.config.batch;
import com.example.wihao.dto.book.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvReader {
    @Bean
    public FlatFileItemReader<BookDto> csvFileItemReader() throws Exception {
        FlatFileItemReader<BookDto> flatFileItemReader = new FlatFileItemReader<>();


        flatFileItemReader.setResource(new ClassPathResource("/book.csv"));
        flatFileItemReader.setEncoding("UTF-8");
        flatFileItemReader.setLinesToSkip(1);

        DefaultLineMapper<BookDto> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
        delimitedLineTokenizer.setNames("category", "title", "author", "issueYear", "publisher");
        delimitedLineTokenizer.setStrict(false);
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<BookDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(BookDto.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        flatFileItemReader.setLineMapper(defaultLineMapper);

        log.info("FlatFileItemReader initialized with resource: {}", new ClassPathResource("/book.csv"));
        log.info("FlatFileItemReader encoding: UTF-8");

        System.out.println("------" + flatFileItemReader);
        return flatFileItemReader;
    }
}
