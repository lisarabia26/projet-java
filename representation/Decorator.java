/**
 * La classe abstraite `Decorator` implémente l'interface `Event` et sert de base pour les décorateurs d'événements.
 * Elle permet de décorer un événement existant en étendant ses fonctionnalités.
 *
 * @author RABIA Lysa et NASR Rachelle
 * @version 1.0
 * @see Event
 */

package representation;

public abstract class Decorator implements Event {
    private final Event decoratedEvent;
    
    /**
     * Constructeur de la classe `Decorator`.
     *
     * @param decoratedEvent L'événement à décorer.
     */

    public Decorator(Event decoratedEvent) {
        this.decoratedEvent = decoratedEvent;
    }

    /**
     * Affiche l'événement décoré en utilisant la méthode d'affichage de l'événement décoré.
     */
    @Override
    public void display() {
        decoratedEvent.display();
    }
    /**
     * Choisit le prochain élément affichable en utilisant la méthode de choix de l'événement décoré.
     *
     * @return L'élément affichable suivant.
     */

    @Override
    public Displayable chooseNext() {
        return decoratedEvent.chooseNext();
    }
}
