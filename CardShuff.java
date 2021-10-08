// To Generate Random Numbers;
import java.util.Random;
import java.util.Scanner;





public class CardShuff{
	public static void main(String[] args) {


		// Initialize random

		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		// To monitor the 52 Numeric and card Types
		int countCards = 0;


		// To Count what Type of Card;
		int setCounter = 0;

		// Declare Array of types of cards
		final String[] card = {"Clubs", "Diamonds","Heart","Spade"};
		
		/*
		* Initializer
		* @ int cardNumCounter, Value of Numeric Card;
		* @ int[] numCard, Array to be fill in
		************
		* Goal to Fill the array of 1-13 numeric cards
		* Each set is composed of 1-13 cards.
		* ______ALGORITHM____
		* If cardNumCounter is 13.
		* Reset its Value to 1.
		* Repeat 4 times; 13*4 = 52
		*/

		//Array of Numeric Cards 52 Cards;
		int[] numCard = new int[52];
		// To count 1-13 as one set of Card;
		int cardNumCounter = 1;

		for (int a = 0; a < numCard.length ; a++) {
			numCard[a] = cardNumCounter;
			if(cardNumCounter == 13){
				cardNumCounter = 0;
			}
			cardNumCounter++;
		}

		/*
		* INITIALIZER
		* @ int typeOfCard, dictstes what type of card
		* @ String cType, Type of Card
		* @ String[] typeOfCard, Where 13 sets of type of card
		* __ALGORITHM__
		* If the typeOfCard: 1->Clubs, 2-> Dia, 3-> Spade, 4-> Hearts
		* Assign the value to cType and
		* Set the value of typeCard[index] to ctype Value;
		* Reset the Value of typeOfCard to Zero if the value is equal to 4;
		* Repeat the process to fill the entire typeCard[]
		*/

		// Array of cards [Clubs,diamonds,Heart, Spade]
		String[] typeCard = new String[52];
		int typeOfCard = 0;
		String cType = "";

		for(int a = 0; a < typeCard.length; a++){
			
			if(typeOfCard == 4){
				typeOfCard = 0;
			}

			switch(typeOfCard){
				case 0:
				cType = "Clubs";
				break;
				case 1:
				cType = "Diamonds";
				break;
				case 2:
				cType = "Spades";
				break;
				case 3:
				cType = "Hearts";
				break;

			}
			typeOfCard++;

			typeCard[a] = cType;

			

		}


		int remainingCards = 52; //(n-1)Length of Array
		int numMatch = 0;

		String xx;
		int yourScore = 0;
		int enemyScore = 0;

		do{

			int yourNumber = 0;
			int yourCardNum = 0;
			String yourCardType = "";
			String yourStatus = "";


			int opponentNumber = 0;
			int opponentCardNum = 0;
			String opponentCardType = "";
			String opponentStatus = "";





			System.out.println("\n**********************Round: "+ (numMatch+1) + "**********************");
			

		

			/*
			* ______YOURS_____-
			*/
			yourNumber = rand.nextInt(remainingCards);
			yourCardNum = numCard[yourNumber];
			yourCardType = typeCard[yourNumber];

			// SUBTRACT CARDS
			remainingCards--;

			// Move nUMERIC Cards to fill gap;
			// Move type Cards to fill gap;
			for (int a = yourNumber;a <= remainingCards ;a++) {
				numCard[yourNumber] = numCard[yourNumber+1];
				typeCard[yourNumber] = typeCard[yourNumber+1];
			}



			/*
			* ______OPPONENT_____-
			*/
			opponentNumber = rand.nextInt(remainingCards);
			opponentCardNum = numCard[opponentNumber];
			opponentCardType = typeCard[opponentNumber];

			// SUBTRACT CARDS
			remainingCards--;
			
			for (int a = opponentNumber;a <= remainingCards ;a++) {
				// Move nUMERIC Cards to fill gap;
				numCard[opponentNumber] = numCard[opponentNumber+1];
				// Move type Cards to fill gap;
				typeCard[opponentNumber] = typeCard[opponentNumber+1];
			}
			/*
			* Compare Cards
			* The higher the Card Winner
			*/
			if(opponentCardNum > yourCardNum){
				enemyScore++;
				opponentStatus = "Win";
				yourStatus = "Lose";
			}else{
				yourScore++;
				opponentStatus = "Lose";
				yourStatus = "Win";
			}
			/*
			* Print RESULT
			*/
			System.out.println("\n\t\tYOU \t\tEnemy");
			System.out.println("CardNum: \t" +yourCardNum + "\t\t" + opponentCardNum );
			System.out.println("CardType: \t" + yourCardType +"\t\t" + opponentCardType);
			System.out.println("\n***********\nResult: \t" + yourStatus + "\t\t" + opponentStatus + "\n\n");
			// System.out.println("\n\t\tScore");
			// System.out.println("You: " + yourScore);
			// System.out.println("Enemy: " + enemyScore);


			System.out.println("\t\t\tSCORE");
			System.out.println("YOU: "+ yourScore + "\tOpponent: "+ enemyScore);

			System.out.print("\n\nPress any Key and Enter: ");
			xx = sc.next();
			numMatch++;
			System.out.println("Card Remains: " + remainingCards);
		}while(numMatch < 26);

		String result = "";
		if(enemyScore > yourScore){
			result = "Enemy is the Winner";
		}else{
			result = "You Win";
		}
		System.out.println("You: " + yourScore);
		System.out.println("Enemy: " + enemyScore);
		System.out.println(result);
	}
}