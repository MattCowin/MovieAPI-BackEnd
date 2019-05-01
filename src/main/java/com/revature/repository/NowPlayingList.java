package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.NowPlaying;

public class NowPlayingList {

		private List<NowPlaying> nowPlaying;
		
		public NowPlayingList() {
			nowPlaying = new ArrayList<>();
		}

		public NowPlayingList(List<NowPlaying> nowPlaying) {
			super();
			this.nowPlaying = nowPlaying;
		}

		public List<NowPlaying> getNowPlaying() {
			return nowPlaying;
		}

		public void setNowPlaying(List<NowPlaying> nowPlaying) {
			this.nowPlaying = nowPlaying;
		}
		
		
}
