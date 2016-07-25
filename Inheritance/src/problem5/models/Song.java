package problem5.models;

import problem5.exceptions.InvalidSongException;
import problem5.exceptions.InvalidSongLengthException;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class Song {
    private Artist artist;
    private String name;
    private Length length;

    public Song(Artist artist, String name, Length length) throws InvalidSongException {
        this.artist = artist;
        this.setName(name);
        this.setLength(length);
    }

    Length getLength() {
        return length;
    }

    private void setLength(Length length) throws InvalidSongLengthException {
        if(length.getSeconds() < 0 || (length.getMinutes() > 14 && length.getSeconds() > 59)){
            throw new InvalidSongLengthException("Invalid song length.");
        }
        this.length = length;
    }

    private Artist getArtist() {
        return artist;
    }

    private void setArtist(Artist artist) {
        this.artist = artist;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) throws InvalidSongException {
        if(name.length() < 3 || name.length() > 30){
            throw new InvalidSongException("Invalid song.");
        }
        this.name = name;
    }

}
