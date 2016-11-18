package com.bitwise.manageme.rssson.config;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import com.bitwise.manageme.rssson.util.uuid.UUIDFactory;
import com.mysql.jdbc.Driver;

import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;

import javax.sql.DataSource;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages={ "com.bitwise.manageme.rssson.service", "com.bitwise.manageme.rssson.repository", "com.bitwise.manageme.rssson.domain.support"})
public class InfrastructureContextConfiguration {
	
	@Bean
	public DataSource jpaDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(Driver.class.getName());
		source.setUrl("jdbc:mysql://localhost:3306/rssson");
		source.setUsername("root");
		source.setPassword("apple");
		return source;
	}
	
	@Bean
	public Properties jpaProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQL5Dialect.class.getName());
		props.put("hibernate.hbm2dll.auto", "create");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.cache.use_second_level_cache", true);
		props.put("hibernate.cache.region.factory_class", org.hibernate.cache.ehcache.EhCacheRegionFactory.class.getName());
		
		//c3p0 Settings
		props.put("hibernate.c3p0.min_size", 5);
		props.put("hibernate.c3p0.max_size", 85);
		props.put("hibernate.c3p0.timeout", 300);
		props.put("hibernate.c3p0.max_statements", 500);
		props.put("hibernate.c3p0.idle_test_period", 3000);
		return props;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setJpaProperties(jpaProperties());
		lef.setDataSource(jpaDataSource());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		return lef;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hJpa = new HibernateJpaVendorAdapter();
		hJpa.setGenerateDdl(true);
		hJpa.setShowSql(true);
		return hJpa;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(emf().getObject());
	}
	
	@Bean
	protected UUIDFactory uuidFactory() {
		return new UUIDFactory();
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		return new ThreadPoolTaskExecutor() {
			private static final long serialVersionUID = 1L;

		{
			setCorePoolSize(15);
			setMaxPoolSize(25);
			setQueueCapacity(50);
			setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		}};
	}
}
