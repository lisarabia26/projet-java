/**
 * L'interface `Displayable` étend l'interface `Event` et représente un élément pouvant être affiché dans le système.
 * Elle hérite des méthodes pour afficher et choisir le prochain élément affichable.
 *
 * @version 1.0
 * @since 15/12/23
 * @see Event
 */
package representation;

/**
 * Interface for representing a displayable element in the system.
 * Extends the {@link Event} interface.
 */

public interface Displayable extends Event {
	
	/**
     * Affiche l'élément.
     */
    @Override
    void display();
    
    
    /**
     * Choisit le prochain élément affichable lié à cet élément.
     *
     * @return L'élément affichable suivant.
     */
    
    @Override
    Displayable chooseNext();
}

