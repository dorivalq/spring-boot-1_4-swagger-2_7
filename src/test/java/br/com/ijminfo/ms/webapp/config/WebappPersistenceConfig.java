package br.com.ijminfo.ms.webapp.config;
/*
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories({
	"br.com.ijminfo.ms.watcher.email.repository",
	    "br.com.ijminfo.ms.nfe.repository",
	    "br.com.ijminfo.ms.nf3e.repository",
	    "br.com.ijminfo.ms.cte.repository","br.com.ijminfo.ms.cteos.repository",
	    "br.com.ijminfo.ms.company.repository",
	    "br.com.ijminfo.ms.event.repository","br.com.ijminfo.ms.nfe.outbound.repository",
	    "br.com.ijminfo.ms.cte.outbound.repository","br.com.ijminfo.ms.grid.repository"
})

@PropertySource("application-test.properties")
public class WebappPersistenceConfig {

	@Bean
	public DataSource dataSource() {
        System.out.println();
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost/flnfe?useSSL=false&autoReconnect=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("ruut");
//        return dataSource;
        
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
        		//.addScript("data.sql")
        		.build();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapater = new HibernateJpaVendorAdapter();
        jpaVendorAdapater.setDatabase(Database.MYSQL);
        jpaVendorAdapater.setGenerateDdl(false);
        jpaVendorAdapater.setGenerateDdl(true);
        jpaVendorAdapater.setShowSql(true);
        return jpaVendorAdapater;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory  = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory .setDataSource(dataSource());
        entityManagerFactory .setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory .setPackagesToScan("br.com.ijminfo.ms.model");
        
        return entityManagerFactory ;
	}
}
*/
