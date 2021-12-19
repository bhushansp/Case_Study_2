package com.te.jdbcmultiplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MediaPlayer implements Media {
	String url = "jdbc:mysql://localhost:3306/jdbcdemo";
	Scanner scanner = new Scanner(System.in);

	@Override
	public void playList() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.createStatement();
			ResultSet queryResult = statement.executeQuery("select * from playlist");
			System.out.println("Song Name\tSinger Name");
			while (queryResult.next()) {

				System.out.print(queryResult.getString(1) + " \t");
				System.out.println(queryResult.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean play() {
		boolean result = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement("select Song_Name from playlist where song_name=?");

			System.out.println("Enter the Song_name");
			String songName = scanner.next();
			statement.setString(1, songName);
			ResultSet queryResult = statement.executeQuery();

			while (queryResult.next()) {
				System.out.println(queryResult.getString(1) + "  is playing...");
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	@Override
	public void add() {

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement("insert into playlist values(?,?)");

			System.out.println("Enter the Song_name");
			String songName = scanner.next();
			System.out.println("Enter the Singer_name ");
			String singerName = scanner.next();
			statement.setString(1, songName);
			statement.setString(2, singerName);

			statement.executeUpdate();
			System.out.println("Song added successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean search() {
		boolean result = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement("select Song_Name from playlist where song_name=?");

			System.out.println("Enter the Song_name");
			String songName = scanner.next();
			statement.setString(1, songName);
			ResultSet queryResult = statement.executeQuery();

			while (queryResult.next()) {
				System.out.println("Here is your song ->" + queryResult.getString(1));
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	@Override
	public void update() {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement(" update playlist set song_name=? where song_name=? ");

			System.out.println("Enter the Song name you want to change");
			String songName = scanner.next();
			statement.setString(2, songName);
			System.out.println("Enter the new Song_name ");
			String newsongName = scanner.next();
			statement.setString(1, newsongName);
			statement.executeUpdate();
			System.out.println("Song updated successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("The updated playlist is");
		playList();
	}

	@Override
	public void delete() {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement(" delete from playlist where Song_Name=?");

			System.out.println("Enter the Song_name");
			String songName = scanner.next();
			statement.setString(1, songName);
			statement.executeUpdate();
			System.out.println("Song deleted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public boolean searchBySingerName() {
		boolean result = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			statement = connection.prepareStatement("select Song_Name from playlist where Singer_name=?");

			System.out.println("Enter the Singer_name");
			String singerName = scanner.next();
			statement.setString(1, singerName);
			ResultSet queryResult = statement.executeQuery();

			while (queryResult.next()) {
				System.out.println(queryResult.getString(1));
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;

	}

}
