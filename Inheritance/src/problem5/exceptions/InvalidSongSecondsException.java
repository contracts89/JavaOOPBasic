package problem5.exceptions;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
