package com.trendyol.bootcamp.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.bootcamp.models.Playlist;
import com.trendyol.bootcamp.models.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

        private final Cluster couchbaseCluster;
        private final Collection playlistCollection;

        public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
                this.couchbaseCluster = couchbaseCluster;
                this.playlistCollection = playlistCollection;
        }

        public  String createPlaylist(Playlist playlist) {
                playlistCollection.insert(playlist.getId(), playlist);
                return playlist.getId();
        }

        public void updatePlaylist(Playlist playList) {
                playlistCollection.replace(playList.getId(), playList);
        }


        public void deletePlaylist(String id){
                playlistCollection.remove(id);
        }

        public Playlist findById(String id) {
                GetResult getResult = playlistCollection.get(id);
                return getResult.contentAs(Playlist.class);
        }

        public List<Playlist> findAllByUserId (String userId) {
                String statement = String.format("Select id, name, tracks from playlist where userId = '%s'", userId);
                QueryResult query = couchbaseCluster.query(statement);
                return query.rowsAs(Playlist.class);
        }

        public void addTrack(String id, Track track){
                GetResult getResult = playlistCollection.get(id);
                Playlist playlist = getResult.contentAs(Playlist.class);
                playlist.addTrack(track);
                playlist.setTrackCount(playlist.getTrackCount() + 1);
        }


        public void removeTrackFromPlaylist(String id, String trackId){
                GetResult getResult = playlistCollection.get(id);
                Playlist playlist = getResult.contentAs(Playlist.class);
                playlist.deleteTrack(trackId);
                playlist.setTrackCount(playlist.getTrackCount() - 1);

        }



}


