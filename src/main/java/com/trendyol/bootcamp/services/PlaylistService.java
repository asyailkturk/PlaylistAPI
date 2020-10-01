package com.trendyol.bootcamp.services;

import com.trendyol.bootcamp.models.Playlist;
import com.trendyol.bootcamp.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlaylistService {
    private final PlaylistRepository playlistRepository;

   public PlaylistService(PlaylistRepository playlistRepository){
       this.playlistRepository=playlistRepository;
   }

    public String createPlaylist(Playlist playlist) {
        return playlistRepository.createPlaylist(playlist);
    }
    public void updatePlaylist (Playlist playlist) {
       playlistRepository.updatePlaylist(playlist);
    }
    public void deletePlaylist(String id) {
        playlistRepository.deletePlaylist(id);
    }

    public Playlist findById(String id) {
        return playlistRepository.findById(id);
    }

    public List<Playlist> findAllByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }




}
