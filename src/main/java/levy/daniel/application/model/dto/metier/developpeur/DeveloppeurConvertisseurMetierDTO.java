package levy.daniel.application.model.dto.metier.developpeur;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.developpeur.impl.DeveloppeurDTO;
import levy.daniel.application.model.metier.developpeur.IDeveloppeur;
import levy.daniel.application.model.metier.developpeur.impl.Developpeur;

/**
 * CLASSE DeveloppeurConvertisseurMetierDTO :<br/>
 * classe <b>utilitaire</b> chargée de <b>convertir 
 * un DTO en OBJET METIER</b> et de <b>convertir un
 * OBJET METIER en DTO</b>.<br/>
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
public class DeveloppeurConvertisseurMetierDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(DeveloppeurConvertisseurMetierDTO.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	private DeveloppeurConvertisseurMetierDTO() {
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
	 * @param pDTO : IDeveloppeurDTO.<br/>
	 * 
	 * @return : IDeveloppeur : Objet métier.<br/>
	 */
	public static IDeveloppeur convertirDTOEnObjetMetier(
			final IDeveloppeurDTO pDTO) {
		
		synchronized (DeveloppeurConvertisseurMetierDTO.class) {
			
			IDeveloppeur resultat = null;
			
			if (pDTO != null) {
				
				/* récupère les valeurs String dans le DTO. */
				final String idString = pDTO.getIdString();
				final String nomString = pDTO.getNomString();
				final String anneesExperienceString = pDTO.getAnneesExperienceString();
				
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
				
				/* nom */
				final String nom = nomString;
				
				int anneesExperience = 0;
				
				try {
					anneesExperience = Integer.valueOf(anneesExperienceString);
				} catch (Exception finalE) {
					anneesExperience = 0;
				}
				
				
				/* injecte les valeurs typées dans un OBJET METIER. */
				resultat 
					= new Developpeur(
							id
							, nom
								, anneesExperience);
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
	 * @param pObject : IDeveloppeur : 
	 * Objet métier.<br/>
	 * 
	 * @return : IDeveloppeurDTO : DTO.<br/>
	 */
	public static IDeveloppeurDTO convertirObjetMetierEnDTO(
			final IDeveloppeur pObject) {
		
		synchronized (DeveloppeurConvertisseurMetierDTO.class) {
			
			IDeveloppeurDTO resultat = null;
			
			if (pObject != null) {
				
				/* récupère les valeurs typées dans l'objet métier. */
				final Long id = pObject.getId();
				final String nom = pObject.getNom();
				final int anneesExperience = pObject.getAnneesExperience();
				
				/* convertit les types de l'Objet métier en String du DTO. */
				String idString = null;
				try {
					idString = String.valueOf(id);
				} catch (Exception finalE) {
					idString = null;
				}
				
				final String nomString = nom;
				
				String anneesExperienceString = null;
				
				try {
					anneesExperienceString = String.valueOf(anneesExperience);
				} catch (Exception finalE) {
					anneesExperienceString = null;
				}
					
				/* injecte les valeurs String dans un DTO. */
				resultat 
					= new DeveloppeurDTO(
							idString
								, nomString
									, anneesExperienceString);
				
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
	 * @param pListeObjets : List&lt;IDeveloppeur&gt; : 
	 * Liste d'OBJETS METIER.<br/>
	 * @return : 
	 * List&lt;IDeveloppeurDTO&gt; : 
	 * Liste de DTOs.<br/>
	 */
	public static List<IDeveloppeurDTO> convertirListeObjetEnListeDTO(
			final List<IDeveloppeur> pListeObjets) {
		
		synchronized (DeveloppeurConvertisseurMetierDTO.class) {
			
			/* retourne null si pListeObjets == null. */
			if (pListeObjets == null) {
				return null;
			}
			
			final List<IDeveloppeurDTO> resultat 
				= new ArrayList<IDeveloppeurDTO>();
			
			for (final IDeveloppeur objet : pListeObjets) {
				
				final IDeveloppeurDTO dto 
					= convertirObjetMetierEnDTO(objet);
				
				resultat.add(dto);
				
			}
			
			return resultat;
			
		} // Fin de synchronized._______________________________________
		
	} // Fin de convertirListeObjetEnListeDTO(...).________________________
	
	
	
} // FIN DE LA CLASSE DeveloppeurConvertisseurMetierDTO.---------------------
