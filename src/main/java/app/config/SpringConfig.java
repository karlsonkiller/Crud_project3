//package app.config;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan(value = "app")
//public class SpringConfig {
//
//    private final ApplicationContext applicationContext;
//
//    private final Environment env;
//
//    @Autowired
//    public SpringConfig(ApplicationContext applicationContext, Environment env) {
//        this.applicationContext = applicationContext;
//        this.env = env;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
//
////    @Bean
////    public SpringTemplateEngine templateEngine() {
////        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
////        templateEngine.setTemplateResolver(templateResolver());
////        templateEngine.setEnableSpringELCompiler(true);
////        return templateEngine;
////    }
//
////    @Override
////    public void configureViewResolvers(ViewResolverRegistry registry) {
////        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
////        resolver.setTemplateEngine(templateEngine());
////        resolver.setCharacterEncoding("UTF-8");
////
////        registry.viewResolver(resolver);
////    }
//
////    @Bean
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////
////        dataSource.setDriverClassName(env.getRequiredProperty("hibernate.driver_class"));
////        dataSource.setUrl(env.getProperty("db.url"));
////        dataSource.setUsername(env.getProperty("db.username"));
////        dataSource.setPassword(env.getProperty("db.password"));
////
////        return dataSource;
////    }
//
////    @Bean
////    public DataSource dataSource() {
////        BasicDataSource dataSource = new BasicDataSource();
////        dataSource.setUrl(env.getRequiredProperty("db.url"));
////        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
////        dataSource.setUsername(env.getRequiredProperty("db.username"));
////        dataSource.setPassword(env.getRequiredProperty("db.password"));
////        return dataSource;
////    }
//
////    private Properties hibernateProperties() {
////        Properties properties = new Properties();
////        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
////        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
////        properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("hibernate.hbm2ddl.auto"));
////
////        return properties;
////    }
//
//
////    @Bean
////    public LocalContainerEntityManagerFactoryBean getEntityManager() {
////        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
////        em.setDataSource(getDataSource());
////        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
////
////        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
////        em.setJpaProperties(getHibernateProperties());
////        return em;
////    }
//
//
//    @Bean
//    public DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl(env.getRequiredProperty("db.url"));
//        dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
//        dataSource.setUsername(env.getRequiredProperty("db.username"));
//        dataSource.setPassword(env.getRequiredProperty("db.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        InputStream inputStream = getClass().getClassLoader()
//                .getResourceAsStream("db.properties");
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//        return properties;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(getDataSource());
//        em.setPackagesToScan("db.entity.package");
//
//        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(getHibernateProperties());
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }
//
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//}
