package com.example.wihao.config.batch;

import com.example.wihao.dto.book.BookDto;
import com.example.wihao.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final JobRepository jobRepository;

    private final PlatformTransactionManager transactionManager;

    private final CsvReader csvReader;

    private final CsvWriter csvWriter;

    private final BookRepository bookRepository;

    private static final int chunkSize = 100;

    @Bean
    public Job csvFileItemReaderJob() throws Exception {
        return new JobBuilder("csvFileItemReaderJob", jobRepository)
                .start(csvFileItemReaderStep())
                .build();
    }

    @Bean
    public Step csvFileItemReaderStep() throws Exception {
        return new StepBuilder("csvFileItemReaderStep", jobRepository)
                .<BookDto, BookDto>chunk(chunkSize, transactionManager)
                .reader(csvReader.csvFileItemReader())
                .writer(csvWriter)
                .transactionManager(transactionManager)
                .build();
    }


}
