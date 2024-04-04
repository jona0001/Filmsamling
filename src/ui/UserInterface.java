package ui;
import domain.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInterface {
    private Scanner scanner;
    private Controller controller;
    private int menuChoice = 0;

    public UserInterface() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        controller = new Controller();
    }

    public void startPrograms() {
        int sentinel = 9;

        while (menuChoice != sentinel) {
            myMenuText();
            switch (menuChoice) {
                case 1 ->
                    createMovie();
                case 2 ->
                    printMovieCollection();
                case 3 ->
                    searchInMovieCollections();
                case 4 ->
                    editMovie();
                case 5 ->
                    deleteMovie();
            }
        }
    }

    public void createMovie() {
        System.out.println("input movie title");
        String title = scanner.next();

        System.out.println("input director");
        String director = scanner.next();

        System.out.println("input yearCreated of movie");
        boolean isDoneWithYear = false;
        int yearCreated = 0;
        while (!isDoneWithYear){
            try {
                yearCreated = scanner.nextInt();
                isDoneWithYear = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter year as a number: ");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        System.out.println("input length of movie");
        boolean isDoneWithLength = false;
        int lengthInMinutes = 0;
        while(!isDoneWithLength) {
            try {
                lengthInMinutes = scanner.nextInt();
                isDoneWithLength = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter length in minutes as a number:");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

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
        boolean isAdded = controller.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);
        if(isAdded){
            System.out.printf("The movie \" %s \" is added to the collection\n", title);

            System.out.printf("There is now %d movies in the collection\n", controller.getMovieCollection().size());
        }

    }

    public void printMovieCollection() {
        System.out.println("Your movie collection:");
        for (int i = 0; i < controller.showMovieCollection().size(); i++){
            System.out.printf("%d. ", i);
            System.out.println(controller.showMovieCollection().get(i));
        }
    }

    public void searchInMovieCollections() {
        System.out.println("write name of movie you are looking for");
        String userSearchWord = scanner.next();
        System.out.println(controller.showSearch(userSearchWord));
    }


    public void myMenuText() {
        System.out.println("***** Menu *****");
        System.out.println("1. add a new movie");
        System.out.println("2: to print out your movie collections");
        System.out.println("3: to search in your movie collection");
        System.out.println("4: to edit a movie in your collection");
        System.out.println("5: to delete a movie in your collection");
        System.out.println("9: to end program");
        System.out.println("*****************");
        try {
            menuChoice = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("not working, try again");
        }

    }

    public void editMovie() {
        printMovieCollection();
        System.out.println("Type the number of the movie you want to edit:");
        int movieNumber = scanner.nextInt();
        Movie movieToEdit = controller.findOneMovieByIndex(movieNumber);
        System.out.println(movieToEdit);
        System.out.println("Would you like to edit the title? blank for no edit");
        String titleEdit = scanner.next();
        if (!titleEdit.isBlank()) {
            movieToEdit.setTitle(titleEdit);
        } else {
            titleEdit = movieToEdit.getTitle();
        }
        System.out.println("Would you like to edit the director? blank for no edit");
        String directorEdit = scanner.next();
        if (!directorEdit.isBlank()) {
            movieToEdit.setDirector(directorEdit);
        } else {
            directorEdit = movieToEdit.getDirector();
        }

        System.out.println("Would you like to edit the year? 0 for no edit");
        int yearEdit = scanner.nextInt();
        if (yearEdit != 0) {
            movieToEdit.setYear(yearEdit);
        } else {
            yearEdit = movieToEdit.getYearCreated();
        }


        System.out.println("Would you like to edit the color? true/false for no edit");
        boolean colorEdit = scanner.nextBoolean();
        if (colorEdit != movieToEdit.isInColor()) {
            movieToEdit.setColor(colorEdit);
        }

        System.out.println("Would you like to edit the length in minutes? 0 for no edit");
        int lengthEdit = scanner.nextInt();
        if (lengthEdit != 0) {
            movieToEdit.setLengthInMinutes(lengthEdit);
        } else {
            lengthEdit = (int) movieToEdit.getLengthInMinutes();
        }

        System.out.println("Would you like to edit the genre? blank for no edit");
        String genreEdit = scanner.next();
        if (!genreEdit.isBlank()) {
            movieToEdit.setGenre(genreEdit);
        } else {
            genreEdit = movieToEdit.getGenre();
        }
        controller.editMovie(movieNumber, titleEdit, directorEdit, yearEdit, colorEdit, lengthEdit, genreEdit);
    }

    public void deleteMovie() {
        System.out.println("Insert title of a movie to delete: ");
        String title = scanner.next();
        boolean isDeleted = controller.deleteMovie(title);
        if(isDeleted){
            System.out.printf("Movie \" %s \" was successfully deleted\n", title);
        }else{
            System.out.printf("Movie with title \" %s \" does not exist\n", title);
        }
    }
}


