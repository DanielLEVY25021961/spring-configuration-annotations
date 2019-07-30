package levy.daniel.application.model.utilitaires.jpa.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * CLASSE DataSourcePostgresHikariEnDur :<br/>
 * ne lit pas dans un fichier .properties.<br/>
 * utilise des valeurs codées en dur dans la classe.<br/>
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
 * @since 26 juil. 2019
 *
 */
public final class DataSourcePostgresHikariEnDur {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * HikariConfig.
	 */
	private static transient HikariConfig hikariConfig = new HikariConfig();
	
    /**
     * HikariDataSource.
     */
    private static transient HikariDataSource hikariDataSource;
    
    static {
    	
    	hikariConfig.setDriverClassName("org.postgresql.Driver");
    	
    	hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/base-spring-configuration-annotations");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("postgres");
        
        hikariConfig.addDataSourceProperty("cachePrepStmts" , "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize" , "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
        
        hikariConfig.setMaximumPoolSize(50);
        hikariConfig.setMaxLifetime(60000);
        hikariConfig.setMinimumIdle(10);
        hikariConfig.setIdleTimeout(45000);
        hikariConfig.setConnectionTimeout(30000);
        
        hikariDataSource = new HikariDataSource(hikariConfig);
    }
    
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(DataSourcePostgresHikariEnDur.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour bloquer l'instanciation.<br/>
	 */
	private DataSourcePostgresHikariEnDur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * retourne une java.sql.Connection à la Base de Données.<br/>
	 *
	 * @return java.sql.Connection
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return hikariDataSource.getConnection();
	} // Fin de getConnection().___________________________________________


	
	/**
	 * Getter de la HikariConfig.
	 *
	 * @return this.hikariConfig : HikariConfig.<br/>
	 */
	public static final HikariConfig getHikariConfig() {
		return hikariConfig;
	} // Fin de getHikariConfig()._________________________________________


	
	/**
	 * Getter de la HikariDataSource.
	 *
	 * @return this.hikariDataSource : HikariDataSource.<br/>
	 */
	public static final HikariDataSource getHikariDataSource() {
		return hikariDataSource;
	} // Fin de getHikariDataSource()._____________________________________
	
	
	
} // FIN DE LA CLASSE DataSourcePostgresHikariEnDur.-------------------------
