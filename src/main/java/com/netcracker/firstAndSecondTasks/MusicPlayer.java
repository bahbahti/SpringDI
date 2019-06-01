package com.netcracker.firstAndSecondTasks;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MusicPlayer {

    private Music music;
    private int volume;
    private List<Music> musicList;
    private Set<Music> musicSet;
    private Map<Integer, Music> musicMap;

    public MusicPlayer() {}
    //IoC
    public MusicPlayer(Music music, int volume){
        this.music = music;
        this.volume = volume;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public MusicPlayer(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }

    public MusicPlayer(Map<Integer, Music> musicMap) {
        this.musicMap = musicMap;
    }

    public MusicPlayer(List<Music> musicList, Set<Music> musicSet, Map<Integer, Music> musicMap) {
        this.musicList = musicList;
        this.musicSet = musicSet;
        this.musicMap = musicMap;
    }


    public void setMusic(Music music) {
        this.music = music;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void setMusicSet(Set<Music> musicSet) {
        this.musicSet = musicSet;
    }

    public void setMusicMap(Map<Integer, Music> musicMap) {
        this.musicMap = musicMap;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public void playMusicList() {
        for(Music music : musicList) {
            System.out.println(music.getSong());
        }
    }

    public void playMusicSet() {
        for (Music music : musicSet) {
            System.out.println(music.getSong());
        }
    }

    public void playMusicMap() {
        for (Map.Entry<Integer, Music> entry : musicMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue().getSong());
        }
    }
}
