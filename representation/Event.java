package representation;
/**
 * L'interface `Event` représente un événement dans le système.
 * Elle définit des méthodes pour afficher l'événement et choisir le prochain élément affichable.
 *
 * @version 1.0
 * @since 15/12/23
 */

/**
 * Interface for representing an event in the system.
 */
public interface Event {
	 /**
     * Affiche l'événement.
     */
	    void display();
	    /**
	     * Choisit le prochain élément affichable lié à cet événement.
	     *
	     * @return L'élément affichable suivant.
	     */
	    Displayable chooseNext();

		}
	