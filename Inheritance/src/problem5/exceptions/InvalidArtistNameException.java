package problem5.exceptions;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String message) {
        super(message);
    }
}
