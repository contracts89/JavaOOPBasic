package problem5.exceptions;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
