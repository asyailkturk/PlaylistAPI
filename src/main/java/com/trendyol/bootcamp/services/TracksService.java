package com.trendyol.bootcamp.services;

import com.trendyol.bootcamp.models.Playlist;
import com.trendyol.bootcamp.models.Track;
import com.trendyol.bootcamp.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TracksService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public TracksService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public String addTrack(String id, Track track) {
        playlistRepository.addTrack(id,track);
        return track.getTrackId();
    }

    public void removeTrackFromPlaylist(String id,String trackId){
        playlistRepository.removeTrackFromPlaylist(id ,trackId);
    }
}
