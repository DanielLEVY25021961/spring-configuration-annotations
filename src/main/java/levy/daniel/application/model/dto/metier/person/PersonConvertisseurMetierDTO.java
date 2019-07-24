package levy.daniel.application.model.dto.metier.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.person.impl.PersonDTO;
import levy.daniel.application.model.metier.person.IPerson;
import levy.daniel.application.model.metier.person.impl.Person;

/**
 * CLASSE PersonConvertisseurMetierDTO :<br/>
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
public class PersonConvertisseurMetierDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(PersonConvertisseurMetierDTO.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private PersonConvertisseurMetierDTO() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * retourne une java.time.LocalDate à partir d'une String pString 
	 * de la forme "yyyy-mm-dd" comme "2019-07-20".<br/>
	 * <br/>
	 * - retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : date sous forme de String 
	 * au format "2019-07-20".
	 * 
	 * @return LocalDate
	 * 
	 * @throws Exception
	 */
	private static LocalDate parserStringEnLocalDate(
			final String pString) throws Exception {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		final LocalDate resultat 
			= LocalDate.parse(pString, DateTimeFormatter.ISO_LOCAL_DATE);
		
		return resultat;
		
	} // Fin de parserStringEnLocalDate(...).______________________________
	
	
	
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
	 * @param pDTO : IPersonDTO.<br/>
	 * 
	 * @return : IPerson : Objet métier.<br/>
	 * 
	 * @throws Exception 
	 */
	public static IPerson convertirDTOEnObjetMetier(
			final IPersonDTO pDTO) throws Exception {
		
		synchronized (PersonConvertisseurMetierDTO.class) {
			
			IPerson resultat = null;
			
			if (pDTO != null) {
				
				/* récupère les valeurs String dans le DTO. */
				final String idString = pDTO.getIdString();
				final String firstNameString = pDTO.getFirstNameString();
				final String lastNameString = pDTO.getLastNameString();
				final String birthDateString = pDTO.getBirthDateString();
				
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
				
				/* birthDate. */
				LocalDate birthDate = null;
				
				if (!StringUtils.isBlank(birthDateString)) {
					birthDate = parserStringEnLocalDate(birthDateString);
				}
				
				
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new Person(
							id
							, firstName
								, lastName
									, birthDate);
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
	 * @param pObject : IPerson : 
	 * Objet métier.<br/>
	 * 
	 * @return : IPersonDTO : DTO.<br/>
	 */
	public static IPersonDTO convertirObjetMetierEnDTO(
			final IPerson pObject) {
		
		synchronized (PersonConvertisseurMetierDTO.class) {
			
			IPersonDTO resultat = null;
			
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
					= new PersonDTO(
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
	 * @param pListeObjets : List&lt;IPerson&gt; : 
	 * Liste d'OBJETS METIER.<br/>
	 * @return : 
	 * List&lt;IPersonDTO&gt; : 
	 * Liste de DTOs.<br/>
	 */
	public static List<IPersonDTO> convertirListeObjetEnListeDTO(
			final List<IPerson> pListeObjets) {
		
		synchronized (PersonConvertisseurMetierDTO.class) {
			
			/* retourne null si pListeObjets == null. */
			if (pListeObjets == null) {
				return null;
			}
			
			final List<IPersonDTO> resultat 
				= new ArrayList<IPersonDTO>();
			
			for (final IPerson objet : pListeObjets) {
				
				final IPersonDTO dto 
					= convertirObjetMetierEnDTO(objet);
				
				resultat.add(dto);
				
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirListeObjetEnListeDTO(...).________________________
	
	
		
} // FIN DE LA CLASSE PersonConvertisseurMetierDTO.--------------------------
