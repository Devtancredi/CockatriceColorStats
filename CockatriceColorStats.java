import java.io.File;
import java.util.Arrays;


public class CockatriceColorStats {

	private static int white = 0, blue = 0, black = 0, red = 0, green = 0, colorless = 0;

	//All Possible Decks
	private static String[] allColors = {"white","blue","black","red","green","azorius","boros","dimir","golgari","gruul",
	"izzet","orzhov","rakdos","selesnya","simic","abzan","bant","esper","grixis","jeskai","jund",
	"mardu","naya","sultai","temur","glint","dune","ink","witch","yore","wubrg","colorless"};

	private static String[][] colors = {
	//White
	{"white","azorius","boros","orzhov","selesnya","abzan","bant","esper",
	"jeskai","mardu","naya","dune","ink","witch","yore","wubrg"},
	//Blue
	{"blue","azorius","dimir","izzet","simic","bant","esper","grixis",
	"jeskai","sultai","temur","glint","ink","witch","yore","wubrg"},
	//Black
	{"black","dimir","golgari","orzhov","rakdos","abzan","esper",
	"grixis","jund","mardu","sultai","glint","dune","witch","yore","wubrg"},
	//Red
	{"red","boros","gruul","izzet","rakdos","grixis","jeskai","jund","mardu",
	"naya","temur","glint","dune","ink","yore","wubrg"},
	//Green
	{"green","golgari","gruul","selesnya","simic","abzan","bant","jund",
	"naya","sultai","temur","glint","dune","ink","witch","wubrg"},
	//Colorless
	{"colorless"}
	};	
	
	//Will increase the count for each color depending on how many decks containing that color identity are found in the directory
	private static void increaseColorAmount(String deckColors, int fileCount) {
		for (int x = 0; x <= 5; x++) {
		boolean contains = Arrays.stream(colors[x]).anyMatch(deckColors::equals);
			if (contains) {
				switch(x) {
					case 0:
						white+=fileCount;
						break;
					case 1:
						blue+=fileCount;
						break;
					case 2:
						black+=fileCount;
						break;
					case 3:
						red+=fileCount;
						break;
					case 4:
						green+=fileCount;
						break;
					case 5:
						colorless+=fileCount;
						break;
				}
			}
		}
	}

	public static void getDeckAmount() {
		//Check the directory of every color and color combination
		for(int x = 0; x < allColors.length; x++) {
			File directory = new File("./decks/" + allColors[x]);
			int fileCount = 0;
			if (directory.list() != null) {
				fileCount = directory.list().length;
			}
			increaseColorAmount(allColors[x], fileCount);
		}
	}

	public static void printColorStats() {
		System.out.println("DECK IDENTITY STATISTICS:");
		System.out.println("Decks containing white: " + white);
		System.out.println("Decks containing blue: " + blue);
		System.out.println("Decks containing black: " + black);
		System.out.println("Decks containing red: " + red);
		System.out.println("Decks containing green: " + green);
		System.out.println("Decks that are Colorless: " + colorless);
	}

	public static void main(String[] args) {
		CockatriceColorStats.getDeckAmount();
		CockatriceColorStats.printColorStats();
	}
}
