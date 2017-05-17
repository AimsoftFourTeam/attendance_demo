package com.example.mybatis.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * MyBatisのConfigurationファイル.
 */
@Configuration
public class MyBaticConfiguration {

	@Autowired
    @Bean
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dataSource") DataSource dataSource) {

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }
	
	@Autowired
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(
                new DefaultResourceLoader());

        // MyBatis のコンフィグレーションファイル
        bean.setConfigLocation(resolver.getResource("classpath:config/mybatis.xml"));
        // MyBatis で使用する SQL ファイル群
        bean.setMapperLocations(resolver.getResources("classpath:sql/*.xml"));

        return new SqlSessionTemplate(bean.getObject());
    }
	
	@Primary
    @Autowired
    @Bean
    public DriverManagerDataSource dataSource() {
		
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        dataSource.setUrl("jdbc:postgresql://localhost/sampledatabase");
        dataSource.setUsername("postgres");
        dataSource.setPassword("aimsoft14");

        return dataSource;
    }

}
