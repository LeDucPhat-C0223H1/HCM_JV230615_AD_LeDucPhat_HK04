package ra.service;

import ra.model.Singer;

public class SingerService {
    private Singer[] arrSinger = new Singer[100];
    private  int singerCount = 0;

    public Singer[] findAll(){
        return arrSinger;
    }

    public void addNewSinger(Singer singer){
        arrSinger[singerCount] = singer;
        singerCount++;
    }

    public int getSingerCount() {
        return singerCount;
    }

    public boolean editById (int id){
        int indexEdit = -1;
        for (int i = 0; i < singerCount; i++) {
            if(arrSinger[i].getSingerId()==id){
                indexEdit= i;
                break;
            }
        }
        if (indexEdit == -1) {
            return false;
        }
        arrSinger[indexEdit].inputData();
        return true;
    }


    public boolean deleteById (int id){
        int indexDelete = -1;
        for (int i = 0; i < singerCount; i++) {
            if(arrSinger[i].getSingerId()==id){
                indexDelete= i;
                break;
            }
        }
        if (indexDelete == -1) {
            return false;
        }
        for (int i = indexDelete; i < singerCount-1; i++) {
            arrSinger[i] = arrSinger[i+1];
        }
        arrSinger[singerCount-1] = null;
        singerCount--;
        return true;
    }

}
