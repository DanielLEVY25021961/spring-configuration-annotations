package levy.daniel.application.model.persistence.metier.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.employee.IEmployee;
import levy.daniel.application.model.metier.employee.impl.Employee;
import levy.daniel.application.model.persistence.metier.employee.entities.jpa.impl.EmployeeEntityJPA;

/**
 * CLASSE EmployeeConvertisseurMetierEntity :<br/>
 * classe <b>utilitaire</b> chargée de <b>convertir 
 * une ENTITY en OBJET METIER</b> et de <b>convertir un
 * OBJET METIER en ENTITY</b>.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 25 juil. 2019
 *
 */
public class EmployeeConvertisseurMetierEntity {

	// ************************ATTRIBUTS************************************/

	/**
	 * FORMAT pour affichage formaté à la console 
	 * des IEmployee.<br/>
	 * "id=%1$-5d prénom = %2$-15s nom = %3$-20s".
	 */
	public static final String FORMAT_EMPLOYEE 
		= "id=%1$-5d prénom = %2$-15s nom = %3$-20s";

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
		= LogFactory.getLog(EmployeeConvertisseurMetierEntity.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private EmployeeConvertisseurMetierEntity() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * <b>Crée un OBJET METIER à partir d'une EntityJPA</b>.<br/>
	 * <ul>
	 * <li>retourne un OBJET METIER avec toutes les valeurs 
	 * à null si pEntityJPA == null.</li>
	 * </ul>
	 *
	 * @param pEntityJPA : EmployeeEntityJPA.<br/>
	 * 
	 * @return : IEmployee.<br/>
	 */
	public static IEmployee creerObjetMetierAPartirEntityJPA(
			final EmployeeEntityJPA pEntityJPA) {

		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			final IEmployee objet 
				= new Employee();
			
			if (pEntityJPA != null) {
				
				objet.setId(pEntityJPA.getId());
				objet.setFirstName(pEntityJPA.getFirstName());
				objet.setLastName(pEntityJPA.getLastName());
				
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
	 * @param pEntity : EmployeeEntityJPA.<br/>
	 * 
	 * @return : IEmployee : Objet métier.<br/>
	 */
	public static IEmployee convertirEntityJPAEnObjetMetier(
			final EmployeeEntityJPA pEntity) {
		
		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			IEmployee objet = null;
			
			if (pEntity != null) {
				
				/* récupère les valeurs dans l'Entity. */
				/* injecte les valeurs typées dans un OBJET METIER. */
				objet 
					= new Employee(
							pEntity.getId()
							, pEntity.getFirstName(), pEntity.getLastName());
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
	 * @param pList : List&lt;EmployeeEntityJPA&gt;.<br/>
	 * 
	 * @return : List&lt;IEmployee&gt;.<br/>
	 */
	public static List<IEmployee> convertirListEntitiesJPAEnModel(
			final List<EmployeeEntityJPA> pList) {
		
		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<IEmployee> resultat 
				= new ArrayList<IEmployee>();
			
			for (final EmployeeEntityJPA entity : pList) {
				
				/* n'insère dans la liste résultat 
				 * que les Entities non null. */
				if (entity != null) {
					
					final IEmployee objet 													
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
	 * @param pObject : IEmployee.<br/>
	 *  
	 * @return : EmployeeEntityJPA.<br/>
	 */
	public static EmployeeEntityJPA creerEntityJPA(
			final IEmployee pObject) {
		
		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			final EmployeeEntityJPA entity 
				= new EmployeeEntityJPA();
			
			if (pObject != null) {
				
				entity.setId(pObject.getId());
				entity.setFirstName(pObject.getFirstName());
				entity.setLastName(pObject.getLastName());
				
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
	 * @param pObject : IEmployee : Objet métier.<br/>
	 * 
	 * @return : EmployeeEntityJPA : ENTITY JPA.<br/>
	 */
	public static EmployeeEntityJPA convertirObjetMetierEnEntityJPA(
			final IEmployee pObject) {
		
		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			EmployeeEntityJPA resultat = null;
			
			if (pObject != null) {
								
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new EmployeeEntityJPA(
							pObject.getId()
							, pObject.getFirstName(), pObject.getLastName());
				
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
	 * @param pList : List&lt;IEmployee&gt;
	 * 
	 * @return : List&lt;EmployeeEntityJPA&gt;.<br/>
	 */
	public static List<EmployeeEntityJPA> convertirListModelEnEntitiesJPA(
			final Iterable<IEmployee> pList) {
		
		synchronized (EmployeeConvertisseurMetierEntity.class) {
			
			/* retourne null si pList == null. */
			if (pList == null) {
				return null;
			}
			
			final List<EmployeeEntityJPA> resultat 
				= new ArrayList<EmployeeEntityJPA>();
			
			for (final IEmployee objet : pList) {
				
				if (objet != null) {
					
					final EmployeeEntityJPA entity 
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
	 * @param pList : List&lt;EmployeeEntityJPA&gt; : 
	 * liste d'Entities.<br/>
	 * 
	 * @return : String : affichage.<br/>
	 */
	public static String afficherFormateListEntities(
			final List<EmployeeEntityJPA> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IEmployee entity : pList) {
			
			/* n'affiche pas une Entity null 
			 * dans la liste passée en paramètre. */
			if (entity != null) {
				
				final String stringformatee 
					= String.format(
							Locale.getDefault()
								, FORMAT_EMPLOYEE
								, entity.getId()
								, entity.getFirstName(), entity.getLastName());
				
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
	 * @param pList : List&lt;IEmployee&gt; : 
	 * liste d'Entities.<br/>
	 * 
	 * @return : String : affichage.<br/>
	 */
	public static String afficherFormateListObjets(
			final List<IEmployee> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IEmployee entity : pList) {
			
			/* n'affiche pas une Entity null 
			 * dans la liste passée en paramètre. */
			if (entity != null) {
				
				final String stringformatee 
					= String.format(
							Locale.getDefault()
								, FORMAT_EMPLOYEE
								, entity.getId()
								, entity.getFirstName(), entity.getLastName());
				
				stb.append(stringformatee);
				
				/* utilise le saut de la plateforme. */
				stb.append(System.getProperty(LINE_SEPARATOR));
			}
		}
		
		return stb.toString();
		
	} //Fin de afficherFormateListObjets(...)._____________________________
	
	
	
} // FIN DE LA CLASSE EmployeeConvertisseurMetierEntity.---------------------
