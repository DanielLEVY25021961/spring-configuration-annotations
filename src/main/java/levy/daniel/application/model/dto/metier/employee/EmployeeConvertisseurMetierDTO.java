package levy.daniel.application.model.dto.metier.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.employee.impl.EmployeeDTO;
import levy.daniel.application.model.metier.employee.IEmployee;
import levy.daniel.application.model.metier.employee.impl.Employee;

/**
 * CLASSE EmployeeConvertisseurMetierDTO :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 19 juil. 2019
 *
 */
public class EmployeeConvertisseurMetierDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(EmployeeConvertisseurMetierDTO.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private EmployeeConvertisseurMetierDTO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * <b>convertit un DTO en OBJET METIER</b>.<br/>
	 * <ul>
	 * <li>retourne null si pDTO == null.</li>
	 * <li>récupère les valeurs String dans le DTO.</li>
	 * <li>convertit les String du DTO en types de l'Objet métier.</li>
	 * <li>injecte les valeurs typées dans un OBJET METIER 
	 * et le retourne.</li>
	 * </ul>
	 *
	 * @param pDTO : IEmployeeDTO.<br/>
	 * 
	 * @return : IEmployee : Objet métier.<br/>
	 */
	public static IEmployee convertirDTOEnObjetMetier(
			final IEmployeeDTO pDTO) {
		
		synchronized (EmployeeConvertisseurMetierDTO.class) {
			
			IEmployee resultat = null;
			
			if (pDTO != null) {
				
				/* récupère les valeurs String dans le DTO. */
				final String idString = pDTO.getIdString();
				final String firstNameString = pDTO.getFirstNameString();
				final String lastNameString = pDTO.getLastNameString();
				
				/* convertit les String du DTO en types de l'Objet métier. */
				/* id */
				Long id = null;
				
				if (!StringUtils.isBlank(idString)) {
					try {
						id = Long.valueOf(idString);
					} catch (NumberFormatException e) {
						id = null;
					}
				}
				
				/* firstName */
				final String firstName = firstNameString;
				
				/* lastName*/
				final String lastName = lastNameString;
				
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new Employee(
							id
							, firstName
								, lastName);
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirDTOEnObjetMetier(...).____________________________
	

	
	/**
	 * <b>convertit un OBJET METIER en DTO</b>.<br/>
	 * <ul>
	 * <li>retourne null si pObject == null.</li>
	 * <li>récupère les valeurs typées dans l'objet métier.</li>
	 * <li>convertit les types de l'Objet métier en String du DTO.</li>
	 * <li>injecte les valeurs String dans un DTO 
	 * et le retourne.</li>
	 * </ul>
	 *
	 * @param pObject : IEmployee : 
	 * Objet métier.<br/>
	 * 
	 * @return : IEmployeeDTO : DTO.<br/>
	 */
	public static IEmployeeDTO convertirObjetMetierEnDTO(
			final IEmployee pObject) {
		
		synchronized (EmployeeConvertisseurMetierDTO.class) {
			
			IEmployeeDTO resultat = null;
			
			if (pObject != null) {
				
				/* récupère les valeurs typées dans l'objet métier. */
				final Long id = pObject.getId();
				final String firstName = pObject.getFirstName();
				final String lastName = pObject.getLastName();
				
				/* convertit les types de l'Objet métier en String du DTO. */
				String idString = null;
				try {
					idString = String.valueOf(id);
				} catch (Exception finalE) {
					idString = null;
				}
				
				final String firstNameString = firstName;
				
				final String lastNameString = lastName;
				
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new EmployeeDTO(
							idString
								, firstNameString
									, lastNameString);
				
			}
						
			return resultat;
			
		} // Fin de synchronized._______________________
		
	} // Fin de convertirObjetMetierEnDTO(...).____________________________
	
	
	
	/**
	 * convertit une liste d'OBJETS METIER en liste 
	 * de DTOs.<br/>
	 * <br/>
	 * - retourne null si pListeObjets == null.<br/>
	 * <br/>
	 *
	 * @param pListeObjets : List&lt;IEmployee&gt; : 
	 * Liste d'OBJETS METIER.<br/>
	 * @return : 
	 * List&lt;IEmployeeDTO&gt; : 
	 * Liste de DTOs.<br/>
	 */
	public static List<IEmployeeDTO> convertirListeObjetEnListeDTO(
			final List<IEmployee> pListeObjets) {
		
		synchronized (EmployeeConvertisseurMetierDTO.class) {
			
			/* retourne null si pListeObjets == null. */
			if (pListeObjets == null) {
				return null;
			}
			
			final List<IEmployeeDTO> resultat 
				= new ArrayList<IEmployeeDTO>();
			
			for (final IEmployee objet : pListeObjets) {
				
				final IEmployeeDTO dto 
					= convertirObjetMetierEnDTO(objet);
				
				resultat.add(dto);
				
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirListeObjetEnListeDTO(...).________________________
	
	
		
} // FIN DE LA CLASSE EmployeeConvertisseurMetierDTO.------------------------
