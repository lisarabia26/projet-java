package representation;

import java.util.Scanner;



import univers.*;
import javax.swing.*;
import java.awt.*;


public class Main {

	public static Node initEpreuve(Personnage currentPerso, Personnage[] persoPossibles, Scanner scanner) {
		int i = 0;
		DecisionNode premiereEpreuve = new DecisionNode("Vous vous retrouvez dans un rêve,\n"
				+ "Vous buvez un sérum avant de devenir inconscient. Face à vous, cinq paniers contenant respectivement\n"
				+ "1-un couteau\n" + "2-un morceau de fromage\n" + "3-un livre\n" + "4-une écharpe\n"
				+ "5-un journal intime\n" + "6- ne rien choisir\n", 5, i + 1, 0, 0, 0, 0, 0, null, scanner);
		ChoixPerso debut = new ChoixPerso(currentPerso, persoPossibles, premiereEpreuve,
				"Choisissez un personnage:\n" + "Personnage 1:\n" + persoPossibles[0].getNom()
						+ persoPossibles[0].getDescription() + "\nPersonnage 2:\n" + persoPossibles[1].getNom()
						+ persoPossibles[1].getDescription() + "\nPersonnage 3:\n" + persoPossibles[2].getNom()
						+ persoPossibles[2].getDescription() + "\nPersonnage 4:\n" + persoPossibles[3].getNom()
						+ persoPossibles[3].getDescription() + "\nPersonnage 5:\n" + persoPossibles[4].getNom()
						+ persoPossibles[4].getDescription(),
				i++, 0, 0, 0, 0, 0, null, scanner);

		DecisionNode ChoixCouteau = new DecisionNode(
				"Un chien apparait et essaye de vous attaquer, devant vous une porte,"
						+ " 2 choix se presentent a vous\n" + "Choix 1 : l'attaquer avec le couteau recupere\n"
						+ "Choix 2 : Vous n'aimez pas la violence, vous preferez fuir\n",
				2, i++, 0, 3, 1, 0, 0, null, scanner);
		DecisionNode ChoixFromage = new DecisionNode(
				"Apres avoir choisi le fromage, vous errez avant de retrouver des anciens camarades, plusieurs d’entre eux sont blessés \n "
						+ "vous rencontrez un groupe de connaissance qui ont en leur possession des medicaments,"
						+ " Sauf que cette marche vous a donne faim\n"
						+ "Choix 1 :Vous troquez votre fromage contre des medicaments pour aider vos amis\n"
						+ "Choix 2 : Vous mangez votre fromage secretement (personne ne vous a vu ;) ) \n",
				2, i++, 0, 0, 1, 3, 0, null, scanner);
		DecisionNode ChoixLivre = new DecisionNode("Un chien apparait et essaye de vous attaquer \n"
				+ " 2 choix se presentent a vous\n" + "Choix 1 : Vous baissez les yeux et vous vous eloignez du chien\n"
				+ "Choix 2 : Vous jetez le livre sur le chien\n", 2, i++, 0, 0, 3, 0, 0, null, scanner);
		DecisionNode ChoixEcharpe = new DecisionNode(
				"Un vent s'abat sur la ville, mais heureusement pour vous, vous avez "
						+ "choisi une echarpe, cependant en marchant, vous apercevant un pauvre vieil homme gele,"
						+ "deux choix s'offrent a vous" + "Choix 1 : Vous lui offrez votre echarpe\n"
						+ "Choix 2 : Vous gardez votre echarpe\n",
				2, i++, 3, 0, 0, 0, 0, null, scanner);
		DecisionNode ChoixJournal = new DecisionNode(
				" vous vous retrouvez sur une estrade face a un grand public"
						+ " où tout le monde lit a tour de role son journal intime, " + "deux choix s'offrent a vous \n"
						+ "Choix 1 : Vous lisez fièrement votre journal\n" + "Choix 2 : Vous fuiez\n",
				2, i++, 0, 0, 0, 0, 3, null, scanner);

		premiereEpreuve.setOptions(new Node[] { ChoixCouteau, ChoixFromage, ChoixLivre, ChoixEcharpe, ChoixJournal });
		Node[] optionsDebut = premiereEpreuve.getOptions();
		optionsDebut[0] = ChoixCouteau;
		optionsDebut[1] = ChoixFromage;
		optionsDebut[2] = ChoixLivre;
		optionsDebut[3] = ChoixEcharpe;
		optionsDebut[4] = ChoixJournal;

		// ...

        DecisionNode ChoixFacS = new DecisionNode(

                "Tout d'un coup, tout s'efface et vous vous retrouvez dans un bus, sans argent ni ticket, le chauffeur vous regarde "

                + "droit dans les yeux et vous demande si vous avez un ticket en votre possession"

                + "ou souhaitez vous en acheter  ,"

                                               + " 2 choix se presentent a vous\n"

                                               + "Choix 1 : Vous mentez et fraudez\n"

                                               + "Choix 2 : Vous ne jurez que par la verite, et avouez au chauffeur de bus au risque de vous faire "

                                               + "renvoye \n",



                2, i++, 0, 0, 0, 0, 3, null, scanner);

DecisionNode ChoixAu = new DecisionNode(

                " il voit une jeune femme se fait harceler par un groupe de voyou, "

                                               + " Sauf que cette marche vous a donne faim\n"

                                               + "Choix 1 : S'interposer pour la defendre\n"

                                               + "Choix 2 : Ca ne vous regarde pas \n",

                2, i++, 0, 3, 0, 0, 0, null, scanner);

DecisionNode ChoixAl = new DecisionNode("Vous peinez a trouver une place, cependant, au moment ou vous vous asseyez"

                + "une vieille dame rentre dans le bus \n"

                + " 2 choix se presentent a vous\n"

                + "Choix 1 : Vous lui laissez votre place \n"

                + "Choix 2 : Vous restez assis \n", 2, i++, 3, 0, 0, 0, 0, null, scanner);

DecisionNode ChoixEr = new DecisionNode(

                "Alors que vous vous installez dans le bus, vous découvrez un mystérieux carnet contenant des énigmes complexes et intrigantes. "

                + "Chaque page semble renfermer des secrets mathématiques fascinants. Deux choix s'offrent à vous : "



                                               + "Choix 1 : Vous vous plongez immédiatement dans la résolution des énigmes.\n"

                                               + "Intrigué par le mystère du carnet, votre personnage décide de résoudre les énigmes mathématiques."

                                               + " Cela pourrait le conduire à une découverte passionnante ou dévoiler un message caché\n"

                                               + "Choix 2 : Vous décidez de remettre le carnet au chauffeur en tant qu'objet trouvé.\n"

                                               + "Pensant que le carnet pourrait être précieux pour quelqu'un d'autre"

                                               + "Vous faites cela dans l'espoir que le propriétaire légitime le retrouvera\n",

                2, i++, 0, 0, 3, 0, 0, null, scanner);

DecisionNode ChoixFr = new DecisionNode("Votre personnage repère un groupe de personnes rassemblées dans un coin du bus,"

                + " discutant et riant ensemble. Deux choix s'offrent à lui :"

                + "1. Il décide de se joindre au groupe spontanément.\n"

                + "Attiré par l'énergie positive du groupe, votre personnage décide de les rejoindre, espérant participer à la conversation animée. "

                + "Cela pourrait être une opportunité de créer de nouvelles connexions et amitiés.  \n"



                + "2. Il choisit de rester à sa place et de ne pas interrompre le groupe.\n"

                + "Préférant ne pas déranger le groupe déjà formé, votre personnage décide de rester à sa place et de ne pas se joindre à eux. "

                + "Il peut penser qu'il est plus prudent de respecter leur espace. \n", 2, i++, 0, 0, 0, 3, 0, null, scanner);









DecisionNode ChoixFuite1 = new DecisionNode("Vous avez decide de fuir /n",1, i++, 0, 0, 0, 0, 0, null, scanner);

DecisionNode ChoixFuite2 = new DecisionNode("Vous avez decide de manger le fromage /n",1, i++, 0, 0, 0, 0, 0, null, scanner);

DecisionNode ChoixFuite3 = new DecisionNode("Vous avez jete le livre sur le chien, mauvaise idee, "

                + "celui-ci vous attaque aussitot /n",1, i++, 0, 0, 0, 0, 0, null, scanner);

DecisionNode ChoixFuite4 = new DecisionNode("Vous gardez votre echarpe /n",1, i++, 0, 0, 0, 0, 0, null, scanner);

DecisionNode ChoixFuite5 = new DecisionNode("Vous avez decide de fuir /n",1, i++, 0, 0, 0, 0, 0, null, scanner);









ChoixCouteau.setOptions(new Node[] { ChoixAu, ChoixFuite1 });

ChoixFromage.setOptions(new Node[] { ChoixFr, ChoixFuite2  });

ChoixEcharpe.setOptions(new Node[] {  ChoixAl, ChoixFuite4 });

ChoixLivre.setOptions(new Node[] { ChoixEr, ChoixFuite3   });

ChoixJournal.setOptions(new Node[] {  ChoixFacS,  ChoixFuite5  });



Node[] optionsChoix1 = ChoixCouteau.getOptions();

Node[] optionsChoix2 = ChoixFromage.getOptions();

Node[] optionsChoix3 = ChoixEcharpe.getOptions();

Node[] optionsChoix4 = ChoixLivre.getOptions();

Node[] optionsChoix5 = ChoixJournal.getOptions();



optionsChoix1[0] = ChoixAu ;

optionsChoix1[1] = ChoixFuite1 ;



optionsChoix2[0] = ChoixFr;

optionsChoix2[1] = ChoixFuite2;



optionsChoix3[0] = ChoixAl;

optionsChoix3[1] = ChoixFuite3;



optionsChoix4[0] = ChoixEr;

optionsChoix4[1] = ChoixFuite4;



optionsChoix5[0] = ChoixFacS;

optionsChoix5[1] = ChoixFuite5;





return debut;

	}

	public static void main(String[] args) {
		System.out.println("Le monde que tu t'apprêtes à explorer est un lieu mystérieux, où les frontières entre réalité et illusion s'estompent.\n"
				+ " Bienvenue dans le monde de Divergente, où chaque choix que tu feras influencera le cours de ton aventure.\n"
				+ "Avant de commencer ton voyage, tu dois choisir un personnage parmi les cinq ombres mystérieuses qui se tiennent devant toi. \n"
				+ "Chacune représente une essence unique, une histoire à explorer. Ton choix ne sera pas simplement esthétique, "
				+ "mais guidera tes actions et définira ton destin dans le monde captivant de Divergente. \n"
				+ "Choisis avec sagesse, car le destin de Divergente t'appelle, et tu es sur le point d'écrire ton propre chapitre. Que l'aventure commence...");
		Outil outil1 = null;
		Personnage currentPerso = new Personnage();
		Personnage[] personnages = new Personnage[5];
		personnages[0] = new Personnage("Antoine ", 10, 5, 8, 3, 7,
				"au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres. "
						+ "Ses actions désintéressées et son inclination naturelle à soutenir ceux qui l'entourent soulignent son attachement profond aux liens humains. "
						+ "Sa façon chaleureuse d'interagir avec les autres, ponctuée de gestes attentionnés, trahit une prédisposition à la fraternité.",
				outil1);
		personnages[1] = new Personnage("Christina", 8, 7, 5, 4, 6,
				" Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve. "
						+ "Elle ne craint pas l'inconnu et est souvent vue en train d'explorer des territoires inexplorés.",
				outil1);

		personnages[2] = new Personnage("Emily", 5, 6, 4, 8, 3,
				" discrète et bienveillante, semble constamment préoccupée par le bien-être des autres. "
						+ "Son attitude chaleureuse et son sourire doux indiquent une sensibilité particulière envers les émotions des gens qui l'entourent. "
						+ "Son choix vestimentaire privilégie souvent des tons apaisants, reflétant son désir d'harmonie et de compassion.",
				outil1);

		personnages[3] = new Personnage("Julien", 7, 4, 6, 5, 9,
				" toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre. "
						+ "Son esprit curieux et analytique révèle une passion profonde pour la recherche de la vérité et la quête du savoir. "
						+ "Ses conversations sont teintées d'une intelligence perceptible, et ses choix sont guidés par une volonté constante d'approfondir sa compréhension du monde qui l'entoure",
				outil1);

		personnages[4] = new Personnage("Sophie", 6, 8, 7, 2, 5,
				" avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants."
						+ " Sa manière de s'exprimer, sans artifices ni détours, dénote une sincérité profonde. "
						+ "Les nuances subtiles de ses expressions faciales révèlent une transparence émotionnelle, soulignant son engagement envers l'authenticité."
						+ " Un style vestimentaire simple mais élégant suggère qu'elle accorde de l'importance à l'expression véritable de soi.",
				outil1);
		// Définissez le frame  uktuict-uyrvytc
		JFrame frame = new JFrame("Personnage possible");
		// L'en-têtes du JTable
		String[] column = { "Nom", "Age", "description" };

		// Les lignes du JTable
		String[][] data = { {"Antoine", "16", "au cœur généreux, se distingue par son empathie et son attitude bienveillante envers les autres." }, { "02", "Emily", "45", "Marseille" },
				{  "Christina", "16", "Christina, au premier abord, semble être une personne qui apprécie l'exploration et l'expérience de nouvelles choses. Sa curiosité la pousse à chercher des défis et des situations qui mettent ses compétences à l'épreuve." },
				{ "Emily", "16", "discrète et bienveillante, semble constamment préoccupée par le bien-être des autres." }, 
				{ "Julien", "16", "toujours avide de connaissances, se plonge sans cesse dans les livres et explore le monde avec une soif insatiable d'apprendre." },
				{"Sophie", "16", "avec son regard direct et son langage non équivoque, laisse transparaître une honnêteté qui ne tolère guère les faux-semblants."}};
		
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
        //DGYBRIUYGIY
		Node currentNode = initEpreuve(currentPerso, personnages, new Scanner(System.in));

		while (!(currentNode instanceof TerminalNode)) {
			currentNode = currentNode.chooseNext();

			if (currentNode instanceof DecisionNode)
				((DecisionNode) currentNode).init(currentPerso);
			if (currentNode instanceof ChanceNode)
				((ChanceNode) currentNode).init(currentPerso);
		}
		System.out.println(currentNode.getDescription());

		// TODO Auto-generated method stub
		// premiere epreuve ou mettre le scanner????
	}

}
