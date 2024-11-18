package com.example.grupo1musictool.dtos;

public class ContarSongsDTO {
    public String genre;
    public int totalSongs;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalSongs() {
        return totalSongs;
    }

    public void setTotalSongs(int totalSongs) {
        this.totalSongs = totalSongs;
    }
}
