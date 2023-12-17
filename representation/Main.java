package representation;
import univers.*;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;
import univers.Factions.Faction;


import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	public static Node loadFile(String nomFichier, Scanner console, Personnage currentPerso,Hashtable<Integer,Node> dictionnaireNode) throws FileNotFoundException
	{
		File fichier = new File(nomFichier);
		Scanner lecteur = new Scanner(fichier);
		lecteur.useDelimiter(";");
		int i =1;
		System.out.println("Voici les  sauvegardes disponible :");
		while(lecteur.hasNextLine()) {
			System.out.printf("%d - %s%n",i++,lecteur.next());
			lecteur.nextLine();
			
		}
		System.out.print("Laquelle choisissez vous : ");
		int selection = console.nextInt() - 1;
		lecteur.close();
		lecteur = new Scanner(fichier);
		for(int j=0; j<selection;j++)
			lecteur.nextLine();
		lecteur.next();
		int id = lecteur.nextInt();
		String nom = lecteur.next();
		String description = lecteur.next();
		int pointAl = lecteur.nextInt();
		int pointAud = lecteur.nextInt();
		int pointEr = lecteur.nextInt();
		int pointSinc = lecteur.nextInt();
		int pointFr = lecteur.nextInt();
		Personnage newPerso = new Personnage(nom,pointAl,pointAud,pointEr,pointSinc,pointFr,description,null);
		if(lecteur.hasNext())
		{
		int statOutil = lecteur.nextInt();
		String nomOutil = lecteur.next();
		String nomFaction = lecteur.next();
		newPerso.setOutil(new Outil(nomOutil, statOutil));
		Faction faction = Faction.getFactionFromString(nomFaction);
		newPerso.setFaction(faction);
		}
		currentPerso.copie(newPerso);
		lecteur.close();
		
		return dictionnaireNode.get(id);	
	}
	
	
	

	public static Node initEpreuve(Personnage currentPerso, Personnage[] persoPossibles, Scanner scanner,Hashtable <Integer,Node> dictionnaireNode) {
		int i = 0;
		DecisionNode premiereEpreuve = new DecisionNode(
				"\"Vous savourez une gorgée du mystérieux sérum qui coule dans vos veines, imprégnant chaque coin de votre être d'une énergie inconnue. "
						+ "À peine le liquide touche-t-il votre palais que votre conscience s'embrouille, vous plongeant dans un rêve éthéré.\n"
						+ "Dans ce rêve, vous vous tenez devant cinq paniers, chaque objet révélant une essence unique. Un choix crucial s'offre à vous\n"
						+ "1-un couteau\n" + "2-un morceau de fromage\n" + "3-un livre\n" + "4-une écharpe\n"
						+ "5-un journal intime\n",
				5, i +1, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(premiereEpreuve.getId(), premiereEpreuve);
		ChoixPerso debut = new ChoixPerso(currentPerso, persoPossibles, premiereEpreuve,
				"Choisissez un personnage:\n" + "Personnage 1:\n" + persoPossibles[0].getNom()
						+ persoPossibles[0].getDescription() + "\nPersonnage 2:\n" + persoPossibles[1].getNom()
						+ persoPossibles[1].getDescription() + "\nPersonnage 3:\n" + persoPossibles[2].getNom()
						+ persoPossibles[2].getDescription() + "\nPersonnage 4:\n" + persoPossibles[3].getNom()
						+ persoPossibles[3].getDescription() + "\nPersonnage 5:\n" + persoPossibles[4].getNom()
						+ persoPossibles[4].getDescription(),
				i++, 0, 0, 0, 0, 0, null, scanner);
		i++;
		dictionnaireNode.put(debut.getId(), debut);
		DecisionNode ChoixCouteau = new DecisionNode(
				"Votre choix du couteau, symbole de puissance et de protection, vous conduit à une épreuve inattendue. "
						+ "Soudain, un chien surgit, les crocs découverts, prêt à l'attaque."
						+ " Devant vous, une porte mystérieuse, 2 choix se presentent a vous\\n"
						+ "Choix 1 : Affronter le chien avec détermination grâce au couteau récupéré\n"
						+ "Choix 2 : Eviter la violence, choisir la fuite\n",
				2, i++, 0, 3, 1, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixCouteau.getId(), ChoixCouteau);
		DecisionNode ChoixFromage = new DecisionNode(
				"En votre possession un fromage, symbole de partage et de subsistance, vous conduit à une situation délicate. "
						+ "Alors que vous errez, vous retrouvez d'anciens camarades, mais la scène qui se dévoile est loin d'être réjouissante. "
						+ "Plusieurs d'entre eux sont blessés, nécessitant une aide immédiate.\n"
						+ "Au détour de votre chemin, vous découvrez un groupe de connaissances qui détiennent des médicaments salvateurs."
						+ " Cependant, une réalité inattendue se présente : la longue marche vous a creusé l'appétit."
						+ "Choix 1: Troquer votre fromage contre des médicaments"
						+ "Choix 2: Manger votre fromage en secret",
				2, i++, 0, 0, 1, 3, 0, null, scanner);
		dictionnaireNode.put(ChoixFromage.getId(), ChoixFromage);
		
		
		DecisionNode ChoixLivre = new DecisionNode(
				"Votre choix du livre, symbole de connaissance et de sagesse, vous place face à un défi inattendu. "
						+ "Alors que vous avancez, un chien menaçant surgit, prêt à vous attaque.\n "
						+ "Choix 1 : Baisser les yeux et vous éloigner du chien \n"
						+ "Choix 2 : Jeter le livre sur le chien\n",
				2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixLivre.getId(), ChoixLivre);
		
		DecisionNode ChoixEcharpe = new DecisionNode(
				"Votre choix de l'écharpe, symbole de chaleur et de réconfort, vous conduit à une rencontre inattendue. "
						+ "Alors que vous marchez, un vent glacial s'abat sur la ville. Cependant, grâce à votre écharpe, vous restez au chaud.\n"
						+ "Soudain, vous apercevez un vieil homme frissonnant, visiblement gelé. Deux options s'offrent à vous:\n"
						+ "Choix 1 : Lui offrirx votre echarpe\n" + "Choix 2 : Garder votre echarpe\n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixEcharpe.getId(), ChoixEcharpe);
		
		
		DecisionNode ChoixJournal = new DecisionNode(
				" Votre choix du journal intime, un moyen d'expression personnelle et d'authenticité, vous amène à une situation inhabituelle."
						+ " Vous vous retrouvez sur une estrade, face à un grand public, où chacun lit à tour de rôle son journal intime.\n"
						+ "Dans ce moment de partage intime, deux options se présentent à vous, révélant votre approche face à la mise en lumière de votre vie privée.\n"
						+ "Choix 1 : Lire fièrement votre journal\n" + "Choix 2 : Fuir la scène\n",
				2, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ChoixJournal.getId(), ChoixJournal);


		DecisionNode ChoixFacS = new DecisionNode(

				"Soudainement, tout s'efface autour de vous. L'environnement change radicalement, et vous vous retrouvez dans un bus. "
						+ "Sans argent ni ticket, le chauffeur vous fixe droit dans les yeux et vous interroge sur la possession d'un ticket.\n"
						+ "Devant cette situation délicate, deux options se présentent à vous,\n "
						+ "révélant votre attitude face à l'éthique et à la légalité dans un monde où les choix peuvent avoir des conséquences importantes.\n"
						+ "Choix 1 : Mentir et frauder\n"
						+ "Choix 2 : Jurer par la vérité, et avouer au chauffeur de bus au risque de vous faire renvoye \n",

				2, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ChoixFacS.getId(), ChoixFacS);
		

		DecisionNode ChoixAu = new DecisionNode(

				" En marchant, vous observez une scène dérangeante : une jeune femme est harcelée par un groupe de voyous.\n"
						+ "Cependant, la marche intense vous a fatigué. Que décidez-vous de faire?\n"
						+ "Choix 1 : Vous décidez de vous interposer et défendre la jeune femme.\n"
						+ "Choix 2 : Vous choisissez de ne pas vous impliquer, considérant que cela ne vous regarde pas.\n",

				2, i++, 0, 3, 0, 0, 0, null, scanner);
		dictionnaireNode.put( ChoixAu.getId(),  ChoixAu);
		

		DecisionNode ChoixAl = new DecisionNode(
				"Vous peinez a trouver une place, cependant, au moment ou vous vous asseyez\n"

						+ "une vieille dame rentre dans le bus \n"

						+ " 2 choix se presentent a vous\n"

						+ "Choix 1 : Vous lui laissez votre place \n"

						+ "Choix 2 : Vous restez assis \n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixAl.getId(),ChoixAl);
		
		

		DecisionNode ChoixEr = new DecisionNode(

				"Alors que vous vous installez dans le bus, vous découvrez un mystérieux carnet contenant des énigmes complexes et intrigantes. \n"

						+ "Chaque page semble renfermer des secrets mathématiques fascinants. Deux choix s'offrent à vous : \n"

						+ "Choix 1 : Vous vous plongez immédiatement dans la résolution des énigmes.\n"

						+ "Intrigué par le mystère du carnet, votre personnage décide de résoudre les énigmes mathématiques.\n"

						+ " Cela pourrait le conduire à une découverte passionnante ou dévoiler un message caché\n"

						+ "Choix 2 : Vous décidez de remettre le carnet au chauffeur en tant qu'objet trouvé.\n"

						+ "Pensant que le carnet pourrait être précieux pour quelqu'un d'autre"

						+ "Vous faites cela dans l'espoir que le propriétaire légitime le retrouvera\n",

				2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixEr.getId(), ChoixEr);
		
		

		DecisionNode ChoixFr = new DecisionNode(
				"Votre personnage repère un groupe de personnes rassemblées dans un coin du bus,\n"

						+ " discutant et riant ensemble. Deux choix s'offrent à lui :\n"

						+ "1. Il décide de se joindre au groupe spontanément.\n"

						+ "Attiré par l'énergie positive du groupe, votre personnage décide de les rejoindre, espérant participer à la conversation animée.\n "

						+ "Cela pourrait être une opportunité de créer de nouvelles connexions et amitiés.  \n"

						+ "2. Il choisit de rester à sa place et de ne pas interrompre le groupe.\n"

						+ "Préférant ne pas déranger le groupe déjà formé, votre personnage décide de rester à sa place et de ne pas se joindre à eux. \n"

						+ "Il peut penser qu'il est plus prudent de respecter leur espace. \n",
				2, i++, 0, 0, 0, 3, 0, null, scanner);
		dictionnaireNode.put(ChoixFr.getId(), ChoixFr);



	

		DecisionNode ChoixFuite = new DecisionNode("Vous avez decide de fuir et n'avez pas ete a "
				+ "la hauteur. /n "
				+ "Cependant, le destin a decide de vous octroyer une seconde chance  "

				+ "/n Appuyez 1 pour continuer",1,  i++, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixFuite.getId(), ChoixFuite);

		
		
		//ChanceNode DernièreChance= new ChanceNode()
		
		DecisionNode ZoneAudacieux = new DecisionNode("Dans la Zone des Audacieux, "
		        + "face à un mur imposant, choisissez :\n"
		        + "\n"
		        + "1. Surmonter le mur seul, démontrant une indépendance audacieuse, ou\n"
		        + "2. Collaborer en formant une échelle humaine, mettant en avant la force de la coopération.\n"
		        + "\n"
		        + "Choisissez avec sagesse, votre décision impacte votre destinée et la perception "
		        + "de votre courage par les évaluateurs.\n", 2, i++, 0, 3, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ZoneAudacieux.getId(),ZoneAudacieux);

		
		
		
		DecisionNode ZoneAltruiste = new DecisionNode("Vous entrez dans la Zone des Altruistes, "
		        + "où des choix difficiles mettent en jeu le bien-être des autres participants. "
		        + "À un moment crucial, optez :\n"
		        + "\n"
		        + "1. Sacrifier une partie de vos ressources pour aider un autre, démontrant l'altruisme, ou\n"
		        + "2. Conserver vos ressources pour maximiser vos chances personnelles, mettant à l'épreuve votre altruisme.\n"
		        + "\n"
		        + "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
		        + "de votre altruisme par les évaluateurs.\n", 2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put( ZoneAltruiste.getId(), ZoneAltruiste);

		
		
		
		DecisionNode ZoneErudit = new DecisionNode("Vous entrez dans la Zone des Érudits, "
		        + "remplie d'énigmes complexes. À un moment crucial, choisissez :\n"
		        + "\n"
		        + "1. Résoudre une énigme individuellement, mettant en avant votre intelligence personnelle, ou\n"
		        + "2. Collaborer pour résoudre plusieurs énigmes, démontrant la puissance de l'intelligence collective.\n"
		        + "\n"
		        + "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
		        + "de votre intelligence par les évaluateurs.\n", 2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ZoneErudit.getId(),ZoneErudit);

		
		
		DecisionNode ZoneFraternels = new DecisionNode("Vous entrez dans la Zone des Fraternels, "
		        + "où des choix moraux mettent en jeu la loyauté envers vos compagnons de faction. "
		        + "À un moment crucial, vous devez opter :\n"
		        + "\n"
		        + "1. Suivre aveuglément les règles établies, démontrant une loyauté inébranlable, "
		        + "ou\n"
		        + "2. Remettre en question une décision injuste, défendant la justice fraternelle.\n"
		        + "\n"
		        + "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
		        + "de votre loyauté et justice par les évaluateurs.\n", 2, i++, 0, 0, 0, 3, 0, null, scanner);
		dictionnaireNode.put(ZoneFraternels.getId(),ZoneFraternels);
		
		
		
		
		DecisionNode ZoneSincere = new DecisionNode("Vous entrez dans la Zone des Sincères, "
		        + "remplie de miroirs déformants et d'illusions. À un moment crucial, choisissez :\n"
		        + "\n"
		        + "1. Suivre le chemin de la vérité, identifiant les illusions avec honnêteté, ou\n"
		        + "2. Succomber à la tentation de la dissimulation, choisissant le mensonge pour éviter des conséquences.\n"
		        + "\n"
		        + "Choisissez avec sagesse, votre décision impacte votre destinée et la perception "
		        + "de votre honnêteté par les évaluateurs.\n", 1, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ZoneSincere.getId(),ZoneSincere);
		
		
		
		
		ChanceNode epreuveChance = new ChanceNode(
                "Vous êtes soudainement transporté dans un monde étrange où le destin semble fluctuer au gré du hasard.\n"
                        + "Une force mystérieuse façonne votre réalité. Vous sentez que quelque chose d'inattendu va se produire...",
                2, 0, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(epreuveChance .getId(), epreuveChance );
		
		
		
		TerminalNode Divergent = new TerminalNode (
				"Tes choix audacieux et divergents ont tracé un chemin unique, mais dans le monde implacable de Divergente, la divergence a un prix. Les dirigeants, "
				+ "intolérants envers la déviation, ont scellé ton destin. Ta partie s'achève ici. "
				+ "Prépare-toi à affronter les conséquences de ta divergence.",i++);
		dictionnaireNode.put(Divergent.getId(), Divergent);
		
		
		
		
	
		
		premiereEpreuve.setOptions(List.of(ChoixCouteau, ChoixFromage, ChoixLivre, ChoixEcharpe, ChoixJournal));
		
		ChoixLivre.setOptions(List.of(ChoixEr, ChoixCouteau));
		ChoixCouteau.setOptions(List.of(ChoixAu,ChoixFromage));
		ChoixFromage.setOptions(List.of(ChoixFr, ChoixEcharpe));
		ChoixEcharpe.setOptions(List.of(ChoixAl, ChoixJournal));
		ChoixJournal.setOptions(List.of(ChoixFacS, ChoixFuite));		
		
		ChoixAu.setOptions(List.of(ZoneAudacieux,ChoixLivre));
		ChoixAl.setOptions(List.of(ZoneAltruiste,ChoixCouteau));
		ChoixEr.setOptions(List.of(ZoneErudit,ChoixEcharpe));
		ChoixFr.setOptions(List.of(ZoneFraternels,ChoixJournal));
		ChoixFacS.setOptions(List.of(ZoneSincere, ChoixAu));
		
		
		ZoneAudacieux.setOptions(List.of(epreuveChance,ChoixFromage));
		ZoneAltruiste.setOptions(List.of(epreuveChance,ChoixCouteau));
		ZoneErudit.setOptions(List.of(epreuveChance,ChoixFromage));
		ZoneFraternels.setOptions(List.of(ZoneFraternels,epreuveChance));
		ZoneSincere.setOptions(List.of(epreuveChance,epreuveChance));
		 
		 
		 
		return debut;

	}

	public static void main(String[] args) {
		System.out.println(
				"Le monde que tu t'apprêtes à explorer est un lieu mystérieux, où les frontières entre réalité et illusion s'estompent.\n"
						+ " Bienvenue dans le monde de Divergente, où chaque choix que tu feras influencera le cours de ton aventure.\n"
						+ "Avant de commencer ton voyage, tu dois choisir un personnage parmi les cinq ombres mystérieuses qui se tiennent devant toi. \n"
						+ "Chacune représente une essence unique, une histoire à explorer. Ton choix ne sera pas simplement esthétique, "
						+ "mais guidera tes actions et définira ton destin dans le monde captivant de Divergente. \n"
						+ "Choisis avec sagesse, car le destin de Divergente t'appelle, et tu es sur le point d'écrire ton propre chapitre. Que l'aventure commence...");
		Outil outil1 = null;
		Personnage currentPerso = new Personnage();
		Personnage[] personnages = new Personnage[5];
		personnages[0] = new Personnage("Antoine ", 10, 5, 8, 3, 7,
				"au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres.\n "
						+ "Ses actions désintéressées et son inclination naturelle à soutenir ceux qui l'entourent soulignent son attachement profond aux liens humains.\n "
						+ "Sa façon chaleureuse d'interagir avec les autres, ponctuée de gestes attentionnés, trahit une prédisposition à la fraternité.\n",
				outil1);
		personnages[1] = new Personnage("Christina", 8, 7, 5, 4, 6,
				" Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. \n"
				+ "Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve. \n"
						+ "Elle ne craint pas l'inconnu et est souvent vue en train d'explorer des territoires inexplorés.\n",
				outil1);

		personnages[2] = new Personnage("Emily", 5, 6, 4, 8, 3,
				" discrète et bienveillante, semble constamment préoccupée par le bien-être des autres. "
						+ "Son attitude chaleureuse et son sourire doux indiquent une sensibilité particulière envers les émotions des gens qui l'entourent.\n "
						+ "Son choix vestimentaire privilégie souvent des tons apaisants, reflétant son désir d'harmonie et de compassion.\n",
				outil1);

		personnages[3] = new Personnage("Julien", 7, 4, 6, 5, 9,
				" toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre.\n"
						+ "Son esprit curieux et analytique révèle une passion profonde pour la recherche de la vérité et la quête du savoir. \n"
						+ "Ses conversations sont teintées d'une intelligence perceptible, et ses choix sont guidés par une volonté constante d'approfondir sa compréhension du monde qui l'entoure\n",
				outil1);

		personnages[4] = new Personnage("Sophie", 6, 8, 7, 2, 5,
				" avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants.\n"
						+ " Sa manière de s'exprimer, sans artifices ni détours, dénote une sincérité profonde. \n"
						+ "Les nuances subtiles de ses expressions faciales révèlent une transparence émotionnelle, soulignant son engagement envers l'authenticité.\n"
						+ " Un style vestimentaire simple mais élégant suggère qu'elle accorde de l'importance à l'expression véritable de soi.\n",
				outil1);
		
		Hashtable<Integer,Node> dictionnaireNode=new Hashtable<Integer,Node>();
		
		
		
		
		
		
		
		
		
		Scanner console = new Scanner(System.in);
		
		
		Node currentNode = initEpreuve(currentPerso, personnages, console, dictionnaireNode);

		while (!(currentNode instanceof TerminalNode)) {
			currentNode = currentNode.chooseNext();

			if (currentNode instanceof DecisionNode)
				((DecisionNode) currentNode).init(currentPerso);
			if (currentNode instanceof ChanceNode)
				((ChanceNode) currentNode).init(currentPerso);
		}
		System.out.println(currentNode.getDescription());

	}

}