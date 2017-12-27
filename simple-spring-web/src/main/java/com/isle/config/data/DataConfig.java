package com.isle.config.data;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * 配置数据源
 * Created by 61066 on 2017/12/27.
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@MapperScan("com.isle.*.dao.mapper")
public class DataConfig {

    @Autowired
    private Environment environment;

    /**
     * 配置c3p0数据源
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty("datasource.driver"));
        dataSource.setJdbcUrl(environment.getProperty("datasource.url"));
        dataSource.setUser(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setInitialPoolSize(5);
        dataSource.setMaxPoolSize(10);
        return dataSource;
    }

    /**
     * 配置事务管理
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置mybatis sessionFactory
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml")
        );
        return sqlSessionFactory;
    }

}
