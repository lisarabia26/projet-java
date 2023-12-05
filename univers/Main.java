package univers;
import univers.Factions.Faction;

public class Main {
    public static void main(String[] args) {
        // Création des objets Faction
        Faction faction1 = Factions.Faction.ALTRUISTE;
        Faction faction2 = Factions.Faction.AUDACIEUX;
        Faction faction3 = Factions.Faction.FRATERNEL;
        Faction faction4 = Factions.Faction.ÉRUDIT;
        Faction faction5 = Factions.Faction.SINCÈRE;

        // Création des objets Outil
        Outil outil1 = new Pelle("Pelle", 1);
        Outil outil2 = new Arme("Épée", 10);
        Outil outil3 = new Rations("Nourriture", 5);
        Outil outil4 = new Livre("Livre d'histoire", 3);
        Outil outil5 = new SerumVerite("Serum de Vérité", 8);

        // Création des personnages
        Personnage personnage1 = new Personnage("Antoine", 10, 5, 8, 3, 7, "au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres. Ses actions désintéressées et son inclination naturelle à soutenir ceux qui l'entourent soulignent son attachement profond aux liens humains. Sa façon chaleureuse d'interagir avec les autres, ponctuée de gestes attentionnés, trahit une prédisposition à la fraternité.", outil1);
        personnage1.setFaction(faction1);

        Personnage personnage2 = new Personnage("Christina", 8, 7, 5, 4, 6, "Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve. Elle ne craint pas l'inconnu et est souvent vue en train d'explorer des territoires inexplorés.", outil2);
        personnage2.setFaction(faction2);

        Personnage personnage3 = new Personnage("Emily", 5, 6, 4, 8, 3, "discrète et bienveillante, semble constamment préoccupée par le bien-être des autres. Son attitude chaleureuse et son sourire doux indiquent une sensibilité particulière envers les émotions des gens qui l'entourent. Son choix vestimentaire privilégie souvent des tons apaisants, reflétant son désir d'harmonie et de compassion.", outil3);
        personnage3.setFaction(faction3);

        Personnage personnage4 = new Personnage("Julien", 7, 4, 6, 5, 9, " toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre. Son esprit curieux et analytique révèle une passion profonde pour la recherche de la vérité et la quête du savoir. Ses conversations sont teintées d'une intelligence perceptible, et ses choix sont guidés par une volonté constante d'approfondir sa compréhension du monde qui l'entoure", outil4);
        personnage4.setFaction(faction4);

        Personnage personnage5 = new Personnage("Sophie", 6, 8, 7, 2, 5, "avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants. Sa manière de s'exprimer, sans artifices ni détours, dénote une sincérité profonde. Les nuances subtiles de ses expressions faciales révèlent une transparence émotionnelle, soulignant son engagement envers l'authenticité. Un style vestimentaire simple mais élégant suggère qu'elle accorde de l'importance à l'expression véritable de soi.", outil5);
        personnage5.setFaction(faction5);

        // Affichage des personnages
        System.out.println("Personnage 1 : " + personnage1);
        System.out.println("Personnage 2 : " + personnage2);
        System.out.println("Personnage 3 : " + personnage3);
        System.out.println("Personnage 4 : " + personnage4);
        System.out.println("Personnage 5 : " + personnage5);
    }
}
