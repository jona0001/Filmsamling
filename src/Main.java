import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // film obejct
        MovieCollection film = new MovieCollection();

        System.out.println("add Movie title");
        String title  = scanner.nextLine();

        System.out.println("add director");
        String director = scanner.nextLine();

        System.out.println("add year movie Is created");
        int yearCreated = scanner.nextInt();

        System.out.println("add length in minutes");
        double lengthInMinutes = scanner.nextDouble();

        System.out.println("is the movie in color?" + " " + "true or false");
        boolean isInColor = scanner.nextBoolean();

        System.out.println("what genre is it?");
        String genre = scanner.next();

        //
        film.getFilmListe(title, director, yearCreated, lengthInMinutes, isInColor, genre);

        for(Movie movie : film.getFilmListe ()){
            if (movie != null){


            }
        }















    }
}
