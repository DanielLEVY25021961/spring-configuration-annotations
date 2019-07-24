package levy.daniel.application.model.metier.developpeur;

/**
 * INTERFACE IDeveloppeur :<br/>
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
public interface IDeveloppeur {

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();

	

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return this.id : Long.<br/>
	 */
	Long getId();


	/**
	 * method setId( Long pId) :<br/>
	 * Setter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : valeur à passer à this.id.<br/>
	 */
	void setId(Long pId);


	/**
	 * Getter .<br/>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();


	/**
	 * .<br/>
	 *
	 * @param pNom : String : valeur à passer à this.nom.<br/>
	 */
	void setNom(String pNom);


	/**
	 * Getter .<br/>
	 *
	 * @return anneesExperience : int.<br/>
	 */
	int getAnneesExperience();


	/**
	 * .<br/>
	 *
	 * @param pAnneesExperience : int : valeur à passer à
	 * this.anneesExperience.<br/>
	 */
	void setAnneesExperience(int pAnneesExperience);

}
