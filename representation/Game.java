package representation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import univers.Outil;
import univers.Personnage;
import univers.Factions.Faction;

public class Game {

	public Node currentNode;
	public Personnage currentPerso;
	public Personnage[] persoPossibles;
	public Hashtable<Integer, Node> dictionnaireNode;
	public static String nomFichier = "./sauvegarde.csv";

	public Game(Scanner scanner) {
		this.persoPossibles = new Personnage[5];
		this.persoPossibles[0] = new Personnage("Antoine ", 10, 5, 8, 3, 7,
				"au coeur genereux, se distingue par son empathie et son attitude bienveillante envers les autres.\n "
						+ "Ses actions désintéressées et son inclination naturelle à soutenir ceux qui l'entourent soulignent son attachement profond aux liens humains.\n "
						+ "Sa façon chaleureuse d'interagir avec les autres, ponctuée de gestes attentionnés, trahit une prédisposition à la fraternité.\n",
				null);
		this.persoPossibles[1] = new Personnage("Christina", 8, 7, 5, 4, 6,
				" Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. \n"
						+ "Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'epreuve. \n"
						+ "Elle ne craint pas l'inconnu et est souvent vue en train d'explorer des territoires inexplores.\n",
				null);

		this.persoPossibles[2] = new Personnage("Emily", 5, 6, 4, 8, 3,
				" discrète et bienveillante, semble constamment préoccupée par le bien-être des autres. "
						+ "Son attitude chaleureuse et son sourire doux indiquent une sensibilite particuliere envers les émotions des gens qui l'entourent.\n "
						+ "Son choix vestimentaire privilégie souvent des tons apaisants, reflétant son désir d'harmonie et de compassion.\n",
				null);

		this.persoPossibles[3] = new Personnage("Julien", 7, 4, 6, 5, 9,
				" , toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre.\n"
						+ "Son esprit curieux et analytique révèle une passion profonde pour la recherche de la vérité et la quete du savoir. \n"
						+ "Ses conversations sont teintées d'une intelligence perceptible, et ses choix sont guides par une volonte constante d'approfondir sa comprehension du monde qui l'entoure\n",
				null);

		this.persoPossibles[4] = new Personnage("Sophie", 6, 8, 7, 2, 5,
				" , avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants.\n"
						+ " Sa manière de s'exprimer, sans artifices ni détours, dénote une sincérité profonde. \n"
						+ "Les nuances subtiles de ses expressions faciales révèlent une transparence émotionnelle, soulignant son engagement envers l'authenticité.\n"
						+ " Un style vestimentaire simple mais élégant suggère qu'elle accorde de l'importance à l'expression véritable de soi.\n",
				null);

		this.dictionnaireNode = new Hashtable<Integer, Node>();
		this.currentPerso = new Personnage();
		this.initEpreuve(scanner);
		System.out.println("Voulez vous charger une partie ? (O/N)");
		String choix = scanner.next().toUpperCase();
		if (choix.equals("O")) {
			try {
				this.loadFile(nomFichier, scanner);
			} catch (FileNotFoundException e) {
				System.out.println("Erreur lors du chargement de la partie");
				e.printStackTrace();
			}
		}
		/*
		 * if(oui){
		 * this.loadFile(null, scanner);
		 * }
		 */

	}

	public void loadFile(String nomFichier, Scanner console) throws FileNotFoundException {
		File fichier = new File(nomFichier);
		Scanner lecteur = new Scanner(fichier);
		lecteur.useDelimiter(";");
		int i = 1;
		System.out.println("Voici les  sauvegardes disponible :");
		ArrayList<String> sauvegardes = new ArrayList<String>();
		while (lecteur.hasNextLine()) {
			System.out.printf("%d - %s (%s)%n", i++, lecteur.next(), lecteur.next());
			sauvegardes.add(lecteur.nextLine());
		}
		System.out.print("Laquelle choisissez vous : ");
		int selection = console.nextInt() - 1;
		lecteur.close();
		String[] selectionSauvegarde = sauvegardes.get(selection).split(";");

		int id = Integer.parseInt(selectionSauvegarde[1]);
		String nom = selectionSauvegarde[2];
		String description = selectionSauvegarde[3].replace('|', '\n');
		int pointAl = Integer.parseInt(selectionSauvegarde[4]);
		int pointAud = Integer.parseInt(selectionSauvegarde[5]);
		int pointEr = Integer.parseInt(selectionSauvegarde[6]);
		int pointSinc = Integer.parseInt(selectionSauvegarde[7]);
		int pointFr = Integer.parseInt(selectionSauvegarde[8]);
		Personnage newPerso = new Personnage(nom, pointAl, pointAud, pointEr, pointSinc, pointFr, description, null);
		if (selectionSauvegarde.length > 9) {
			int statOutil = Integer.parseInt(selectionSauvegarde[9]);
			String nomOutil = selectionSauvegarde[10];
			String nomFaction = selectionSauvegarde[11];
			newPerso.setOutil(new Outil(nomOutil, statOutil));
			Faction faction = Faction.getFactionFromString(nomFaction);
			newPerso.setFaction(faction);
		}
		this.currentPerso.copie(newPerso);
		lecteur.close();

		this.currentNode = dictionnaireNode.get(id);
	}

	public void sauvegarderPartie(String nomSauvegarde) throws IOException {
		this.currentNode.save(this.currentPerso, nomFichier, nomSauvegarde);
	}

	public void initEpreuve(Scanner scanner) {
		int i = 0;
		DecisionNode premiereEpreuve = new DecisionNode(
				"\"Vous savourez une gorgée du mystérieux sérum qui coule dans vos veines, imprégnant chaque coin de votre être d'une énergie inconnue. "
						+ "À peine le liquide touche-t-il votre palais que votre conscience s'embrouille, vous plongeant dans un rêve éthéré.\n"
						+ "Dans ce rêve, vous vous tenez devant cinq paniers, chaque objet révélant une essence unique. Un choix crucial s'offre à vous\n"
						+ "1. un couteau\n" + "2. un morceau de fromage\n" + "3. un livre\n" + "4. une écharpe\n"
						+ "5. un journal intime\n",
				5, i + 1, 0, 0, 0, 0, 0, null, scanner);
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
				"Un couteau, symbole de puissance et de protection, se trouve desormais en votre possession et vous conduit à une épreuve inattendue. "
						+ "Soudain, un chien surgit, les crocs découverts, prêt à l'attaque."
						+ " Devant vous, une porte mystérieuse, 2 choix se presentent a vous \n"
						+ "1. Affronter le chien avec détermination grâce au couteau récupéré\n"
						+ "2. Eviter la violence, choisir la fuite\n",
				2, i++, 0, 3, 1, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixCouteau.getId(), ChoixCouteau);
		DecisionNode ChoixFromage = new DecisionNode(
				"En votre possession un fromage, symbole de partage et de subsistance, vous conduit à une situation délicate. "
						+ "Alors que vous errez, vous retrouvez d'anciens camarades, mais la scène qui se dévoile est loin d'être réjouissante. "
						+ "Plusieurs d'entre eux sont blessés, nécessitant une aide immédiate.\n"
						+ "Au détour de votre chemin, vous découvrez un groupe de connaissances qui détiennent des médicaments salvateurs."
						+ "Cependant, une réalité inattendue se présente : la longue marche vous a creusé l'appétit."
						+ "1. Troquer votre fromage contre des médicaments"
						+ "2. Manger votre fromage en secret",
				2, i++, 0, 0, 1, 3, 0, null, scanner);
		dictionnaireNode.put(ChoixFromage.getId(), ChoixFromage);

		DecisionNode ChoixLivre = new DecisionNode(
				"Un livre se trouve desormais en votre possession, symbole de connaissance et de sagesse, vous place face à un défi inattendu. "
						+ "Alors que vous avancez, un chien menaçant surgit, prêt à vous attaque.\n "
						+ "1. Baisser les yeux et vous éloigner du chien \n"
						+ "2. Jeter le livre sur le chien\n",
				2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixLivre.getId(), ChoixLivre);

		DecisionNode ChoixEcharpe = new DecisionNode(
				"Une echarpe, symbole de chaleur et de réconfort, se trouve desormais en votre possession, et vous conduit à une rencontre inattendue. "
						+ "Alors que vous marchez, un vent glacial s'abat sur la ville. Cependant, grâce à votre écharpe, vous restez au chaud.\n"
						+ "Soudain, vous apercevez un vieil homme frissonnant, visiblement gelé. Deux options s'offrent à vous:\n"
						+ "1. Lui offrir votre echarpe \n" 
						+ "2. Garder votre echarpe \n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixEcharpe.getId(), ChoixEcharpe);

		DecisionNode ChoixJournal = new DecisionNode(
				" Votre choix du journal intime, un moyen d'expression personnelle et d'authenticité, vous amène à une situation inhabituelle."
						+ " Vous vous retrouvez sur une estrade, face à un grand public, où chacun lit à tour de rôle son journal intime.\n"
						+ "Dans ce moment de partage intime, deux options se présentent à vous, révélant votre approche face à la mise en lumière de votre vie privée.\n"
						+ "1. Lire fièrement votre journal\n" 
						+ "2. Fuir la scène\n",
				2, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ChoixJournal.getId(), ChoixJournal);

		DecisionNode ChoixFacS = new DecisionNode(

				"Soudainement, tout s'efface autour de vous. L'environnement change radicalement, et vous vous retrouvez dans un bus. "
						+ "Sans argent ni ticket, le chauffeur vous fixe droit dans les yeux et vous interroge sur la possession d'un ticket.\n"
						+ "Devant cette situation délicate, deux options se présentent à vous,\n "
						+ "révélant votre attitude face à l'éthique et à la légalité dans un monde où les choix peuvent avoir des conséquences importantes.\n"
						+ "1. Mentir et frauder\n"
						+ "2. Jurer par la vérité, et avouer au chauffeur de bus au risque de vous faire renvoye \n",

				2, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ChoixFacS.getId(), ChoixFacS);

		DecisionNode ChoixAu = new DecisionNode(

				" En marchant, vous observez une scène dérangeante : une jeune femme est harcelée par un groupe de voyous.\n"
						+ "Cependant, la marche intense vous a fatigué. Que décidez-vous de faire?\n"
						+ "1. Vous décidez de vous interposer et défendre la jeune femme.\n"
						+ "2. Vous choisissez de ne pas vous impliquer, considérant que cela ne vous regarde pas.\n",

				2, i++, 0, 3, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixAu.getId(), ChoixAu);

		DecisionNode ChoixAl = new DecisionNode(
				"Vous peinez a trouver une place, cependant, au moment ou vous vous asseyez, "

						+ "une vieille dame entre dans le bus \n"
						+ "1. Vous lui laissez votre place \n"
						+ "2. Vous restez assis \n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixAl.getId(), ChoixAl);

		DecisionNode ChoixEr = new DecisionNode(

				"Alors que vous vous installez dans le bus, vous découvrez un mystérieux carnet contenant des énigmes complexes et intrigantes. \n"

						+ "Chaque page semble renfermer des secrets mathématiques fascinants. Deux choix s'offrent à vous : \n"

						+ "1. Vous vous plongez immédiatement dans la résolution des énigmes.\n"
						+ "2. Vous décidez de remettre le carnet au chauffeur en tant qu'objet trouvé.\n",

				2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixEr.getId(), ChoixEr);

		DecisionNode ChoixFr = new DecisionNode(
				"Votre personnage repère un groupe de personnes rassemblées dans un coin du bus,"

						+ " discutant et riant ensemble. Deux choix s'offrent à lui :\n"

						+ "1. Il décide de se joindre au groupe spontanément.\n"

						+ "2. Il choisit de rester à sa place et de ne pas interrompre le groupe, "

						+ "il peut penser qu'il est plus prudent de respecter leur espace. \n",
				2, i++, 0, 0, 0, 3, 0, null, scanner);
		dictionnaireNode.put(ChoixFr.getId(), ChoixFr);

		DecisionNode ChoixFuite = new DecisionNode("Vous avez decide de fuir et n'avez pas ete a " + "la hauteur. /n "
				+ "Cependant, le destin a decide de vous octroyer une seconde chance  "

				+ "/n Appuyez 1 pour continuer", 1, i++, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ChoixFuite.getId(), ChoixFuite);

		// ChanceNode DernièreChance= new ChanceNode()

		DecisionNode ZoneAudacieux = new DecisionNode(
				"Dans la Zone des Audacieux, " + "face à un mur imposant, deux potions s'offrent a vous, choisissez avec sagesse, votre décision impacte votre destinée et la perception \n"
						+ "						de votre courage par les évaluateurs :\n" 
						+ "1. Surmonter le mur seul, démontrant une indépendance audacieuse, ou\n"
						+ "2. Collaborer en formant une échelle humaine, mettant en avant la force de la coopération.\n"
						+ "\n" ,
				2, i++, 0, 3, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ZoneAudacieux.getId(), ZoneAudacieux);

		DecisionNode ZoneAltruiste = new DecisionNode("Vous entrez dans la Zone des Altruistes, "
				+ "où des choix difficiles mettent en jeu le bien-être des autres participants. "
				+ "À un moment crucial, optez :\n" + "\n"
				+ "1. Sacrifier une partie de vos ressources pour aider un autre, démontrant l'altruisme, ou\n"
				+ "2. Conserver vos ressources pour maximiser vos chances personnelles, mettant à l'épreuve votre altruisme.\n"
				+ "\n" + "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
				+ "de votre altruisme par les évaluateurs.\n", 2, i++, 3, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(ZoneAltruiste.getId(), ZoneAltruiste);

		DecisionNode ZoneErudit = new DecisionNode("Vous entrez dans la Zone des Érudits, "
				+ "remplie d'énigmes complexes. À un moment crucial, choisissez :\n" + "\n"
				+ "1. Résoudre une énigme individuellement, mettant en avant votre intelligence personnelle, ou\n"
				+ "2. Collaborer pour résoudre plusieurs énigmes, démontrant la puissance de l'intelligence collective.\n"
				+ "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
				+ "de votre intelligence par les évaluateurs.\n", 2, i++, 0, 0, 3, 0, 0, null, scanner);
		dictionnaireNode.put(ZoneErudit.getId(), ZoneErudit);

		DecisionNode ZoneFraternels = new DecisionNode("Vous entrez dans la Zone des Fraternels, "
				+ "où des choix moraux mettent en jeu la loyauté envers vos compagnons de faction. "
				+ "À un moment crucial, vous devez opter :\n" + "\n"
				+ "1. Suivre aveuglément les règles établies, démontrant une loyauté inébranlable, " + "ou\n"
				+ "2. Remettre en question une décision injuste, défendant la justice fraternelle.\n" + "\n"
				+ "Choisissez judicieusement, votre décision impacte votre destinée et la perception "
				+ "de votre loyauté et justice par les évaluateurs.\n", 2, i++, 0, 0, 0, 3, 0, null, scanner);
		dictionnaireNode.put(ZoneFraternels.getId(), ZoneFraternels);

		DecisionNode ZoneSincere = new DecisionNode("Vous entrez dans la Zone des Sincères, "
				+ "remplie de miroirs déformants et d'illusions. À un moment crucial, choisissez :\n" + "\n"
				+ "1. Suivre le chemin de la vérité, identifiant les illusions avec honnêteté, ou\n"
				+ "2. Succomber à la tentation de la dissimulation, choisissant le mensonge pour éviter des conséquences.\n"
				+ "Choisissez avec sagesse, votre décision impacte votre destinée et la perception "
				+ "de votre honnêteté par les évaluateurs.\n", 1, i++, 0, 0, 0, 0, 3, null, scanner);
		dictionnaireNode.put(ZoneSincere.getId(), ZoneSincere);

		ChanceNode epreuveChance = new ChanceNode(
				"Vous êtes soudainement transporté dans un monde étrange où le destin semble fluctuer au gré du hasard.\n"
						+ "Une force mystérieuse façonne votre réalité. \n"
						+ "Vous sentez que quelque chose d'inattendu va se produire...",
				1, i++, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(epreuveChance.getId(), epreuveChance);

		Outil outil = new Outil();

		DecisionNode FactionAl = new DecisionNode("Bienvenue parmi les Altruistes, là où la solidarité et "
				+ "l'empathie sont nos valeurs principales. /n"
				+ "Voici votre premiere epreuve en tant qu'Altruiste :\n"
				+ "Un prisonnier se trouve face à trois pièces et il est forcé d’entrer dans l’une des trois. \n"
				+ "Mais… il peut choisir la pièce de son choix. \n "
				+ "1. La première pièce brûle. \n"
				+ "2. La deuxième est équipée d’explosifs qui exploseront dès qu’il entrera. \n"
				+ "3. Dans la troisième se trouvent deux lions qui n’ont pas mangé depuis des années. \n"
				+ "   Quelle pièce le prisonnier doit-il choisir pour survivre ?\n"
				, 3, i + 1, 3, 0, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(FactionAl.getId(), FactionAl);

		DecisionNode FactionAud = new DecisionNode(
				"Bienvenue parmi les Audacieux, l'audace et le courage sont notre force. \n"
						+ "Voici votre premiere epreuve: \n"
						+ "Devant trois roues dans cet ordre: A, B et C \n"
						+ "Si  Si la roue A tourne dans le sens anti-horaire, dans quel sens tourne la roue C ? \n"
						+ "1. Horaire \n"
						+ "2. Antihoraire \n",
				2, i + 2, 0, 3, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(FactionAud.getId(), FactionAud);

		DecisionNode FactionEr = new DecisionNode(
				" Bienvenue parmi les Érudits, les gardiens du savoir et de la sagesse."
						+ "Vous etes devant trois portes, chacune avec une affirmation écrite dessus. "
						+ "Seule la réponse correcte le mènera plus loin.\n"
						+ "Énigme : Laquelle est vraie parmi ces affirmations ?\n"
						+ " 1. Les rivières coulent en arrière.\n"
						+ " 2. Les oiseaux volent toujours en ligne droite.\n "
						+ " 3. La vérité est cachée derrière une porte. \n",
				3, i + 3, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(FactionEr.getId(), FactionEr);

		DecisionNode FactionFr = new DecisionNode(
				"Bienvenue parmi les Fraternels, où la loyauté et la camaraderie sont nos piliers. \n"
						+ "En montrant Jean, Julie dit : \"il est le fils de la fille unique de mon père\". \n"
						+ "Quel est le lien entre Jean et Julie? \n"
						+ "1. Jean est le frere de Julie \n "
						+ "2. Jean est le mari de Julie \n "
						+ "3. Jean est le fils de Julie \n"
						+ "4. Jean est le pere de Julie \n "

				, 4, i + 4, 0, 0, 0, 3, 0, outil, scanner);
		dictionnaireNode.put(FactionFr.getId(), FactionFr);

		DecisionNode FactionSinc = new DecisionNode("Bienvenue parmi les Sincères, "
				+ "où l'authenticité et la vérité sont nos guides.\n"
				+ "Devant vous se deroule une partie d'undercover entre 4 personnes,"
				+ "parmi eux, 1 undercover et 3 civils. \n"
				+ "1. : Abeille \n"
				+ "2. : Toux \n"
				+ "3. : Pancakes \n"
				+ "4. : Erable \n"
				+ "Qui est l'undercover ?", 4, i + 5, 0, 0, 0, 0, 3, outil, scanner);
		dictionnaireNode.put(FactionSinc.getId(), FactionSinc);

		TerminalNode Divergent = new TerminalNode(
				"Tes choix audacieux et divergents ont tracé un chemin unique, mais dans le monde implacable de Divergente, la divergence a un prix. Les dirigeants, "
						+ "intolérants envers la déviation, ont scellé ton destin. Ta partie s'achève ici. \n"
						+ "Affronte les conséquences de ta divergence.",
				i + 6);
		dictionnaireNode.put(Divergent.getId(), Divergent);

		ChoixFaction choixFaction = new ChoixFaction(currentPerso, " ", FactionAl, FactionAud,
				FactionEr, FactionFr, FactionSinc, Divergent, 6, i++, 0, 0, 0, 0, 0, outil);
		dictionnaireNode.put(choixFaction.getId(), choixFaction);

		i += 6; // A VERIFIER -----------------------

		DecisionNode Ep2Al = new DecisionNode("Bienvenue, Altruiste, dans cette deuxième épreuve qui mettra à l'épreuve votre compréhension des valeurs fondamentales qui vous animent. L'énigme que vous avez devant vous résonne avec l'esprit du partage, de la compassion et de la solidarité.\n"
				+ "\n"
				+ "\"Mieux que Dieu, pire que le diable, les pauvres en ont, les riches en ont besoin, si on en mange, on meurt.\"\n"
				+ "1. Rien \n"
				+ "2. Compassion \n"
				+ "3. Solidarité \n"
				+ "4. Partage \n"
				+ "5. Bienveillance \n", 5, i++, 0, 0, 0, 3, 0, outil, scanner);
		dictionnaireNode.put(Ep2Al.getId(), Ep2Al);

		DecisionNode Ep2Fr = new DecisionNode(
				"Cette épreuve met en avant l'importance pour les Fraternels de comprendre les nuances du commerce équitable. En ayant une connaissance approfondie des calculs commerciaux de base, les Fraternels peuvent contribuer de"
						+ " manière significative à la prospérité de leur faction et à l'équilibre économique global."
						+ "Vous avez devant vous une situation commerciale typique. "
						+ "Le prix d'achat d'un produit est de 150€, et les frais d'achat s'élèvent à 8%. Votre tâche est de calculer "
						+ "le coût d'achat total du produit en tenant compte des frais.\n"
						+ "Options :\n"
						+ "\n"
						+ "125€\n"
						+ "136,50€\n"
						+ "150€\n"
						+ "162€\n"
						+ "",
				4, i++, 0, 0, 0, 3, 0, outil, scanner);
		dictionnaireNode.put(Ep2Fr.getId(), Ep2Fr);

		DecisionNode Ep2S = new DecisionNode(
				"Bienvenue dans cette 2e épreuve, où tu démontreras ta maîtrise des mots et ta capacité à choisir les termes justes. "
						+ "Les Sincères, connus pour leur éloquence, savent que la parole a un impact immense."
						+ "Prêt à faire résonner la sincérité dans chaque syllabe ? "
						+ "Quel est le synonyme de : PARODIE\n"
						+ "1. Rire\n"
						+ "2. Caricature\n"
						+ "3. Prépondérance\n"
						+ "4. Doctrine\n"
						+ "5. Diversion\n"
						+ "",
				5, i++, 0, 0, 0, 0, 3, outil, scanner);
		dictionnaireNode.put(Ep2S.getId(), Ep2S);

		DecisionNode Ep2R = new DecisionNode(
				"Bienvenue dans le défi du Mastermind Carré ! Dévoilez vos talents stratégiques"
						+ " en tentant de décrypter la combinaison secrète de chiffres, a"
						+ "vec quatre chiffres par ligne sur quatre lignes. "
						+ "Pouvez-vous percer le code ?\n"
						+ "|2|3|6|7|   0BP-2MP \n"
						+ "|3|2|1|9|   0BP-4MP \n"
						+ "|1|9|2|3|   0BP-4MP \n"
						+ "1. 9132 \n"
						+ "2. 7632 \n"
						+ "3. 7612 \n"
						+ "4. 1329  \n",
				4, i++, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep2R.getId(), Ep2R);

		DecisionNode Ep2Aud = new DecisionNode(
				"Les Audacieux, connus pour leur bravoure et leur capacité à prendre des "
						+ "risques calculés, "
						+ "doivent démontrer leur agilité mentale pour triompher de cette épreuve. \n"
						+ "Cette épreuve met en lumière l'importance du positionnement stratégique, "
						+ "une compétence essentielle pour les Audacieux \n"
						+ "Devant vous se trouvent Marc, Antoine, et Pierre, "
						+ "chacun d'eux dans une position différente. Vous avez les informations suivantes :"
						+ "Marc est à gauche d'Antoine.\n"
						+ "Pierre n'est pas à côté d'Antoine. \n"
						+ "Qui est en position 3? \n"
						+ "1. Marc\n"
						+ "2. Antoine\n"
						+ "3. Pierre",
				3, i++, 0, 3, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep2Aud.getId(), Ep2Aud);

		DecisionNode Ep3R = new DecisionNode("Érudit, prépare toi à mettre tes capacités de résolution de problèmes à l'épreuve. \n"
				+ "Voici une énigme pour stimuler ton esprit aiguisé :\n"
				+ "\n"
				+ "D23, G20, J17, ??\n"
				+ "\n"
				+ "1. K13\n"
				+ "2. H14 \n"
				+ "3. M14 \n"
				+ "4. L15 \n", 4, i++, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep3R.getId(), Ep3R);
		
		
		
		DecisionNode Ep3Al= new DecisionNode("Bienvenue à la troisieme épreuve, cher Altruiste. Cette épreuve mettra à l'épreuve ta capacité à résoudre des situations complexes. Voici l'énigme qui te sera soumise :\n"
				+ "\n"
				+ "Une personne en voiture s'engage dans une rue à sens unique, des policiers l'arrêtent, lui demandent ses papiers, mais il repart sans problèmes. Pourquoi ?\n"
				+ "\n"
				+ "1. Le conducteur ne roulait pas à contresens mais dans le bon sens. \n"
				+ "2. Les policiers étaient en formation et ne pouvaient pas l'arrêter. \n"
				+ "3. La rue à sens unique avait été récemment modifiée. \n"
				+ "4. Le conducteur était un agent de police en service. \n"
				+ "5. La voiture du conducteur était volée, mais les policiers ne le savaient pas. \n", 5, i++, 3, 0, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep3Al.getId(), Ep3Al);
		

		DecisionNode Ep3Aud = new DecisionNode(
				"Dans un environnement stimulant, l'épreuve teste leur capacité à prendre des risques calculés"
						+ " même dans des situations qui demandent de la rapidité et de l'intrépidité. \n"
						+ "Bienvenue dans cette epreuve du temps : \n"
						+ "votre défi est de convertir 30 000 secondes en heures et en minutes le plus rapidement possible, vos options sont les suivantes : \n"
						+ "1. 8 heures et 20 minutes \n"
						+ "2. 5 heures et 45 minutes \n"
						+ "3. 6 heures et 45 minutes \n"
						+ "4. 9 heures et 15 minutes \n",
				4, i++, 0, 3, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep3Aud.getId(), Ep3Aud);

		DecisionNode Ep3Fr = new DecisionNode(
				"Bienvenue, Fraternel dans cette 3 eme epreuve, au cours de laquelle nous mettrons a l'epreuve ta connaissance de tes freres. \n "
						+ "- A est le père de B \n"
						+ "- C est la fille de A \n"
						+ "- D est la soeur de E \n"
						+ "- E est le fils de B \n"
						+ "Qui est le grand-père de D?"
						+ "Options : \n"
						+ "1. A"
						+ "2. B"
						+ "3. C"
						+ "4. E",
				4, i++, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep3Fr.getId(), Ep3Fr);

		DecisionNode Ep3S = new DecisionNode(
				"Bienvenue dans cette épreuve, où ton discernement sera mis à l'épreuve. Les Sincères, maîtres de la vérité, comprennent l'importance de faire des distinctions subtiles. "
						+ "Dans un monde où chaque mot compte, identifier l'intrus est une compétence cruciale. \n"
						+ "Quel est l'intrus?\n"
						+ "1. Firme\n"
						+ "2. Entreprise\n"
						+ "3. Établissement\n"
						+ "4. Commercial\n"
						+ "5. Société\n"
						+ " ",
				5, i++, 0, 0, 0, 0, 3, outil, scanner);
		dictionnaireNode.put(Ep3S.getId(), Ep3S);
		
		
		
		DecisionNode Ep4Al = new DecisionNode("Ton personnage altruiste se trouve confronté à une situation où il doit transporter de l'eau sans utiliser de récipient. Ses qualités altruistes peuvent-elles lui fournir une solution ingénieuse ?\n"
				+ "\n"
				+ "1. En demandant de l'aide à quelqu'un pour transporter l'eau.\n"
				+ "2. En creusant un petit canal pour guider l'eau vers sa destination.\n"
				+ "3. En réfléchissant à une manière écologique et respectueuse de l'environnement de transporter l'eau. \n"
				+ "4. En la congelant avant. \n",4, i++, 3, 0, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep4Al.getId(),Ep4Al);
		

		DecisionNode Ep4Aud = new DecisionNode("Bienvenue, Audacieux, dans l'Épreuve de Vitesse Extrême !\n"
				+ "Imagine-toi en pleine action, prêt à défier les lois de la physique. Ton défi est de convertir une vitesse de 54 km/h en m/s. Oui, tu as bien entendu, une mission de conversion de chiffres où chaque seconde compte.\n"
				+ "\n"
				+ "Options pour cette épreuve de pur dynamisme :\n"
				+ "\n"
				+ "1. 15 m/s\n"
				+ "2. 20 m/s\n"
				+ "3. 10 m/s\n"
				+ "4. 25 m/s\n"
				+ "", 4, i++, 0, 3, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep4Aud.getId(), Ep4Aud);

		DecisionNode Ep4S = new DecisionNode(
				"\"Bienvenue dans cette épreuve, où la précision et l'exactitude sont de rigueur. \n"
						+ "Dans un monde où la vérité se trouve souvent dans les détails, es-tu prêt à montrer ta perspicacité orthographique ? \n"
						+ "Le nom commun ci-dessous est-il bien orthographié?\n"
						+ "Coline \n"
						+ "1. Oui"
						+ "2. Non",
				2, i++, 0, 0, 0, 0, 4, outil, scanner);
		dictionnaireNode.put(Ep4S.getId(), Ep4S);

		DecisionNode Ep4Fr = new DecisionNode(
				"Bienvenue à cette épreuve fraternelle où les compétences en commerce et en gestion fingradeancière sont mises à "
						+ "l'épreuve. Imagine que tu es en charge d'un capital, "
						+ "reflétant l'esprit fraternel de collaboration et de partage des ressources. U"
						+ "n capital de 1 000 € est placé à un taux annuel de 5% pendant 9 mois. "
						+ "Calcule le capital acquis après cette période. "
						+ "Choisis judicieusement parmi les options pour maximiser le bénéfice, "
						+ "1. 1 037.5€\n"
						+ "2. 1 040.0€\n"
						+ "3. 1 042.5€\n"
						+ "4. 1 045.0€",
				4, i++, 0, 0, 0, 3, 0, outil, scanner);
		dictionnaireNode.put(Ep4S.getId(), Ep4S);

		DecisionNode Ep4R = new DecisionNode(
				"Bienvenue à l'épreuve érudite, où la maîtrise des calculs complexes est la clé du succès. Imagine que tu te trouves au cœur de la bibliothèque érudite, entouré de connaissances profondes. Calcule avec précision (4√2)² pour démontrer ton intelligence exceptionnelle.\n"
						+ "\n"
						+ "Options :\n"
						+ "1. 8\n"
						+ "2. 16\n"
						+ "3. 32\n"
						+ "4. 64\n"
						,
				4, i++, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep4R.getId(), Ep4R);
		
		
		
		
		DecisionNode Ep5Al = new DecisionNode("Altruiste, tu te trouves desormais face à une énigme philosophique. \n "
				+ "Peux-tu résoudre ce dilemme en utilisant ta vision altruiste du monde ?\n"
				+ "Pour moi l'accouchement est avant la grossesse, l'enfance avant la naissance, l'adolescence avant l'enfance, la mort\r\n"
				+ "avant la vie. Qui suis-je?\n"
				+ "1. Le cycle de la vie et de la mort.\n"
				+ "2. Le dictionnaire \n"
				+ "3. La réincarnation .\n"
				+ "4. Le temps \n"
			,			4, i++, 3, 0, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep5Al.getId(), Ep5Al);

		
		
		

		DecisionNode Ep5Aud = new DecisionNode(
				"Bienvenue à cette épreuve audacieuse où la précision et la visée sont cruciales. "
						+ "Les Audacieux, toujours prêts à affronter des défis, se lancent dans le domaine des unités d'angle. "
						+ "Imagine que tu as un objectif à atteindre, similaire à la précision nécessaire pour toucher une cible. "
						+ "Trouve la mesure de l'angle dont l'angle complémentaire est égal à 38.4°. Sois vif et précis dans tes calculs, "
						+ "car chaque degré compte dans cette mission audacieuse.\n"
						+ "1. 51° 60'\n"
						+ "2. 51° 40'\n"
						+ "3. 51° 36'\n"
						+ "4. 51° 30'\n"
						+ "",
				4, i++, 0, 3, 0, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep5Aud.getId(), Ep5Aud);

		DecisionNode Ep5S = new DecisionNode(
				"Bienvenue à cette épreuve, où la logique et les relations sémantiques te mettront à l'épreuve. Les Sincères, experts en communication,"
						+ " comprennent l'importance des associations précises. \n"
						+ "Sois prêt à démontrer ta capacité à saisir les nuances de sens et à établir des connexions intelligentes."
						+ "VIDE est à PLEIN ce que SOIRÉE est à ...\n"
						+ "1. Temps\n"
						+ "2. fingrade\n"
						+ "3. Réveil\n"
						+ "4. Heure\n"
						+ "5. Matinée \n"
					,
				5, i++, 0, 0, 0, 0, 3, outil, scanner);
		dictionnaireNode.put(Ep5S.getId(), Ep5S);

		DecisionNode Ep5Fr = new DecisionNode(
				"Bienvenue à cette épreuve fraternelle où les compétences en agriculture et "
						+ "en calcul sont à l'honneur. "
						+ "Les Fraternels, maîtres des champs, doivent également exceller dans les domaines mathématiques. "
						+ "Imagine que tu cultives un champ avec un cercle de rayon r = 5 m. "
						+ "Calcule l'aire du cercle pour maximiser la productivité agricole. Choisis judicieusement parmi les options pour démontrer la force intellectuelle"
						+ " et la connexion avec la nature des Fraternels. \n"
						+ "1. 2.5 π m2\n"
						+ "2. 5 π m2\n"
						+ "3. 10 π m2\n"
						+ "4. 25 π m2",
				4, i++, 0, 0, 0, 3, 0, outil, scanner);
		dictionnaireNode.put(Ep5S.getId(), Ep5S);

		DecisionNode Ep5R = new DecisionNode(
				"Bienvenue dans le défi érudit, où la résolution d'équations complexes mettra à l'épreuve ta sagacité."
						+ " Imagine-toi dans le sanctuaire du savoir, prêt à résoudre des mystères mathématiques. \n"
						+ " Détermine la valeur de "
						+ "X dans l'équation suivante : \n"
						+ " √80 = 2√X \n"
						+ "Options :\n"
						+ "1. 5\n"
						+ "2. 10\n"
						+ "3. 20\n"
						+ "4. 40\n",
				4, i++, 0, 0, 3, 0, 0, outil, scanner);
		dictionnaireNode.put(Ep5R.getId(), Ep5R);
		
		
		
		ChanceNode epreuveChance2 = new ChanceNode(
				"Félicitations, valeureux aventurier ! Tu as triomphé des multiples épreuves qui ont jalonné ton parcours. \n"
				+ "Ta perspicacité, ton courage et ta détermination t'ont guidé à travers des défis complexes et variés.\n"
				+ " Nous sommes admiratifs devant votre succès et nous vous saluons pour avoir surmonté toutes les épreuves avec brio. "
				+ "\n Continue à explorer, à apprendre et à grandir. \n"
				+ " Le monde est vaste, et tu as prouvé que tu es prêt pour toutes les aventures qui t'attendent."
				+ " Bravo !.\n"
						,
				1, i++, 0, 0, 0, 0, 0, null, scanner);
		dictionnaireNode.put(epreuveChance2.getId(), epreuveChance);
		
	

		TerminalNode fin = new TerminalNode ("Helas, la partie se termine pour toi ! \n", i++);
		dictionnaireNode.put(fin.getId(), fin);
		
		TerminalNode Novice = new TerminalNode("Helas, la partie se termine pour toi ! \n"
				+ "Tu as obtenu le grade de Novice, tu feras mieux la prochaine fois, a bientot ! ", i++);
		dictionnaireNode.put(Novice.getId(), Novice);
		
		TerminalNode Apprentice = new TerminalNode("Helas, la partie se termine pour toi ! \n"
				+ "Tu as obtenu le grade d'Apprenti, tu feras mieux la prochaine fois, a bientot ! ", i++);
		dictionnaireNode.put(Apprentice.getId(), Apprentice);
		
		TerminalNode Journeyman = new TerminalNode("Helas, la partie se termine pour toi ! \n"
				+ "Tu as obtenu le grade de Journeyman , tu feras mieux la prochaine fois, a bientot ! ", i++);
		dictionnaireNode.put(Journeyman.getId(), Journeyman);
		
		TerminalNode Expert = new TerminalNode("Helas, la partie se termine pour toi ! \n"
				+ "Tu as obtenu le grade d'expert, bravo et bon boulot, tu feras peut etre encore mieux la prochaine fois, a bientot ! ", i++);
		dictionnaireNode.put(Expert.getId(), Expert);
		
		TerminalNode Master = new TerminalNode("Helas, toutes les bonnes choses ont une fin ! \n"
				+ "Tu as obtenu le grade de Master, le grade maximal dans le monde de Divergent, tu es desormais a la tete de ta faction, a bientot pour de nouvelles aventures ! ", i++);
		dictionnaireNode.put(Master.getId(), Master);
		
		
		ChoixGrade fingrade= new ChoixGrade (currentPerso," ",fin, Novice,Apprentice,Journeyman,Master,Expert, 6, i++, 0, 0, 0, 0, 0, outil);
		dictionnaireNode.put(fingrade.getId(), fingrade);

	
		

		choixFaction.setFactions(FactionAl, FactionAud, FactionEr, FactionFr, FactionSinc, Divergent);
		 fingrade.setGrade(fin, Novice,Apprentice,Journeyman ,Master,Expert);
		
		premiereEpreuve.setOptions(List.of(ChoixCouteau, ChoixFromage, ChoixLivre, ChoixEcharpe, ChoixJournal));

		ChoixLivre.setOptions(List.of(ChoixEr, ChoixCouteau));
		ChoixCouteau.setOptions(List.of(ChoixAu, ChoixFromage));
		ChoixFromage.setOptions(List.of(ChoixFr, ChoixEcharpe));
		ChoixEcharpe.setOptions(List.of(ChoixAl, ChoixJournal));
		ChoixJournal.setOptions(List.of(ChoixFacS, ChoixFuite));

		ChoixAu.setOptions(List.of(ZoneAudacieux, ChoixLivre));
		ChoixAl.setOptions(List.of(ZoneAltruiste, ChoixCouteau));
		ChoixEr.setOptions(List.of(ZoneErudit, ChoixEcharpe));
		ChoixFr.setOptions(List.of(ZoneFraternels, ChoixJournal));
		ChoixFacS.setOptions(List.of(ZoneSincere, ChoixAu));

		ZoneAudacieux.setOptions(List.of(epreuveChance, ChoixFr));
		ZoneAltruiste.setOptions(List.of(epreuveChance, ChoixAl));
		ZoneErudit.setOptions(List.of(epreuveChance, ChoixFr));
		ZoneFraternels.setOptions(List.of(ChoixEr, epreuveChance));
		ZoneSincere.setOptions(List.of(epreuveChance, epreuveChance));
		epreuveChance.setOptions(List.of(choixFaction));
		choixFaction.setOptions(List.of(FactionAl, FactionAud, FactionEr, FactionFr, FactionSinc, Divergent));
		fingrade.setOptions(List.of(fin, Novice, Apprentice, Journeyman, Master, Expert));


		FactionSinc.setOptions(List.of(Ep2S, fingrade, fingrade, fingrade, fingrade));
		FactionEr.setOptions(List.of(Ep2R, fingrade, fingrade, fingrade, fingrade));
		FactionFr.setOptions(List.of(fingrade, fingrade, Ep2Fr, fingrade));
		FactionAud.setOptions(List.of(fingrade, Ep2Aud));
		FactionAl.setOptions(List.of(fingrade,fingrade, Ep2Al));
		

		Ep2R.setOptions(List.of(Ep3R, fingrade, fingrade, fingrade, fingrade));
		Ep2Aud.setOptions(List.of(fingrade, Ep3Aud, fingrade));
		Ep2Fr.setOptions(List.of(fingrade, fingrade, fingrade, Ep3Fr));
		Ep2S.setOptions(List.of(fingrade, Ep3S, fingrade, fingrade, fingrade));
		Ep2Al.setOptions(List.of(Ep3Al, fingrade, fingrade, fingrade,fingrade));

		Ep3Aud.setOptions(List.of(Ep4Aud, fingrade, fingrade, fingrade));
		Ep3R.setOptions(List.of( fingrade, fingrade,Ep4R, fingrade));
		Ep3S.setOptions(List.of(fingrade, fingrade, fingrade, Ep4S, fingrade));
		Ep3Fr.setOptions(List.of(Ep4Fr, fingrade, fingrade, fingrade, fingrade));
		Ep3Al.setOptions(List.of(Ep4Al, fingrade, fingrade, fingrade,fingrade));

		Ep4Aud.setOptions(List.of(Ep5Aud, fingrade, fingrade, fingrade));
		Ep4S.setOptions(List.of(fingrade, Ep5S));
		Ep4Fr.setOptions(List.of(Ep5Fr, fingrade, fingrade, fingrade));
		Ep4R.setOptions(List.of(fingrade, fingrade, Ep5R, fingrade));
		Ep4Al.setOptions(List.of(fingrade, fingrade, fingrade,Ep5Al));

		Ep5Al.setOptions(List.of(fingrade,epreuveChance2,fingrade, fingrade));
		Ep5S.setOptions(List.of(fingrade, fingrade, fingrade, fingrade, epreuveChance2));
		Ep5Aud.setOptions(List.of(fingrade, fingrade, epreuveChance2, fingrade));
		Ep5Fr.setOptions(List.of(fingrade, fingrade, fingrade, epreuveChance2));
		Ep5R.setOptions(List.of(fingrade, fingrade, epreuveChance2, fingrade));
		
		 epreuveChance2.setOptions(List.of(fingrade));
		
		this.currentNode = debut;

	}

}
