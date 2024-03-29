import java.awt.*;
import java.util.InputMismatchException;
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
            } else if (menuChoice == 5) {
                editMovie();
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
        controller.addMovie(title, director, yearCreated, (int) lengthInMinutes, isInColor, genre);

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
        System.out.println("5: to edit a movie in your collection");
        try{
            menuChoice = scanner.nextInt();
        } catch (InputMismatchException ime){
            System.out.println("not working");
        }

    }

    public void editMovie() {

        System.out.println(controller.showMovieCollection());
        System.out.println("type the number of the movie you want to edit:");
        int movieNumber = scanner.nextInt();
        controller.printMovie(movieNumber - 1);
        Movie m = controller.getMovie(movieNumber - 1);
        System.out.println("Would you like to edit the title? blank for no edit");
        String titleEdit = scanner.next();
        if (!titleEdit.isBlank()) {
            m.setTitle(titleEdit);
        } else {
            titleEdit = m.getTitle();
        }
        System.out.println("Would you like to edit the director? blank for no edit");
        String directorEdit = scanner.next();
        if (!directorEdit.isBlank()) {
            m.setDirector(directorEdit);
        } else {
            directorEdit = m.getDirector();
        }

        System.out.println("Would you like to edit the year? 0 for no edit");
        int yearEdit = scanner.nextInt();
        if (yearEdit != 0) {
            m.setYear(yearEdit);
        } else {
            yearEdit = m.getYearCreated();
        }


        System.out.println("Would you like to edit the color? true/false for no edit");
        boolean colorEdit = scanner.nextBoolean();
        if (colorEdit != m.isInColor()) {
            m.setColor(colorEdit);
        }

        System.out.println("Would you like to edit the length in minutes? 0 for no edit");
        int lengthEdit = scanner.nextInt();
        if (lengthEdit != 0) {
            m.setLengthInMinutes(lengthEdit);
        } else {
            lengthEdit = (int) m.getLengthInMinutes();
        }

        System.out.println("Would you like to edit the genre? blank for no edit");
        String genreEdit = scanner.next();
        if (!genreEdit.isBlank()) {
            m.setGenre(genreEdit);
        } else {
            genreEdit = m.getGenre();
        }
        controller.editMovie(movieNumber, titleEdit, directorEdit, yearEdit, colorEdit, lengthEdit, genreEdit);
        myMenuText();

    }
}


