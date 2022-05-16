package com.example.SpringBatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HelloJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloJob() {
        return this.jobBuilderFactory.get("helloJob").start(this.helloStep1()).next(this.helloStep2()).build();
    }

    @Bean
    public Step helloStep1() {
        return this.stepBuilderFactory.get("helloStep1").tasklet(new Tasklet() {
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("======================");
                System.out.println(" Hello Spring Batch!!");
                System.out.println("======================");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step helloStep2() {
        return this.stepBuilderFactory.get("helloStep2").tasklet(new Tasklet() {
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("======================");
                System.out.println(" >> step2 was executed!!");
                System.out.println("======================");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    public HelloJobConfiguration(final JobBuilderFactory jobBuilderFactory, final StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }
}
