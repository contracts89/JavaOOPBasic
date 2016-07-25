package problem5.models;

import problem5.exceptions.InvalidSongMinutesException;
import problem5.exceptions.InvalidSongSecondsException;

/**
 * Created by Radoslav on 21.7.2016 г..
 */
public class Length {
    private int seconds;
    private int minutes;

    public Length(int minutes, int seconds) throws InvalidSongMinutesException, InvalidSongSecondsException {
        this.setSeconds(seconds);
        this.setMinutes(minutes);
    }

    int getSeconds() {
        return seconds;
    }

    void setSeconds(int seconds) throws InvalidSongSecondsException {
        if(seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    int getMinutes() {
        return minutes;
    }

    void setMinutes(int minutes) throws InvalidSongMinutesException {
        if(minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }
}
