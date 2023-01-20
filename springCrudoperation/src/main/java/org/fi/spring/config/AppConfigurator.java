package org.fi.spring.config;

import javax.sql.DataSource;

import org.fi.spring.beans.Category;
import org.fi.spring.jdbc.dao.CategoryDAO;
import org.fi.spring.jdbc.dao.CategoryDAOImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfigurator {
	@Bean
	public DataSource dataSource(@Value("${datasource.driverclass}")String driverclass,
			@Value("${datasource.url}")String url,
			@Value("${datasource.username}")String username,
			@Value("${datasource.password}")String password)
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverclass);
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public CategoryDAO objCategoryDAO()
	{
		return new CategoryDAOImpl();
	}
	@Bean
	public Category objCategory()
	{
		return new Category();
	}

}
