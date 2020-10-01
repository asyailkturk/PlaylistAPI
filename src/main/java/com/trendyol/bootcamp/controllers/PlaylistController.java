package com.trendyol.bootcamp.controllers;

import com.trendyol.bootcamp.models.Playlist;
import com.trendyol.bootcamp.services.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity createPlaylist(@RequestBody Playlist playlist) {
        URI uri = URI.create(String.format("/playlist/%s", playlist.getId()));
        String id = playlistService.createPlaylist(playlist);

        return ResponseEntity.created(uri).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable String id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> findAllByUserId(@RequestParam String userId ) {
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}