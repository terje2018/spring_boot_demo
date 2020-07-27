package me.terje.spring.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Profile("dev")
@Configuration//@Configuration和@Bean将数据源相关的bean配制到容器中。
@ConfigurationProperties(prefix="spring.datasource.hikari")
public class DataSourceDev extends HikariConfig{
    @Bean(name = "data_source_dev")
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }

    /**
     * Note that the DataSource specified for the transaction manager must be the same one
     * that is used to create the SqlSessionFactoryBean or transaction management will not work.
     *
     * */
    @Bean(name = "transactionManager")//会在@Transactional的是时候使用，容器会查找manager，最终根据name来确定。
    public DataSourceTransactionManager transactionManager(
            @Qualifier("data_source_dev") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("data_source_dev") DataSource dataSource)throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:me/terje/spring/model/*.xml"));
        return sessionFactory.getObject();
    }
}
