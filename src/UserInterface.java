import java.awt.*;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    Controller controller = new Controller();
    int menuChoice = 0;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
    }


    public void startProgram() {
        int sentinel = 2;


        myMenuText();

        while (menuChoice != sentinel) {
            if (menuChoice == 1) {
                CreateMovie();
            } else if (menuChoice == 3) {
                printMovieCollections();
            } else if (menuChoice == 4) {
                searchInMovieCollections();
            } else if (menuChoice > 1) {
                myMenuText();
            }
        }

    }

    public void CreateMovie() {
        System.out.println("input movie title");
        String title = scanner.next();

        System.out.println("input director");
        String director = scanner.next();

        System.out.println("input year of movie");
        int yearCreated = scanner.nextInt();


        System.out.println("input lenght of movie");
        double lengthInMinutes = scanner.nextDouble();


        System.out.println("is the movie in color?, write yes or else write no");

        boolean isInColor = false;
        if (scanner.next().equalsIgnoreCase("yes")) {
            isInColor = true;
            //}else{
            //    if(scanner.next().toLowerCase().equals("no"))
            //    }
        }



        System.out.println("input genre of movie");
        String genre = scanner.next();
        controller.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);

        myMenuText();


    }

    public void printMovieCollections() {
        System.out.println("\n din film collection");
        System.out.println(controller.showMovieCollection());

        myMenuText();

    }

    public void searchInMovieCollections() {
        System.out.println("write name of movie you are looking for");
        String userSearchWord = scanner.next();
        System.out.println(controller.showSearch(userSearchWord));

        myMenuText();

    }

    public void myMenuText() {
        System.out.println("***** Menu *****");
        System.out.println("1. add a new movie");
        System.out.println("2: to end program");
        System.out.println("3: to print out your movie collections");
        System.out.println("4: to search in your movie collection");
        menuChoice = scanner.nextInt();
    }


}
