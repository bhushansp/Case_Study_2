package com.te.jdbcmultiplayer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MediaPlayer mediaPlayer = new MediaPlayer();
		int count = 0;
		do {
			System.out.println("Enter 'playlist' to see the Playlist");
			System.out.println("Enter 'play' to play Your song from play list");
			System.out.println("Enter 'add'  to add the song");
			System.out.println("Enter 'delete' to delete the song");
			System.out.println("Enter 'search' to search the song");
			System.out.println("Enter 'update' to update the song name");
			System.out.println("Enter 'singer' to searchBySingerName");
			System.out.println("Enter 'exit' to exit the application");
			String selector = scanner.next();
			switch (selector) {
			case "play": {
				mediaPlayer.playList();
				if (!mediaPlayer.play()) {
					System.out.println("No Result");
				}
				break;
			}
			case "playlist": {
				mediaPlayer.playList();
				break;
			}
			case "add": {
				mediaPlayer.add();
				break;
			}
			case "delete": {
				mediaPlayer.delete();
				break;

			}
			case "search": {

				if (!mediaPlayer.search()) {
					System.out.println("No result");
				}
				break;
			}
			case "update": {
				mediaPlayer.update();
				break;
			}

			case "singer": {

				if (!mediaPlayer.searchBySingerName()) {
					System.out.println("No result");
				}
				break;
			}
			case "exit": {
				count++;
				break;
			}
			}

		} while (count == 0);

	}

}
