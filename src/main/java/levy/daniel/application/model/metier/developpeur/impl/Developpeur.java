package levy.daniel.application.model.metier.developpeur.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import levy.daniel.application.model.dto.metier.developpeur.IDeveloppeurDTO;
import levy.daniel.application.model.metier.developpeur.IDeveloppeur;


/**
 * CLASSE Developpeur :<br/>
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
@Component("Developpeur")
public class Developpeur implements IDeveloppeur {

	// ************************ATTRIBUTS************************************/
	

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;


	/**
	 * .<br/>
	 */
	private String nom;
	
	
	/**
	 * .<br/>
	 */
	private int anneesExperience;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Developpeur.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public Developpeur() {
		this(null, null, 0);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 *
	 * @param pNom
	 * @param pAnneesExperience
	 */
	public Developpeur(
			final String pNom
					, final int pAnneesExperience) {
		this(null, pNom, pAnneesExperience);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * 
	 * @param pId 
	 * @param pNom
	 * @param pAnneesExperience
	 */
	public Developpeur(
			final Long pId
				, final String pNom
					, final int pAnneesExperience) {
		
		super();
		
		this.id = pId;
		this.nom = pNom;
		this.anneesExperience = pAnneesExperience;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR.<br/>
	 * <b>transforme une VUE (DTO) en Objet Metier</b>.
	 *
	 * @param pDTO : IDeveloppeurDTO
	 */
	public Developpeur(
			final IDeveloppeurDTO pDTO) {
		
		super();
		
		if (pDTO != null) {
			
			Long idLocal = null;
			int anneeLocal = 0;
			
			try {
				idLocal = Long.valueOf(pDTO.getIdString());
			} catch (Exception e) {
				this.id = null;
			}
			
			try {
				anneeLocal 
					= Integer
						.parseInt(
								pDTO.getAnneesExperienceString());
			} catch (Exception e) {
				this.anneesExperience = 0;
			}
			
			this.setId(idLocal);
			this.setNom(pDTO.getNomString());
			this.setAnneesExperience(anneeLocal);
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR._______________________________

	
	
	/**
	 * méthode exécutée avant la construction du Bean.<br/>
	 */
	public void avantConstruction() {
		System.out.println(
				"CLASSE Developpeur - méthode avantConstruction()");
	} // Fin de avantConstruction()._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Developpeur [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nom=");
		if (this.nom != null) {			
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
				
		builder.append("anneesExperience=");
		builder.append(this.anneesExperience);
		
		builder.append(']');
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;		
	} // Fin de setId(...).________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNom() {
		return this.nom;
	}


	
	 /**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAnneesExperience() {
		return this.anneesExperience;
	}


	
	 /**
	 * {@inheritDoc}
	 */
	@Override
	public void setAnneesExperience(
			final int pAnneesExperience) {
		this.anneesExperience = pAnneesExperience;
	}

	

}
