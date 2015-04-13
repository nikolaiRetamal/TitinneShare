package cnam.tittineshare.config;


import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import cnam.tittineshare.modele.bean.Trajet;
import cnam.tittineshare.modele.bean.Utilisateur;
import cnam.tittineshare.modele.dao.TrajetDAO;
import cnam.tittineshare.modele.dao.UtilisateurDAO;


@Configuration
@ComponentScan(basePackages="cnam.tittineShare")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/images/**").addResourceLocations("/resources/images");
	}
	
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(838860800);
        return multipartResolver;
    }
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
		dataSource.setUsername("root");
		dataSource.setPassword("secret");
	 
		return dataSource;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
		sessionBuilder.addAnnotatedClasses(Utilisateur.class);
		sessionBuilder.addAnnotatedClasses(Trajet.class);
	 
		return sessionBuilder.buildSessionFactory();
	}	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
	 
		return transactionManager;
	}
	@Autowired
	@Bean(name = "utilisateurDao")
	public UtilisateurDAO getUtilisateurDao(SessionFactory sessionFactory) {
		return new UtilisateurDAO(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "trajetDao")
	public TrajetDAO getTrajetDao(SessionFactory sessionFactory) {
		return new TrajetDAO(sessionFactory);
	}
}