package com.mohamed.hibernate;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.mohamed.entity.Custom;
import com.mohamed.entity.Detail;
import com.mohamed.entity.RequestCustom;

@Component
public class HiberConfig {
	
	
	 private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();
	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/customerdp?useSSL=false");
	                settings.put(Environment.USER, "medoras");
	                settings.put(Environment.PASS, "user_password");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	                
	                configuration.setProperties(settings);
	                configuration.addAnnotatedClass(Custom.class)
	                .addAnnotatedClass(Detail.class)
	                .addAnnotatedClass(RequestCustom.class);
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }

}
