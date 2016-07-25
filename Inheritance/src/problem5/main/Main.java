package problem5.main;

import problem5.exceptions.InvalidArtistNameException;
import problem5.exceptions.InvalidSongException;
import problem5.exceptions.InvalidSongLengthException;
import problem5.models.Artist;
import problem5.models.Length;
import problem5.models.OnlineRadioDatabase;
import problem5.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Radoslav on 21.7.2016 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(sc.readLine());
        OnlineRadioDatabase onlineRadioDatabase = new OnlineRadioDatabase();
        for (int i = 0; i <number; i++) {
            String[] input = sc.readLine().split(";");
            String artistName = input[0];
            String songName = input[1];
            int[] songLength = Arrays.stream(input[2].split(":")).mapToInt(Integer::parseInt).toArray();
            int songMinutes = songLength[0];
            int songSeconds = songLength[1];
            Artist artist = null;
            Length length = null;
            Song song = null;
            try{
                artist = new Artist(artistName);
            }catch (InvalidArtistNameException inex){
                System.out.println(inex.getMessage());
            }
            try{
                length = new Length(songMinutes, songSeconds);
            }catch (InvalidSongLengthException islex){
                System.out.println(islex.getMessage());
                continue;
            }

            try{
                song = new Song(artist, songName, length);
            }catch (InvalidSongException ise){
                System.out.println(ise.getMessage());
            }
            onlineRadioDatabase.addSongsToPlaylist(song);
        }

        onlineRadioDatabase.calcPlaylistLenght();
    }
}
