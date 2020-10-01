package com.trendyol.bootcamp.controllers;

import com.trendyol.bootcamp.models.Track;
import com.trendyol.bootcamp.services.TracksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/playlist/{id}/tracks")
public class TracksController {

    TracksService tracksService;

    public TracksController(TracksService tracksService) {
        this.tracksService = tracksService;
    }

    @PostMapping
    public ResponseEntity<Void> addTrack(@PathVariable String id, @RequestBody Track track) {
        String trackId = tracksService.addTrack(id, track);
        URI uri = URI.create(String.format("/playlist/%s/tracks/%s", id, trackId));
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<Void> removeTrackFromPlaylist(@PathVariable String id, @PathVariable String trackId) {
        tracksService.removeTrackFromPlaylist(id,trackId);
        return ResponseEntity.noContent().build();
    }
}
