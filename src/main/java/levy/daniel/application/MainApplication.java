package levy.daniel.application;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import levy.daniel.application.model.metier.person.IPerson;
import levy.daniel.application.model.metier.person.impl.Person;
import levy.daniel.application.model.persistence.metier.person.IPersonDAO;


/**
 * CLASSE MainApplication :<br/>
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
 * @author adminLocal Lévy
 * @version 1.0
 * @since 12 nov. 2018
 *
 */
public class MainApplication {

	// ************************ATTRIBUTS************************************/

	/**
	 *AnnotationConfigApplicationContext.<br/>
	 */
	private static transient AnnotationConfigApplicationContext context;

	/**
	 * IPersonDAO.
	 */
	private static transient IPersonDAO personDAO;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MainApplication.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public MainApplication() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
 
	/**
	 * Point d'entrée de l'application.
	 *
	 * @param pArgs : String[] :  .<br/>
	 * 
	 * @throws Exception 
	 */
	public static void main(
			final String... pArgs) throws Exception {
		
		instancierContext();
		
		afficherBeansDuContexte();
		
		afficherProfilsActifsDuContexte();
		
		jouerJeuEssai();
		
	} // Fin de main(...)._________________________________________________


	
	/**
	 * Instancie un CONTEXT SPRING.
	 * <ol>
	 * <li>instancie un AnnotationConfigApplicationContext SPRING.
	 * <br/><code><b>context = 
	 * new AnnotationConfigApplicationContext();</b></code></li>
	 * <li>déclare éventuellement le profil actif. (PROD, DEV, TEST, ...).
	 * <br/><code><b>context.getEnvironment()
	 * .setActiveProfiles("PROFIL_PROD_POSTGRES_SERVER");</b></code>
	 * <br/>ATTENTION : Il est INDISPENSABLE de déclarer un Profile ACTIF 
	 * si il existe plusieurs classes de Config avec différents profils 
	 * dans le code.<br/>
	 * ATTENTION : toujours déclarer les profils actifs AVANT 
	 * de register les éventuelles classes de Config SPRING.</li>
	 * <li>enregistre éventuellement les classes de <i>Config SPRING</i> 
	 * si on veut utiliser une <b>configuration par classe Java</b>.<br/> 
	 * La classe de Config Java doit alors être annotée avec 
	 * <code>ComponentScans({ComponentScan("packageAScanner")})</code> 
	 * pour scanner les BEANS SPRING.
	 * <br/>ATTENTION : si les classes de Config SPRING 
	 * ne sont pas register ici, leurs annotations 
	 * <code>ComponentScan(basePackages = "packageAScanner")</code> 
	 * seront inopérantes.
	 * <ul>
	 * <li>Soit on fait ici 
	 * <code><b>context.register(classeConfig.class);</b></code> 
	 * sur des classes de Config Spring <i>annotées avec 
	 * "ComponentScan(basePackages = "packageAScanner")"</i> 
	 * et on n'a pas à insérer 
	 * <code><b>context.scan("packageAScanner");</b></code> 
	 * dans cette présente méthode d'instanciation du CONTEXTE SPRING.</li>
	 * <li>Soit on ne déclare ici aucune des classes de Config SPRING 
	 * en laissant SPRING trouver seul les classe de Config à l'aide du SCAN 
	 * mais <i>il faut déclarer dans la présente méthode les Packages 
	 * contenant les BEANS SPRING à scanner.</i> 
	 * <br/> en insérant dans la présente méthode : 
	 * <code><b>context.scan("packageAScanner")</b></code></li>
	 * </ul>
	 * <li>précise éventuellement dans quel Package SPRING 
	 * doit chercher les COMPONENTS 
	 * si on utilise pas de classe de Config SPRING.
	 * <br/>on utilise alors la <b>configuration de SPRING par annotations.</b>
	 * <br/><code><b>context.scan(packageAScanner);</b></code></li>
	 * <li>rafraîchit le CONTEXT SPRING.</li>
	 * </ol>
	 */
	private static void instancierContext() {
		
		// INSTANCIATION DU CONTEXTE SPRING. 
		/* instancie un AnnotationConfigApplicationContext. */
		context = new AnnotationConfigApplicationContext();
		
		/* déclare éventuellement le profil actif. */
		// ATTENTION : doit être AVANT la déclaration de la classe 
		// de configuration (context.register(.Class)).
		context.getEnvironment().setActiveProfiles("PROFIL_PROD_POSTGRES_SERVER");
//		context.getEnvironment().setActiveProfiles("PROFIL_TEST_H2_MEMORY");
//		context.getEnvironment().setActiveProfiles("PROFIL_TEST_H2_FILE");
		
		/* enregistre éventuellement les classes de Config SPRING 
		 * si on veut utiliser une configuration par classe Java. 
		 * La classe de Config Java doit alors être annotée avec 
		 * @ComponentScans({@ComponentScan("packageAScanner")}) 
		 * pour scanner les BEANS SPRING. */
//		context.register(ConfigurateurSpringJPAPostgresServerEnDur.class);
//		context.register(ConfigurateurSpringJPAH2MemoryEnDur.class);
		
		/* précise dans quel Package SPRING doit chercher les COMPONENTS 
		 * si on utilise pas de classe de Config SPRING. 
		 * on utilise alors la configuration de SPRING par annotations.*/
		context.scan("levy.daniel.application");
		
		/* rafraîchit le CONTEXT SPRING. */
		context.refresh();	
		
		personDAO = (IPersonDAO) context.getBean("PersonDAOJPASpring");
		
	} // Fin de instancierContext()._______________________________________
	

	
	/**
	 * affiche les BEANS SPRING contenus dans le contexte.
	 */
	private static void afficherBeansDuContexte() {
		
		String[] beansTableau = null;
		
		if (context != null) {
			beansTableau = context.getBeanDefinitionNames();
		} else {
			final String message = "LE CONTEXT N'A PU ETRE INSTANCIE";			
			LOG.fatal(message);
		}
		
		if (beansTableau != null) {
			
			System.out.println();
			System.out.println("****** BEANS CONTENUS DANS LE CONTEXTE SPRING (context.getBeanDefinitionNames()) : ******");
			
			for (int i = 0; i < beansTableau.length; i++) {
				System.out.println(beansTableau[i].toString());
			}
		}
		
	} // Fin de afficherBeansDuContexte().___________________________________
	

	
	/**
	 * affiche les PROFILS ACTIFS contenus dans le contexte.
	 */
	private static void afficherProfilsActifsDuContexte() {
		
		String[] activeProfilesTableau = null;
		
		if (context != null) {
			
			activeProfilesTableau 
				= context.getEnvironment().getActiveProfiles();
		}
		
		if (activeProfilesTableau != null) {
			
			System.out.println();
			System.out.println("****** PROFILS ACTIFS DANS LE CONTEXTE SPRING (context.getEnvironment().getActiveProfiles()) : ******");
			
			for (int i = 0; i < activeProfilesTableau.length; i++) {
				System.out.println(activeProfilesTableau[i].toString());
			}
			
		}
		
	} // Fin de afficherProfilsActifsDuContexte()._________________________
	
	
	
	/**
	 * récupère un Bean dans le context SPRING 
	 * via son <b>name</b> dans le contexte.<br/>
	 * <ul>
	 * <li>il s'agit bien de la valeur dans l'attribut 
	 * <b>name</b> (et pas id) du Bean dans le contexte.</li>
	 * <li>retourne le Bean sous la forme Object (le caster ensuite).</li>
	 * <li>utilise <code><b>context.getBean(String pName)</b></code></li>
	 * <li>Par exemple, 
	 * <code><b>recupererBeanByName("PersonDAOJPASpring")</b></code> 
	 * retourne le BEAN SPRING "PersonDAOJPASpring" 
	 * si il est présent dans le contexte.</li>
	 * </ul>
	 * - retourne null si le context == null.<br/>
	 * - retourne null si pName est blank.<br/>
	 * - retourne null si il n'existe pas de Bean 
	 * de name pName dans le contexte.<br/>
	 * <br/>
	 *
	 * @param pName : String : nom du bean dans le context SPRING.
	 * 
	 * @return : Object : le Bean de name pName 
	 * dans le context (Object).<br/>
	 */
	private static Object recupererBeanByName(
			final String pName) {
		
		/* retourne null si le context == null. */
		if (context == null) {
			
			if (LOG.isFatalEnabled()) {
				
				final String message = "LE CONTEXT N'A PU ETRE INSTANCIE";
				
				LOG.fatal(message);
			}
			return null;
		}
		
		
		/* retourne null si pName est blank. */
		if (StringUtils.isBlank(pName)) {
			return null;
		}
		
		Object bean = null;
		
		try {
			
			// RETRIEVE
			bean = context.getBean(pName);
			
		} catch (BeansException e) {
			
			final String message 
				= "le Bean nommé " 
						+ pName 
						+ " est introuvable dans le context";
			
			if (LOG.isDebugEnabled()) {
				LOG.debug(message, e);
			}
		}
		
		return bean;
		
	} // Fin de recupererBeanByName(...).__________________________________
	

	
	/**
	 * récupère un Bean dans le context SPRING 
	 * via son <b>.class</b>.<br/>
	 * <ul>
	 * <li>ATTENTION : jette une Exception si il existe plusieurs 
	 * BEANS de même classe dans le contexte.</li>
	 * <li>retourne le Bean sous la forme Object (le caster ensuite).</li>
	 * <li>utilise <code><b>context.getBean(Class<?> pClass)</b></code></li>
	 * <li>Par exemple, 
	 * <code>recupererBeanByName(PersonDAOJPASpring.class)</code> 
	 * retourne le BEAN SPRING de classe PersonDAOJPASpring 
	 * si il est présent dans le contexte et si il est unique.</li>
	 * </ul>
	 * - retourne null si le context == null.<br/>
	 * - retourne null si il n'existe pas de Bean de Class<?> pClass 
	 * dans le contexte.<br/>
	 * <br/>
	 *
	 * @param pClass : Class : .Class du bean dans le context SPRING.
	 * 
	 * @return : Object : le Bean de class pClass 
	 * dans le context (Object).<br/>
	 */
	private static Object recupererBeanByClass(
			final Class<?> pClass) {
		
		/* retourne null si le context == null. */
		if (context == null) {
			
			if (LOG.isFatalEnabled()) {
				
				final String message = "LE CONTEXT N'A PU ETRE INSTANCIE";
				
				LOG.fatal(message);
			}
			return null;
		}
		
			
		Object bean = null;
		
		try {
			
			// RETRIEVE *********************
			bean = context.getBean(pClass);
			
		} catch (BeansException e) {
			
			final String message 
				= "le Bean de class " 
						+ pClass 
						+ " est introuvable dans le context";
			
			if (LOG.isDebugEnabled()) {
				LOG.debug(message, e);
			}
		}
		
		return bean;
		
	} // Fin de recupererBeanByName(...).__________________________________

	
	
	/**
	 * .<br/>
	 * <br/>
	 * : void :  .<br/>
	 * @throws Exception 
	 */
	private static void jouerJeuEssai() throws Exception {
		
		IPerson personPersistente1 = null;
		IPerson personPersistente2 = null;
		IPerson personPersistente3 = null;
		
		final IPerson person1 
			= new Person("firstName1", "LastName1", LocalDate.of(2019, 2, 22));
		
		final IPerson person2 
			= new Person(null, "LastName2", LocalDate.of(2019, 5, 29));
		
		final IPerson person3 
			= new Person(null, "LastName3", null);
		
//		final IPersonDAO personDAO = new PersonDAOJPASpring();
		
		personDAO.create(person1);
		personDAO.create(person2);
		personDAO.create(person3);
		
		personPersistente2 = personDAO.retrieve(person2);
		personPersistente3 = personDAO.retrieve(person3);
		
		System.out.println("person2 : " + person2.toString());
		System.out.println("personPersistente2 : " + personPersistente2.toString());
		
		System.out.println("person3 : " + person3.toString());
		System.out.println("personPersistente3 : " + personPersistente3.toString());
		
	} // Fin de jouerJeuEssai().___________________________________________


	
	/**
	 * Getter .
	 *
	 * @return this.personDAO : IPersonDAO.<br/>
	 */
	public static IPersonDAO getPersonDAO() {
		return personDAO;
	}


	
	/**
	* .
	*
	* @param pPersonDAO : IPersonDAO : 
	* valeur à passer à this.personDAO.<br/>
	*/
	@Autowired(required = true)
	@Qualifier("PersonDAOJPASpring")
	public static void setPersonDAO(
			final IPersonDAO pPersonDAO) {
		
		personDAO = pPersonDAO;
		
		System.out.println("DANS LE SETTER setPersonDAO(...)");
	}

	

	
} // FIN DE LA CLASSE MainApplication.---------------------------------------
