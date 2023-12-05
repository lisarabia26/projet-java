package representation;
import univers.*;

public class Main {
	
	public static Node initEpreuve(Personnage currentPerso, Personnage[] persoPossibles) {
		int i = 0;
		DecisionNode premiereEpreuve = new DecisionNode("Vous vous retrouvez dans un rêve,\n"
				+ "-Vous buvez un sérum avant de devenir inconscient. Face à vous, cinq paniers contenant respectivement "
				+ "1-un couteau\n "
				+ "2-un morceau de fromage\n"
				+ "3-un livre\n"
				+ "4-une écharpe\n"
				+ "5-un journal intime\n"
				+ "6- ne rien choisir\n"
				,5, i+1,0,0,0,0,0,null);
		ChoixPerso debut = new ChoixPerso(currentPerso, persoPossibles, premiereEpreuve,"Choisissez un personnage:\n" 
			+"Personnage 1:\n"+persoPossibles[0].getNom() +persoPossibles[0].getDescription()	
				+"\nPersonnage 2:\n"+persoPossibles[1].getNom() +persoPossibles[1].getDescription()
				+"\nPersonnage 3:\n"+persoPossibles[2].getNom() +persoPossibles[2].getDescription()
				+"\nPersonnage 4:\n"+persoPossibles[3].getNom() +persoPossibles[3].getDescription()
				+"\nPersonnage 5:\n"+persoPossibles[4].getNom() +persoPossibles[4].getDescription(),i++,0,0,0,0,0,null);
		
		


		DecisionNode ChoixCouteau = new DecisionNode("Un chien apparait et essaye de vous attaquer, devant vous une porte,"
				+ " 2 choix se presentent a vous\n"
				+ "Choix 1 : l'attaquer avec le couteau recupere\n"
				+ "Choix 2 : Vous n'aimez pas la violence, vous preferez fuir\n", 2, i++, 0, 3, 1, 0, 0, null);
		DecisionNode ChoixFromage = new DecisionNode("Apres avoir choisi le fromage, vous errez avant de retrouver des anciens camarades, plusieurs d’entre eux sont blessés \n "
				+ "vous rencontrez un groupe de connaissance qui ont en leur possession des medicaments,"
				+ " Sauf que cette marche vous a donne faim\n"
				+ "Choix 1 :Vous troquez votre fromage contre des medicaments pour aider vos amis\n"
				+ "Choix 2 : Vous mangez votre fromage secretement (personne ne vous a vu ;) ) \n", 3, i++, 0, 0, 1, 3, 0, null);
		DecisionNode ChoixLivre = new DecisionNode("Un chien apparait et essaye de vous attaquer \n"
				+ " 2 choix se presentent a vous\n"
				+ "Choix 1 : Vous baissez les yeux et vous vous eloignez du chien\n"
				+ "Choix 2 : Vous jetez le livre sur le chien\n", 2, i++, 0, 0, 3, 0, 0, null);
		DecisionNode ChoixEcharpe = new DecisionNode("Un vent s'abat sur la ville, mais heureusement pour vous, vous avez "
				+ "choisi une echarpe, cependant en marchant, vous apercevant un pauvre vieil homme gele,"
				+ "deux choix s'offrent a vous"
				+ "Choix 1 : Vous lui offrez votre echarpe\n"
				+ "Choix 2 : Vous gardez votre echarpe\n", 2, i++, 3, 0, 0, 0, 0, null);
		DecisionNode ChoixJournal = new DecisionNode(" vous vous retrouvez sur une estrade face a un grand public"
				+ " où tout le monde lit a tour de role son journal intime, "
				+ "deux choix s'offrent a vous \n"
				+ "Choix 1 : Vous lisez fièrement votre journal\n"
				+ "Choix 2 : Vous fuiez\n", 2, i++, 0, 0, 0, 0, 3, null);


		debut.setOptions(new Node[]{ChoixCouteau, ChoixFromage, ChoixLivre, ChoixEcharpe, ChoixJournal});
		Node[] optionsDebut = debut.getOptions();
		optionsDebut[0] = ChoixCouteau;
		optionsDebut[1] = ChoixFromage;
		optionsDebut[2] = ChoixLivre;
		optionsDebut[3] = ChoixEcharpe;
		optionsDebut[4] = ChoixJournal;
		

		// ...

	
		return debut;
		
		
	}
	

	public static void main(String[] args) {
		Outil outil1= null;
		Personnage currentPerso = new Personnage();
		Personnage[] personnages= new Personnage[5];
		personnages[0]=new Personnage("Antoine ", 10, 5, 8, 3, 7, 
				"au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres. "
				+ "Ses actions désintéressées et son inclination naturelle à soutenir ceux qui l'entourent soulignent son attachement profond aux liens humains. "
				+ "Sa façon chaleureuse d'interagir avec les autres, ponctuée de gestes attentionnés, trahit une prédisposition à la fraternité.",
				outil1);
		personnages[1]= new Personnage("Christina", 8, 7, 5, 4, 6, " Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve. "
				+ "Elle ne craint pas l'inconnu et est souvent vue en train d'explorer des territoires inexplorés.", outil1);
       
		personnages[2] = new Personnage("Emily", 5, 6, 4, 8, 3, " discrète et bienveillante, semble constamment préoccupée par le bien-être des autres. "
      		+ "Son attitude chaleureuse et son sourire doux indiquent une sensibilité particulière envers les émotions des gens qui l'entourent. "
      		+ "Son choix vestimentaire privilégie souvent des tons apaisants, reflétant son désir d'harmonie et de compassion.", outil1);


		personnages[3] = new Personnage("Julien", 7, 4, 6, 5, 9, " toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre. "
 		+ "Son esprit curieux et analytique révèle une passion profonde pour la recherche de la vérité et la quête du savoir. "
 		+ "Ses conversations sont teintées d'une intelligence perceptible, et ses choix sont guidés par une volonté constante d'approfondir sa compréhension du monde qui l'entoure", outil1);


		personnages[4] = new Personnage("Sophie", 6, 8, 7, 2, 5, " avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants."
 		+ " Sa manière de s'exprimer, sans artifices ni détours, dénote une sincérité profonde. "
 		+ "Les nuances subtiles de ses expressions faciales révèlent une transparence émotionnelle, soulignant son engagement envers l'authenticité."
 		+ " Un style vestimentaire simple mais élégant suggère qu'elle accorde de l'importance à l'expression véritable de soi.", outil1);

		Node currentNode = initEpreuve(currentPerso, personnages);
		
		
		while(!(currentNode instanceof TerminalNode))
		{
		currentNode = currentNode.chooseNext();
		
		if(currentNode instanceof DecisionNode)
			((DecisionNode) currentNode).init(currentPerso);
		if(currentNode instanceof ChanceNode)
			((ChanceNode) currentNode).init(currentPerso);
		}
		System.out.println(currentNode.getDescription());
		
		
		// TODO Auto-generated method stub
//premiere epreuve ou mettre le scanner????
	}

}
