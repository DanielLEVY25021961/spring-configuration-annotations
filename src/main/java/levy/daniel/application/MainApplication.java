package levy.daniel.application;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import levy.daniel.application.model.metier.developpeur.IDeveloppeur;
import levy.daniel.application.model.metier.developpeur.impl.Developpeur;
import levy.daniel.application.model.metier.societe.impl.Societe;


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
	 * .<br/>
	 */
	private static transient ApplicationContext context;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MainApplication.class);

	// *************************METHODES************************************/
	
	/**
	 * .<br/>
	 *
	 * @param pArgs :  :  .<br/>
	 */
	public static void mainByName(
			final String[] pArgs) {
		
		instancierContext();
		
		System.out.println();
		final Societe societe = (Societe) recupererBeanByName("societe");
		
		System.out.println();
		afficherSociete(societe);
		System.out.println();
		
		final Developpeur chefDeveloppeur = (Developpeur) recupererBeanByName("chefDeveloppeur");
		
		if (chefDeveloppeur != null) {
			System.out.println();
			System.out.println("CHEF DEVELOPPEUR [(Developpeur) recupererBeanByName(\"chefDeveloppeur\")] : " + chefDeveloppeur.toString());
		} else {
			System.out.println("CHEF DEVELOPPEUR [(Developpeur) recupererBeanByName(\"chefDeveloppeur\")] : null");
		}
		
		
		final Developpeur developpeur = (Developpeur) recupererBeanByName("Developpeur");
		
		if (developpeur != null) {
			System.out.println();
			System.out.println("DEVELOPPEUR [(Developpeur) recupererBeanByName(\"Developpeur\"))] : " + developpeur.toString());
		} else {
			System.out.println("DEVELOPPEUR [(Developpeur) recupererBeanByName(\"Developpeur\")] : null");
		}
		
	} // Fin de mainByName(...).___________________________________________
	
	
 
	/**
	 * .<br/>
	 *
	 * @param pArgs :  :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		
		instancierContext();
		
		System.out.println();
		final Societe societe = (Societe) recupererBeanByClass(Societe.class);
		
		System.out.println();
		afficherSociete(societe);
		System.out.println();
		
		final Developpeur chefDeveloppeur = (Developpeur) recupererBeanByClass(Developpeur.class);
		
		if (chefDeveloppeur != null) {
			System.out.println();
			System.out.println("CHEF DEVELOPPEUR [(Developpeur) recupererBeanByClass(Developpeur.class)] : " + chefDeveloppeur.toString());
		} else {
			System.out.println("CHEF DEVELOPPEUR [(Developpeur) recupererBeanByClass(Developpeur.class)] : null");
		}
		
		
		final Developpeur developpeur = (Developpeur) recupererBeanByClass(Developpeur.class);
		
		if (developpeur != null) {
			System.out.println();
			System.out.println("DEVELOPPEUR [(Developpeur) recupererBeanByClass(Developpeur.class)] : " + developpeur.toString());
		} else {
			System.out.println("DEVELOPPEUR [(Developpeur) recupererBeanByClass(Developpeur.class)] : null");
		}
		
	} // Fin de main(...)._________________________________________________


	
	/**
	 * Instancie un CONTEXT SPRING 
	 * décrit dans une CLASSE JAVA
	 */
	private static void instancierContext() {
		
		context = new AnnotationConfigApplicationContext(
				SpringConfigurationClass.class);
		
		String[] beansTableau = null;
		
		if (context != null) {
			beansTableau = context.getBeanDefinitionNames();
		} else {
			final String message = "LE CONTEXT N'A PU ETRE INSTANCIE";			
			LOG.fatal(message);
		}
		
		if (beansTableau != null) {
			System.out.println("CONTENU DU CONTEXTE (context.getBeanDefinitionNames()) : ");
			for (int i = 0; i < beansTableau.length; i++) {
				System.out.println(beansTableau[i].toString());
			}
		}
		
	} // Fin de instancierContext()._______________________________________
	

	
	/**
	 * récupère un Bean dans le context SPRING 
	 * via son <b>name</b>.<br/>
	 * <ul>
	 * <li>il s'agit bien de la valeur dans l'attribut 
	 * <b>name</b> (et pas id) du Bean dans le fichier de configuration XML.</li>
	 * <li>retourne le Bean sous la forme Object (le caster ensuite).</li>
	 * </ul>
	 * - retourne null si le context == null.<br/>
	 * - retourne null si pName est blank.<br/>
	 * - retourne null si il n'existe pas de Bean de name pName dans le XML.<br/>
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
	 * <li>retourne le Bean sous la forme Object (le caster ensuite).</li>
	 * </ul>
	 * - retourne null si le context == null.<br/>
	 * - retourne null si il n'existe pas de Bean de name pName dans le XML.<br/>
	 * <br/>
	 *
	 * @param pName : Class : nom de la Class du bean dans le context SPRING.
	 * 
	 * @return : Object : le Bean de class pName 
	 * dans le context (Object).<br/>
	 */
	private static Object recupererBeanByClass(
			final Class<?> pName) {
		
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
			bean = context.getBean(pName);
		} catch (BeansException e) {
			
			final String message 
				= "le Bean de class " 
						+ pName 
						+ " est introuvable dans le context";
			
			if (LOG.isDebugEnabled()) {
				LOG.debug(message, e);
			}
		}
		
		return bean;
		
	} // Fin de recupererBeanByName(...).__________________________________
	

	
	/**
	 * .<br/>
	 *
	 * @param pSociete :  :  .<br/>
	 */
	private static void afficherSociete(
			final Societe pSociete) {
		
		if (pSociete != null) {
			
			final String message1 = "BEAN RECUPERE DANS LE CONTEXTE : ";
					
			System.out.println(message1 + pSociete.toString());
			
			final IDeveloppeur chefDeveloppeur 
				= pSociete.getChefDeveloppeur();
			
			if (chefDeveloppeur != null) {
				
				final String message2 
					= "le chef développeur dans le Bean récupéré dans le context est : ";
				
				System.out.println(message2 + chefDeveloppeur.toString());
			}
			
			final IDeveloppeur developpeur 
				= pSociete.getDeveloppeur();
			
			if (developpeur != null) {
				
				final String message3 
					= "le développeur dans le Bean récupéré dans le context est : ";
				
				System.out.println(message3 + developpeur.toString());
			}
			
		}
		
	} // Fin de afficherSociete(...).______________________________________
	
	
	
} // FIN DE LA CLASSE MainApplication.---------------------------------------
