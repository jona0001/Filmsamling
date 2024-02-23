import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // controller object
        Controller controller = new Controller();


        System.out.println("Welcome to my movieCollection!");
        System.out.println("1: to Create Movie");
        System.out.println("2: to end program");
        System.out.println("3: to print out your movie collections");
        System.out.println("4: to search in your movie collection");

        // int tilføjFilm =0;
        int sentinel = 2;
        int menuChoice = scanner.nextInt();
        scanner.nextLine();


        while (menuChoice != sentinel) {
            if (menuChoice == 1) {
                System.out.println("input movie title");
                String title = scanner.nextLine();


                System.out.println("input director");
                String director = scanner.nextLine();


                System.out.println("input year of movie");
                int yearCreated = scanner.nextInt();
                scanner.nextLine();


                System.out.println("input lenght of movie");
                double lengthInMinutes = scanner.nextDouble();
                scanner.nextLine();


                System.out.println("is the movie in color?, write yes or else write no");

                boolean isInColor = false;
                if (scanner.next().equalsIgnoreCase("yes")) {
                    isInColor = true;
                    //}else{
                    //    if(scanner.next().toLowerCase().equals("no"))
                    //    }
                }
                scanner.nextLine();

                System.out.println("input genre of movie");
                String genre = scanner.nextLine();
                controller.addMovie(title, director, yearCreated, lengthInMinutes, isInColor, genre);

                System.out.println("***** Menu *****");
                System.out.println("1. add a new movie");
                System.out.println("2: to end program");
                System.out.println("3: to print out your movie collections");
                System.out.println("4: to search in your movie collection");
                menuChoice = scanner.nextInt();
                scanner.nextLine();


            }else if (menuChoice == 3) {
                //user story 4

                System.out.println(controller.showMovieCollection());

                System.out.println("***** Menu *****");
                System.out.println("1. add a new movie");
                System.out.println("2: to end program");
                System.out.println("3: to print out your movie collections");
                System.out.println("4: to search in your movie collection");


                menuChoice = scanner.nextInt();
                scanner.nextLine();


            }else if (menuChoice == 4){


            }else if (menuChoice > 1){


                System.out.println("***** Menu *****");
                System.out.println("1. add a new movie");
                System.out.println("2: to end program");
                System.out.println("3: to print out your movie collections");
                System.out.println("4: to search in your movie collection");

                menuChoice = scanner.nextInt();
                scanner.nextLine();








            }





        }

























    }
}
