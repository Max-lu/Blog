package cn.maxlu;

import cn.maxlu.cookie.CookieContext;
import cn.maxlu.interceptor.CookieInterceptor;
import cn.maxlu.db.HibernateAccess;
import cn.maxlu.interceptor.LoginInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("cn.maxlu")
@PropertySource(value = {"classpath:jdbc.properties"})
@EnableWebMvc
@EnableTransactionManagement(proxyTargetClass = true)
public class WebConfig extends WebMvcConfigurerAdapter {


    @Inject
    Environment env;

    @Bean
    public CookieContext cookieContext() {
        return new CookieContext();
    }

    /*DataSource 没有close方法
    * ComboPooledDataSource 有close方法
    * */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(env.getRequiredProperty("jdbc.proxy.url"));
        dataSource.setUser(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        dataSource.setMaxIdleTime(120);
        dataSource.setMaxPoolSize(50);
        dataSource.setUnreturnedConnectionTimeout(150);
        dataSource.setDebugUnreturnedConnectionStackTraces(true);
        dataSource.setConnectionCustomizerClassName("cn.maxlu.db.IsolationLevelReadUncommittedConnectionCustomizer");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource()).scanPackages("cn.maxlu.entity");
        builder.setProperty(org.hibernate.cfg.Environment.DIALECT, MySQL5Dialect.class.getName());
        return builder.buildSessionFactory();
    }

    @Bean
    public HibernateAccess hibernateAccess() throws PropertyVetoException {
        HibernateAccess hibernateAccess = new HibernateAccess();
        hibernateAccess.setSessionFactory(sessionFactory());
        return hibernateAccess;
    }

    @Bean
    @Primary
    public HibernateTransactionManager transactionManager() throws PropertyVetoException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }

    @Bean
    CookieInterceptor cookieInterceptor() {
        return new CookieInterceptor();
    }

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(cookieInterceptor());
//        registry.addInterceptor(loginInterceptor());
    }

}
