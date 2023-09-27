package ra.service;

import ra.model.Song;

public class SongService {
    private Song[] arrSong = new Song[100];
    private int songCount = 0;

    public Song[] findAll(){
        return arrSong;
    }

    public void addNewSong(Song song){
        arrSong[songCount] = song;
        songCount++;
    }

    public int getSongCount() {
        return songCount;
    }

    public boolean editById (String id){
        int indexEdit = -1;
        for (int i = 0; i < songCount; i++) {
            if(arrSong[i].getSongId().equals(id)){
                indexEdit= i;
                break;
            }
        }
        if (indexEdit == -1) {
            return false;
        }
        arrSong[indexEdit].inputData();
        return true;
    }

    public boolean deleteById (String id){
        int indexDelete = -1;
        for (int i = 0; i < songCount; i++) {
            if(arrSong[i].getSongId().equals(id)){
                indexDelete= i;
                break;
            }
        }
        if (indexDelete == -1) {
            return false;
        }
        for (int i = indexDelete; i < songCount-1; i++) {
            arrSong[i] = arrSong[i+1];
        }
        arrSong[songCount-1] = null;
        songCount--;
        return true;
    }
}
