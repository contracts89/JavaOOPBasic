package problem5.models;

import problem5.exceptions.InvalidArtistNameException;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class Artist {
    private String name;

    public Artist(String name) throws InvalidArtistNameException {
        this.setName(name);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) throws InvalidArtistNameException {
        if(name.length() < 3 || name.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.name = name;
    }
}
