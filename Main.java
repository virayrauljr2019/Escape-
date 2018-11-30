import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int moves = 30;
    public static String output = "\n You find yourself in a large foyer. There is a door to the north. \nIn the room there is a chest on the floor, and a large candle in your hand that is unlit. \nif you don't get out in 30 turns you will die and lose";
    public static boolean inFoyer = true;
    public static boolean inLibrary = false;
    public static boolean inConservatory = false;
    //1st room
    public static boolean doorLocked1 = true;
    public static boolean doorOpen1 = false;
    public static boolean chestOpen = false;
    public static boolean hasMatches = false;
    public static boolean litcandle = false;
    //2nd room
    public static boolean seeshelf= false;
    public static boolean gotscroll= false;
    public static boolean getPen = false;
    public static boolean writeBook = false;
    public static boolean doorLocked2 = true;
    public static boolean doorOpen2 = false;
    //3rd room
    public static boolean playTrumpet = false;
    public static boolean playPiano = false;
    public static boolean playDrum = false;
    public static boolean doorlocked3= true;
    public static boolean door3open= false;

    public static boolean win= false;

    public static void main(String[] args) {

        System.out.printf("Welcome to Escape Room. You will need to use certain words to progess through the game.");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            moves--;
            if (win) {
                break;
            }
        }
        if (win) {
            System.out.printf("Congratulations! You have completed the escape room challenge successfully in with %d moves to spare.", moves);
        } else {
            System.out.printf("You have failed to escape the room, the posions enters the room killing you. \nGAME OVER");
        }
    }

    public static void gameUsage() {
        if (inFoyer) {
            foyer();
        } else if (inLibrary) {
            library();
        } else if (inConservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("%s You have %d moves left. The posion is coming....\n", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There is a note on the bench. You should read it";
                break;

            case "look chest":
                output = "the chest is closed.";
                break;


            case "read note":
                output = "May the light show you the way.";
                break;


            case "open chest":
                chestOpen = true;
                output = "There are matches in the chest.";
                break;

            case "get matches":
                if (chestOpen) {
                    hasMatches = true;
                    output = "You have a box of matches.";
                }else {
                    output = "there is nothing to get";
                }
                break;

            case "light candle":
                if (hasMatches) {
                    litcandle = true;
                    doorLocked1 = false;
                    output = "The candle is lit. You heard a door lock opening from the door in the north.";
                } else {
                    output = "You don't have any matches.";
                }
                break;

            case "open door":
                if (litcandle) {
                    doorOpen1 = true;
                    output = "The north door is open.";
                }else{ output= "you can't see the door ";}
                break;

            case "go north":
                if (doorOpen1) {
                    inFoyer = false;
                    inLibrary = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are now in the library and cannot return to the foyer. In the library you see something on the shelf. There is another locked door to the north.";
                }
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left. The posion is coming....\n", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test){

            case "look shelf": {
                seeshelf = true;
                output = "You see a book a pen and a scroll";
            }
            break;

            case "look shelves":{
                seeshelf=true;
                output= "you see a book a pen and a scroll";
                break;
            }

            case "look scroll":
                if (seeshelf) {
                    output = "you got the scroll";
                    gotscroll=true;
                }else{ output= "you cannot see anything on the shelf";
                }
                break;

            case "look book":
                if (seeshelf) {
                    output = "There is a book titled 'The Autobiography of ...' with the rest of the title empty.";
                }else{
                    output= "you cannot see anything on the shelf";
                }

                break;

            case "look pen:":
                if (!getPen) {
                    output = "you see the pen. But you did not pick it up";
                }else{
                    output="you have the pen in your hand.";
                }
                break;

            case "get pen":
                getPen = true;
                output = "You have acquired the pen.";
                break;

            case "read scroll":
                if (gotscroll) {
                    output = "the scroll says, 'Share your story.'";
                }else{ output = "you don't have the scroll.";}
                break;

            case "write book":
            case "write name":
                writeBook = true;
                doorLocked2 = false;
                output = "You have completed the autobiography You heard a metal grinding sound from the north.";
                break;

            case "look door":
                if (!doorLocked2) {
                    if (doorOpen2) {
                        output = "The door is unlocked and open. Why not go through?";
                    } else {
                        output = "The door is unlocked, but closed. OPEN IT!";
                    }
                } else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!doorLocked2) {
                    doorOpen2 = true;
                    output = "The north door is open.";
                }
                break;

            case "go north":
                if (doorOpen2) {
                    inLibrary = false;
                    inConservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
                }
                break;

            default:
                output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
        }
    }

    public static void conservatory() {
        System.out.printf("%s You have %d moves left. the posion is coming....\n", output, moves);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {
            case "read music":
                output = "\nFirst is the blowing instrument.\n2nd is the instrument were you play keys, \nfinally the last instrument is the most easiest one to play.";
                break;

            case "play trumpet": {
                playTrumpet = true;
                output = "*trumpet noise*";
            }
                break;

            case "play piano":


                if (playTrumpet && !playPiano) {
                    playPiano = true;
                    output = "*piano noise*";
                }else{
                    playPiano= false;
                    playTrumpet= false;
                    output = "you are not playing it right try again.";
                }
                break;


            case "play drum":
                if (playTrumpet && playPiano) {
                    playDrum = true;
                    doorlocked3=false;

                    output = "*drum noise*\n you hear a click from the door from the North";
                } else {
                    output = "you are not playing it right try again.";
                    playPiano=false;
                    playTrumpet=false;
                }
                break;

            case "open door":

                if (!doorlocked3){
                    door3open=true;
                    output= "The last door is open. Get out now before the posion kills you!";

                }
                break;
            case "go north":
                if (door3open){
                    win= true;
                }
                break;


            default:
                output = "In the conservatory there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";

        }
    }
}