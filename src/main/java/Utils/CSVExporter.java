package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.Cast;
import models.Crew;
import models.Genres;
import models.Movie;

public class CSVExporter {


    public static void exportMovieData(String fileName, Movie movie, Cast[] cast) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Title,Release Date,Language,Actors,Genres,Runtime,Overview,Vote Average\n");
            writer.append(formatCSVEntry(movie.getTitle()) + ",");
            writer.append(formatCSVEntry(movie.getRelease_date()) + ",");
            writer.append(formatCSVEntry(movie.getOriginal_language()) + ",");
            writer.append(formatCSVEntry(getActors(cast)) + ",");
            writer.append(formatCSVEntry(getGenres(movie)) + ",");
            writer.append(movie.getRuntime() + ",");
            writer.append(formatCSVEntry(movie.getOverview()) + ",");
            writer.append(movie.getVote_average() + "\n");
        }
    }

    private static String formatCSVEntry(String entry) {
        return "\"" + entry.replace("\"", "\"\"") + "\"";
    }

    private static String getGenres(Movie movie) {
        StringBuilder genresString = new StringBuilder();
        for (Genres genre : movie.getGenres()) {
            genresString.append(genre.getName()).append(", ");
        }
        if (genresString.length() > 0) {
            genresString.setLength(genresString.length() - 2); // Remove the trailing comma and space
        }
        return genresString.toString();
    }

    private static String getActors(Cast[] cast) {
        StringBuilder actorsString = new StringBuilder();
        for (Cast actor : cast) {
            actorsString.append(actor.getName()).append(", ");
        }
        if (actorsString.length() > 0) {
            actorsString.setLength(actorsString.length() - 2); // Remove the trailing comma and space
        }
        return actorsString.toString();
    }
}
