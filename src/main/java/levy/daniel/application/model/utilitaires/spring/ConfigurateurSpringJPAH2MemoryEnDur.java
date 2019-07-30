package levy.daniel.application.model.utilitaires.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jpa.boot.spi.Bootstrap;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import levy.daniel.application.model.utilitaires.jpa.datasource.DataSourceH2MemoryHikariEnDur;

/**
 * CLASSE ConfigurateurSpringJPAPostgresServerEnDur :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 28 juil. 2019
 *
 */
@Profile("PROFIL_TEST_H2_MEMORY")
@Configuration(value="ConfigurateurSpringJPAH2MemoryEnDur")
//@PropertySources({@PropertySource("classpath:configurations_bases_jpa/configuration_POSTGRES_Server.properties")})
@EnableTransactionManagement
//Active l'AOP
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "levy.daniel.application")
public class ConfigurateurSpringJPAH2MemoryEnDur {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ConfigurateurSpringJPAH2MemoryEnDur.class);

	// *************************METHODES************************************/

	
	
	/**
	* CONSTRUCTEUR D'ARITE NULLE.
	*/
	public ConfigurateurSpringJPAH2MemoryEnDur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * .<br/>
	 * <br/>
	 *
	 * @return : javax.persistence.EntityManagerFactory :  .<br/>
	 */
	@Bean(value = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		
		EntityManagerFactory entityManagerFactory = null;
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = null;
				
		final MutablePersistenceUnitInfoSimple mutablePersistenceUnitInfo 
				= new MutablePersistenceUnitInfoSimple();
		
		/* PersistenceUnitName. */
		mutablePersistenceUnitInfo.setPersistenceUnitName(
				"persistence_unit_base-spring-configuration-annotations");
		
		/* PersistenceProviderClassName. */
		mutablePersistenceUnitInfo.setPersistenceProviderClassName(
				this.vendorAdapterHibernate().getClass().getName());
		
		/* TransactionType. */
		mutablePersistenceUnitInfo.setTransactionType(
				PersistenceUnitTransactionType.RESOURCE_LOCAL);
		
		/* DataSource JTA*/
		mutablePersistenceUnitInfo.setJtaDataSource(null);
		
		/* DataSource NON JTA*/
		mutablePersistenceUnitInfo.setNonJtaDataSource(this.dataSource());
		
		/* MappingFileNames. */
//		mutablePersistenceUnitInfo.addMappingFileName(mappingFileName);
		
		/* JarFileUrls. */
//		mutablePersistenceUnitInfo.addJarFileUrl(jarFileUrl);
		
		/* PersistenceUnitRootUrl. */
		mutablePersistenceUnitInfo.setPersistenceUnitRootUrl(null);
		
		/* ManagedClassNames *******************/
		mutablePersistenceUnitInfo.addManagedClassName("levy.daniel.application.model.persistence.metier.employee.entities.jpa.EmployeeEntityJPA");
		mutablePersistenceUnitInfo.addManagedClassName("levy.daniel.application.model.persistence.metier.person.entities.jpa.PersonEntityJPA");
		

		/* ManagedPackages. */
//		mutablePersistenceUnitInfo.addManagedPackage(packageName);
		
		/* ExcludeUnlistedClasses. */
		mutablePersistenceUnitInfo.setExcludeUnlistedClasses(false);
		
		/* SharedCacheMode. */
		mutablePersistenceUnitInfo.setSharedCacheMode(
				SharedCacheMode.UNSPECIFIED);
		
		/* ValidationMode. */
		mutablePersistenceUnitInfo.setValidationMode(ValidationMode.AUTO);
		
		/* Properties. ************/
		mutablePersistenceUnitInfo.setProperties(this.hibernateProperties());
		
		/* PersistenceXMLSchemaVersion (version de JPA). */
		mutablePersistenceUnitInfo.setPersistenceXMLSchemaVersion("2.1");
		
		/* PersistenceProviderPackageName. */
		mutablePersistenceUnitInfo.setPersistenceProviderPackageName(null);
				
		final Map<String, Object> integration	
			= new HashMap<String, Object>();
				
		final EntityManagerFactoryBuilder entityManagerFactoryBuilder 
			= Bootstrap.getEntityManagerFactoryBuilder(
					mutablePersistenceUnitInfo, integration);
		
		entityManagerFactory = entityManagerFactoryBuilder.build();
				
		// AFFICHAGE
		System.out.println();
		System.out.println(mutablePersistenceUnitInfo.toStringAmeliore());


		return entityManagerFactory;
		
	} // Fin de entityManagerFactory().____________________________________
	
	    
    
    /**
     * .<br/>
     * <br/>
     *
     * @return : DataSource :  .<br/>
     */
	@Bean(value = "DataSource")
	public DataSource dataSource() {

		final HikariDataSource dataSource 
			= DataSourceH2MemoryHikariEnDur.getHikariDataSource();

		return dataSource;
		
	} // Fin de dataSource().______________________________________________
	

	
	/**
	 * <b>fournit un Bean précisant que l'ORM est HIBERNATE</b>.<br/>
	 *
	 * @return : JpaVendorAdapter : 
	 * org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter.<br/>
	 */
    @Bean(value = "JpaVendorAdapter")
	public JpaVendorAdapter vendorAdapterHibernate() {
		
		final JpaVendorAdapter vendorAdapter 
      		= new HibernateJpaVendorAdapter();
		
		return vendorAdapter;
		
	} // Fin de vendorAdapterHibernate().__________________________________

	
	
	/**
	 * <b>fournit un TransactionManager pour la 
	 * gestion des transactions au 
	 * CONTEXTE SPRING</b> pour l'injection.<br/>
	 *
	 * @param pEntityManagerFactory : 
	 * javax.persistence.EntityManagerFactory.<br/>
	 * 
	 * @return : PlatformTransactionManager.<br/>
	 */
	@Bean
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory pEntityManagerFactory) {

		final JpaTransactionManager transactionManager 
			= new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(pEntityManagerFactory);

		return transactionManager;
		
	} // Fin de transactionManager(...).___________________________________

	
    
    /**
     * .<br/>
     * <br/>
     *
     * @return : Properties :  .<br/>
     */
    @Bean
    public Properties hibernateProperties() {
    	
        final Properties hibernateProperties = new Properties();
        
        hibernateProperties.setProperty(
        		"hibernate.hbm2ddl.auto", "create");
        
        hibernateProperties.setProperty(
        		"hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        
        hibernateProperties.setProperty(
        		"hibernate.show_sql", "false");
        
        hibernateProperties.setProperty(
        		"hibernate.format_sql", "true");
        
        hibernateProperties.setProperty(
        		"hibernate.use_sql_comments", "true");
        
        hibernateProperties.setProperty(
        		"hibernate.generate_statistics", "true");
        
        hibernateProperties.setProperty(
        		"hibernate.cache.use_second_level_cache", "false");
        
        hibernateProperties.setProperty(
        		"hibernate.cache.use_query_cache", "false");
 
        return hibernateProperties;
        
    } // Fin de hibernateProperties()._____________________________________
	

	
	/**
	 * <b>fournit un PersistenceExceptionTranslationPostProcessor
	 * au CONTEXTE SPRING</b> pour la gestion des Exceptions.<br/>
	 *
	 * @return : PersistenceExceptionTranslationPostProcessor.<br/>
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor 
						persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	} // Fin de persistenceExceptionTranslationPostProcessor().____________

	
	
} // FIn DE LA CLASSE ConfigurateurSpringJPAPostgresServerEnDur.-------------
