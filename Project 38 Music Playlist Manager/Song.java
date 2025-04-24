public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration; // in seconds
    private String genre;

    public Song(String title, String artist, String album, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getFormattedDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) [%s] %s",
            title, artist, album, genre, getFormattedDuration());
    }
} 