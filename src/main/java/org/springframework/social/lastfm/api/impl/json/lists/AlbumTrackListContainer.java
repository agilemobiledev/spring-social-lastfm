/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.lastfm.api.impl.json.lists;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.social.lastfm.api.Album;
import org.springframework.social.lastfm.api.AlbumTrack;
import org.springframework.social.lastfm.api.Artist;
import org.springframework.social.lastfm.api.Track;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Container for a track list - allows for automatic JSON binding from *either* a list of Tracks
 * or a Map representation of a single track, as LastFm's responds with different Json structures
 * depending on whether a single track is returned
 * 
 * @author Michael Lavelle
 */
public class AlbumTrackListContainer extends AbstractLastFmListContainer<AlbumTrack> {

	public AlbumTrackListContainer(String url, String name, String musicBrainsId,
			Artist artist,Album album) {
		super(new AlbumTrack(url, name, musicBrainsId, artist,album));
	}

	@JsonCreator
	public AlbumTrackListContainer(List<AlbumTrack> tracks) {
		super(tracks);

	}

	public List<AlbumTrack> getTracks() {
		return elements;
	}

}
