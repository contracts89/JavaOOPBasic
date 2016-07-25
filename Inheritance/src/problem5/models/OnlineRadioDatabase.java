package problem5.models;

import java.util.ArrayList;

/**
 * Created by Radoslav on 20.7.2016 г..
 */
public class OnlineRadioDatabase {
    private ArrayList<Song> playlist;
    private int counter;

    public OnlineRadioDatabase() {
        this.setPlaylist(new ArrayList<>());
        this.setCounter(counter);
    }

    private ArrayList<Song> getPlaylist() {
        return playlist;
    }

    private void setPlaylist(ArrayList<Song> playlist) {
        this.playlist = playlist;
    }

    private void setCounter(int counter) {
        this.counter = counter;
    }

    private int getCounter() {
        return counter;
    }

    public void addSongsToPlaylist(Song song){
        this.getPlaylist().add(song);
        System.out.println("Song added.");
        this.setCounter(this.getCounter() + 1);
    }

    public void calcPlaylistLenght(){
        int seconds = 0;

        for (Song song : this.getPlaylist()) {
            seconds += song.getLength().getMinutes() * 60;
            seconds += song.getLength().getSeconds();
        }

        int hours = seconds / 3600;
        int minutes = (seconds / 60) % 60;
        int secondsRemainder = seconds % 60;

        if(minutes == 60){
            minutes = 0;
        }
        if(secondsRemainder == 60){
            secondsRemainder = 0;
        }

        System.out.println("Songs added: " + this.getCounter());
        System.out.printf("Playlist length: %dh %dm %ds\n", hours, minutes, secondsRemainder);
    }


}
