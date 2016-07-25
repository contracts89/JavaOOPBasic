package problem5.exceptions;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException(String message) {
        super(message);
    }
}
