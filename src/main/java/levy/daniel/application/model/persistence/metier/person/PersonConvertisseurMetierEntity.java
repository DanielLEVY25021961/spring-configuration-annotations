package levy.daniel.application.model.persistence.metier.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.person.IPerson;
import levy.daniel.application.model.metier.person.impl.Person;
import levy.daniel.application.model.persistence.metier.person.entities.jpa.PersonEntityJPA;

/**
 * CLASSE PersonConvertisseurMetierEntity :<br/>
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
 * @since 25 juil. 2019
 *
 */
public class PersonConvertisseurMetierEntity {

	// ************************ATTRIBUTS************************************/

	/**
	 * FORMAT pour affichage formaté à la console 
	 * des IEmployee.<br/>
	 * "id=%1$-5d prénom = %2$-15s nom = %3$-20s dateNaissance = %4$-20s".
	 */
	public static final String FORMAT_PERSON 
		= "id=%1$-5d prénom = %2$-15s nom = %3$-20s dateNaissance = %4$-20s";

	/**
	 * "line.separator".<br/>
	 */
	public static final String LINE_SEPARATOR = "line.separator";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(PersonConvertisseurMetierEntity.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private PersonConvertisseurMetierEntity() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * retourne une String de la forme 
	 * <code>[annee-mois-jour]</code> 
	 * à partir d'une java.time.LocalDate pDate.<br/>
	 * Par exemple, retourne <b>"2019-06-13"</b> 
	 * pour le 13 juin 2019.<br/>
	 * <br/>
	 * - retourne null si pDate == null.<br/>
	 * <br/>
	 *
	 * @param pDate : LocalDate : date à formater.
	 * 
	 * @return : String : affichage de la date formatée.<br/>
	 */
	private static String formaterLocalDateEnString(
			final LocalDate pDate) {
		
		/* retourne null si pDate == null. */
		if (pDate == null) {
			return null;
		}
		
		/* formateur de type 2019-06-13 
		 * (13 juin 2019)*/
		final DateTimeFormatter formatter 
			= DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		final String resultat = pDate.format(formatter);
				
		return resultat;
		
	} // Fin de formaterLocalDateEnString(...).____________________________

	
	
	/**
	 * <b>Crée un OBJET METIER à partir d'une EntityJPA</b>.<br/>
	 * <ul>
	 * <li>retourne un OBJET METIER avec toutes les valeurs 
	 * à null si pEntityJPA == null.</li>
	 * </ul>
	 *
	 * @param pEntityJPA : PersonEntityJPA.<br/>
	 * 
	 * @return : IPerson.<br/>
	 */
	public static IPerson creerObjetMetierAPartirEntityJPA(
			final PersonEntityJPA pEntityJPA) {

		synchronized (PersonConvertisseurMetierEntity.class) {
			
			final IPerson objet 
				= new Person();
			
			if (pEntityJPA != null) {
				
				objet.setId(pEntityJPA.getId());
				objet.setFirstName(pEntityJPA.getFirstName());
				objet.setLastName(pEntityJPA.getLastName());
				objet.setBirthDate(pEntityJPA.getBirthDate());
				
			}
							
			return objet;
		
		} // Fin de synchronized._______________________
		
	} // Fin de creerObjetMetierAPartirEntityJPA(...)._____________________
	
	
		
	/**
	 * <b>convertit une ENTITY JPA en OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pEntity == null.</li>
	 * <li>récupère les valeurs dans le pEntity.</li>
	 * <li>injecte les valeurs de l'ENTITY dans un OBJET METIER.</li>
	 * </ul>
	 *
	 * @param pEntity : PersonEntityJPA.<br/>
	 * 
	 * @return : IPerson : Objet métier.<br/>
	 */
	public static IPerson convertirEntityJPAEnObjetMetier(
			final PersonEntityJPA pEntity) {
		
		synchronized (PersonConvertisseurMetierEntity.class) {
			
			IPerson objet = null;
			
			if (pEntity != null) {
				
				/* récupère les valeurs dans l'Entity. */
				/* injecte les valeurs typées dans un OBJET METIER. */
				objet 
					= new Person(
							pEntity.getId()
							, pEntity.getFirstName(), pEntity.getLastName()
							, pEntity.getBirthDate());
			}
			
			return objet;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirEntityJPAEnObjetMetier(...).______________________
	

	
	/**
	 * convertit une Liste d'ENTITIES JPA 
	 * en liste d'OBJETS METIER et la retourne.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * - n'insère dans la liste résultat que les Entities non null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;PersonEntityJPA&gt;.<br/>
	 * 
	 * @return : List&lt;IPerson&gt;.<br/>
	 */
	public static List<IPerson> convertirListEntitiesJPAEnModel(
			final List<PersonEntityJPA> pList) {
		
		synchronized (PersonConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<IPerson> resultat 
				= new ArrayList<IPerson>();
			
			for (final PersonEntityJPA entity : pList) {
				
				/* n'insère dans la liste résultat 
				 * que les Entities non null. */
				if (entity != null) {
					
					final IPerson objet 													
						= convertirEntityJPAEnObjetMetier(entity);
					
					resultat.add(objet);
					
				}
			}
			
			return resultat;
			
		} // Fin de synchronized.______________________
		
	} // Fin de convertirListEntitiesJPAEnModel(...).______________________
	
	
		
	/**
	 * <b>crée une ENTITY JPA à partir d'un OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne une Entity JPA avec toutes les valeurs 
	 * à null si pObject == null.</li>
	 * </ul>
	 *
	 * @param pObject : IPerson.<br/>
	 *  
	 * @return : PersonEntityJPA.<br/>
	 */
	public static PersonEntityJPA creerEntityJPA(
			final IPerson pObject) {
		
		synchronized (PersonConvertisseurMetierEntity.class) {
			
			final PersonEntityJPA entity 
				= new PersonEntityJPA();
			
			if (pObject != null) {
				
				entity.setId(pObject.getId());
				entity.setFirstName(pObject.getFirstName());
				entity.setLastName(pObject.getLastName());
				entity.setBirthDate(pObject.getBirthDate());
				
			}
			
			return entity;
					
		} // Fin de synchronized.______________________
		
	} // Fin de creerEntityJPA(...)._______________________________________

	
	
	/**
	 * <b>convertit un OBJET METIER en ENTITY JPA</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs typées dans l'objet métier.</li>
	 * <li>injecte les valeurs de l'objet métier dans une ENTITY.</li>
	 * </ul>
	 *
	 * @param pObject : IPerson : Objet métier.<br/>
	 * 
	 * @return : PersonEntityJPA : ENTITY JPA.<br/>
	 */
	public static PersonEntityJPA convertirObjetMetierEnEntityJPA(
			final IPerson pObject) {
		
		synchronized (PersonConvertisseurMetierEntity.class) {
			
			PersonEntityJPA resultat = null;
			
			if (pObject != null) {
								
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new PersonEntityJPA(
							pObject.getId()
							, pObject.getFirstName(), pObject.getLastName()
							, pObject.getBirthDate());
				
			}
						
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirObjetMetierEnEntityJPA(...).______________________
	

	
	/**
	 * convertit une Liste d'OBJETS METIER en liste 
	 * d'ENTITIES JPA.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPerson&gt;
	 * 
	 * @return : List&lt;PersonEntityJPA&gt;.<br/>
	 */
	public static List<PersonEntityJPA> convertirListModelEnEntitiesJPA(
			final Iterable<IPerson> pList) {
		
		synchronized (PersonConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<PersonEntityJPA> resultat 
				= new ArrayList<PersonEntityJPA>();
			
			for (final IPerson objet : pList) {
				
				if (objet != null) {
					
					final PersonEntityJPA entity 
						= convertirObjetMetierEnEntityJPA(objet);
					
					resultat.add(entity);
					
				}
			}
			
			return resultat;

		} // Fin de synchronized._______________________
		
	} // Fin de convertirListModelEnEntitiesJPA(...).______________________
	

	
	/**
	 * <b>retourne une String pour affichage formaté 
	 * (FORMAT_UTILISATEURCERBERE) 
	 * d'une liste d'entities</b>.<br/>
	 * <ul>
	 * <li>chaque item de la liste est retournée 
	 * sur une ligne formatée.</li>
	 * <li>utilise le saut de la plateforme comme saut à la ligne 
	 * (<code>System.getProperty("line.separator")</code>).</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * - n'affiche pas un item null dans la liste 
	 * passée en paramètre.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;PersonEntityJPA&gt; : 
	 * liste d'Entities.<br/>
	 * 
	 * @return : String : affichage.<br/>
	 */
	public static String afficherFormateListEntities(
			final List<PersonEntityJPA> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IPerson entity : pList) {
			
			/* n'affiche pas une Entity null 
			 * dans la liste passée en paramètre. */
			if (entity != null) {
				
				final String stringformatee 
					= String.format(
							Locale.getDefault()
								, FORMAT_PERSON
								, entity.getId()
								, entity.getFirstName(), entity.getLastName()
								, formaterLocalDateEnString(entity.getBirthDate()));
				
				stb.append(stringformatee);
				
				/* utilise le saut de la plateforme. */
				stb.append(System.getProperty(LINE_SEPARATOR));
			}
		}
		
		return stb.toString();
		
	} //Fin de afficherFormateListEntities(...).___________________________
	

	
	/**
	 * <b>retourne une String pour affichage formaté 
	 * (FORMAT_UTILISATEURCERBERE) 
	 * d'une liste d'objets métier</b>.<br/>
	 * <ul>
	 * <li>chaque item de la liste est retournée 
	 * sur une ligne formatée.</li>
	 * <li>utilise le saut de la plateforme comme saut à la ligne 
	 * (<code>System.getProperty("line.separator")</code>).</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * - n'affiche pas un item null dans la liste 
	 * passée en paramètre.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;IPerson&gt; : 
	 * liste d'Entities.<br/>
	 * 
	 * @return : String : affichage.<br/>
	 */
	public static String afficherFormateListObjets(
			final List<IPerson> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IPerson entity : pList) {
			
			/* n'affiche pas une Entity null 
			 * dans la liste passée en paramètre. */
			if (entity != null) {
				
				final String stringformatee 
					= String.format(
							Locale.getDefault()
								, FORMAT_PERSON
								, entity.getId()
								, entity.getFirstName(), entity.getLastName()
								, formaterLocalDateEnString(entity.getBirthDate()));
				
				stb.append(stringformatee);
				
				/* utilise le saut de la plateforme. */
				stb.append(System.getProperty(LINE_SEPARATOR));
			}
		}
		
		return stb.toString();
		
	} //Fin de afficherFormateListObjets(...)._____________________________
	
	
	
} // FIN DE LA CLASSE PersonConvertisseurMetierEntity.-----------------------
