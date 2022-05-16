//package com.example.SpringBatch.Chap2;
//
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
//import org.springframework.boot.autoconfigure.batch.BatchProperties;
//import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//@Component
//public class CustomBatchConfigurer extends BasicBatchConfigurer {
//
//    private final DataSource dataSource;
//
//    protected CustomBatchConfigurer(BatchProperties properties, DataSource dataSource, TransactionManagerCustomizers transactionManagerCustomizers) {
//        super(properties, dataSource, transactionManagerCustomizers);
//        this.dataSource = dataSource;
//    }
//    @Override
//    protected JobRepository createJobRepository() throws Exception{
//        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
//        jobRepositoryFactoryBean.setDataSource(dataSource);
//        jobRepositoryFactoryBean.setTransactionManager(getTransactionManager());
//        jobRepositoryFactoryBean.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
//        jobRepositoryFactoryBean.setTablePrefix("SYSTEM_");
//        return jobRepositoryFactoryBean.getObject();
//    }
//}
