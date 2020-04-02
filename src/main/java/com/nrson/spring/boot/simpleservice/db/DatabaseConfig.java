package com.nrson.spring.boot.simpleservice.db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DB 연동  
 * spring boot는 설정 관련 내용을 거의 대부분 java 소스 코드로 진행함 
 * @Configuration : 데이터 베이스에 대한 접속정보를 나타내고, 일반 Bean이 아닌 Configuration으로 설정되어 있어야 한다.
 * 					(실제로는 하위에 Bean을 두 개 더 생성한다. )  
 * 
 * @MapperScan(basepackages ="com.nrson.spring.*)
 * 최신 Spring Boot는 dao를 dao라고 명시하지 않고 mapper라는 이름으로 별도 정의하고 있다. 따라서 어떤 패키지에서 
 * mapper들을 scan 할 것 인가를 최상위에 annotation으로 정의해 주고 있다. 다중 Database에 접근해야 하는 경우 
 * 이 클래스를 두개 만들어 주고, scan할 대상 mapper들을 패키지 구조상에서 분리해 두는 것도 방법 
 * 								 
 * @EnableTransactionManagmeent 
 * TransactionManager를 적용할 것인지에 대해 설정하는 annotation이다. 
 * 
 * @Bean SqlSessionFactory 
 * DataSource를 parameter로 받아, sqlSessionFactory를 생성하는 Bean이다. 
 * 
 * @author junyoung
 */


@Configuration 
@MapperScan(basePackages = "com.nrson.spring.*")
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean(); 
		sessionFactory.setDataSource(datasource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
		return sessionFactory.getObject();		
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception { 
		final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}

}
