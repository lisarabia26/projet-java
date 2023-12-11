package representation;

import java.util.Scanner;
import java.util.List;
import univers.*;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static Node initEpreuve(Personnage currentPerso, Personnage[] persoPossibles, Scanner scanner) {
		int i = 0;
		DecisionNode premiereEpreuve = new DecisionNode(
				"\"Vous savourez une gorgée du mystérieux sérum qui coule dans vos veines, imprégnant chaque coin de votre être d'une énergie inconnue. "
						+ "À peine le liquide touche-t-il votre palais que votre conscience s'embrouille, vous plongeant dans un rêve éthéré.\n"
						+ "Dans ce rêve, vous vous tenez devant cinq paniers, chaque objet révélant une essence unique. Un choix crucial s'offre à vous\n"
						+ "1-un couteau\n" + "2-un morceau de fromage\n" + "3-un livre\n" + "4-une écharpe\n"
						+ "5-un journal intime\n" + "6- ne rien choisir\n",
				5, i + 1, 0, 0, 0, 0, 0, null, scanner);
		ChoixPerso debut = new ChoixPerso(currentPerso, persoPossibles, premiereEpreuve,
				"Choisissez un personnage:\n" + "Personnage 1:\n" + persoPossibles[0].getNom()
						+ persoPossibles[0].getDescription() + "\nPersonnage 2:\n" + persoPossibles[1].getNom()
						+ persoPossibles[1].getDescription() + "\nPersonnage 3:\n" + persoPossibles[2].getNom()
						+ persoPossibles[2].getDescription() + "\nPersonnage 4:\n" + persoPossibles[3].getNom()
						+ persoPossibles[3].getDescription() + "\nPersonnage 5:\n" + persoPossibles[4].getNom()
						+ persoPossibles[4].getDescription(),
				i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixCouteau = new DecisionNode(
				"Votre choix du couteau, symbole de puissance et de protection, vous conduit à une épreuve inattendue. "
						+ "Soudain, un chien surgit, les crocs découverts, prêt à l'attaque."
						+ " Devant vous, une porte mystérieuse, 2 choix se presentent a vous\\n"
						+ "Choix 1 : Affronter le chien avec détermination grâce au couteau récupéré\n"
						+ "Choix 2 : Eviter la violence, choisir la fuite\n",
				2, i++, 0, 3, 1, 0, 0, null, scanner);
		DecisionNode ChoixFromage = new DecisionNode(
				"Votre choix du morceau de fromage, symbole de partage et de subsistance, vous conduit à une situation délicate. "
						+ "Alors que vous errez, vous retrouvez d'anciens camarades, mais la scène qui se dévoile est loin d'être réjouissante. "
						+ "Plusieurs d'entre eux sont blessés, nécessitant une aide immédiate.\n"
						+ "Au détour de votre chemin, vous découvrez un groupe de connaissances qui détiennent des médicaments salvateurs."
						+ " Cependant, une réalité inattendue se présente : la longue marche vous a creusé l'appétit."
						+ "Choix 1: Troquer votre fromage contre des médicaments"
						+ "Choix 2: Manger votre fromage en secret",
				2, i++, 0, 0, 1, 3, 0, null, scanner);
		DecisionNode ChoixLivre = new DecisionNode(
				"Votre choix du livre, symbole de connaissance et de sagesse, vous place face à un défi inattendu. "
						+ "Alors que vous avancez, un chien menaçant surgit, prêt à vous attaque.\n "
						+ "Choix 1 : Baisser les yeux et vous éloigner du chien \n"
						+ "Choix 2 : Jeter le livre sur le chien\n",
				2, i++, 0, 0, 3, 0, 0, null, scanner);
		DecisionNode ChoixEcharpe = new DecisionNode(
				"Votre choix de l'écharpe, symbole de chaleur et de réconfort, vous conduit à une rencontre inattendue. "
						+ "Alors que vous marchez, un vent glacial s'abat sur la ville. Cependant, grâce à votre écharpe, vous restez au chaud.\n"
						+ "Soudain, vous apercevez un vieil homme frissonnant, visiblement gelé. Deux options s'offrent à vous:\n"
						+ "Choix 1 : Lui offrirx votre echarpe\n" + "Choix 2 : Garder votre echarpe\n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		DecisionNode ChoixJournal = new DecisionNode(
				" Votre choix du journal intime, un moyen d'expression personnelle et d'authenticité, vous amène à une situation inhabituelle."
						+ " Vous vous retrouvez sur une estrade, face à un grand public, où chacun lit à tour de rôle son journal intime.\n"
						+ "Dans ce moment de partage intime, deux options se présentent à vous, révélant votre approche face à la mise en lumière de votre vie privée.\n"
						+ "Choix 1 : Lire fièrement votre journal\n" + "Choix 2 : Fuir la scène\n",
				2, i++, 0, 0, 0, 0, 3, null, scanner);


		DecisionNode ChoixFacS = new DecisionNode(

				"Soudainement, tout s'efface autour de vous. L'environnement change radicalement, et vous vous retrouvez dans un bus. "
						+ "Sans argent ni ticket, le chauffeur vous fixe droit dans les yeux et vous interroge sur la possession d'un ticket.\n"
						+ "Devant cette situation délicate, deux options se présentent à vous,\n "
						+ "révélant votre attitude face à l'éthique et à la légalité dans un monde où les choix peuvent avoir des conséquences importantes.\n"
						+ "Choix 1 : Mentir et frauder\n"
						+ "Choix 2 : Jurer par la vérité, et avouer au chauffeur de bus au risque de vous faire renvoye \n",

				2, i++, 0, 0, 0, 0, 3, null, scanner);

		DecisionNode ChoixAu = new DecisionNode(

				" En marchant, vous observez une scène dérangeante : une jeune femme est harcelée par un groupe de voyous.\n"
						+ "Cependant, la marche intense vous a fatigué. Que décidez-vous de faire?\n"
						+ "Choix 1 : Vous décidez de vous interposer et défendre la jeune femme.\n"
						+ "Choix 2 : Vous choisissez de ne pas vous impliquer, considérant que cela ne vous regarde pas.\n",

				2, i++, 0, 3, 0, 0, 0, null, scanner);

		DecisionNode ChoixAl = new DecisionNode(
				"Vous peinez a trouver une place, cependant, au moment ou vous vous asseyez\n"

						+ "une vieille dame rentre dans le bus \n"

						+ " 2 choix se presentent a vous\n"

						+ "Choix 1 : Vous lui laissez votre place \n"

						+ "Choix 2 : Vous restez assis \n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);

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


		DecisionNode ChoixFuite1 = new DecisionNode("Vous avez decidez de fuir, malheuresement cee choix est fatal pour vous.\n"
				+ " /n",1,  i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixFuite2 = new DecisionNode("Vous avez decide de manger le fromage /n", 1, i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixFuite3 = new DecisionNode("Vous avez jete le livre sur le chien, mauvaise idee, "

				+ "celui-ci vous attaque aussitot /n",1,  i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixFuite4 = new DecisionNode("Vous gardez votre echarpe /n", 1, i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixFuite5 = new DecisionNode("Vous avez decide de fuir /n",1,  i++, 0, 0, 0, 0, 0, null, scanner);
		
		//ChanceNode DernièreChance= new ChanceNode()
		
		
		
		
		
		premiereEpreuve.setOptions(List.of(ChoixCouteau, ChoixFromage, ChoixLivre, ChoixEcharpe, ChoixJournal));
		ChoixCouteau.setOptions(List.of(ChoixAu, ChoixFuite1));
		ChoixFromage.setOptions(List.of(ChoixFr, ChoixFuite2));
		ChoixEcharpe.setOptions(List.of(ChoixAl, ChoixFuite4));
		ChoixLivre.setOptions(List.of(ChoixEr, ChoixFuite3));
		ChoixJournal.setOptions(List.of(ChoixFacS, ChoixFuite5));

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
		// Définissez le frame uktuict-uyrvytc
		JFrame frame = new JFrame("Personnage possible");
		// L'en-têtes du JTable
		String[] column = { "Nom", "Age", "description" };

		// Les lignes du JTable
		String[][] data = { { "Antoine", "16",
				"au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres." },
				{ "02", "Emily", "45", "Marseille" },
				{ "Christina", "16",
						"Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve." },
				{ "Emily", "16",
						"discrète et bienveillante, semble constamment préoccupée par le bien-être des autres." },
				{ "Julien", "16",
						"toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre." },
				{ "Sophie", "16",
						"avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants." } };

		// Créer le JTable
		JTable table = new JTable(data, column);
		JScrollPane scroll = new JScrollPane(table);
		frame.add(scroll);
		frame.pack();
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JLabel label = new JLabel("", JLabel.CENTER);
		frame.add(label);

		// Définissez le panel
		JPanel panel = new JPanel();
		// Définir les boutons
		JButton btn1 = new JButton("Antoine");
		JButton btn2 = new JButton("Christina");
		JButton btn3 = new JButton("Emily");
		JButton btn4 = new JButton("Julien");
		JButton btn5 = new JButton("Sophie");
		// Ajouter les boutons au frame
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		// Ajouter label et panel au frame
		frame.setLayout(new GridLayout(2, 1));
		frame.add(label);
		frame.add(panel);

		frame.pack();
		frame.setSize(400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// DGYBRIUYGIY
		Node currentNode = initEpreuve(currentPerso, personnages, new Scanner(System.in));

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