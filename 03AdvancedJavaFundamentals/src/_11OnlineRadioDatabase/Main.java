package _11OnlineRadioDatabase;/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.3.2018 г.
 * Time: 20:56 ч.
 */

import _11OnlineRadioDatabase.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int songsCount = Integer.parseInt(reader.readLine());

        int songsAdded = 0;

        SimpleDateFormat format = new SimpleDateFormat("H:m:s");
        Date startDuration = format.parse("0:0:0");
        Calendar playlistDuration = Calendar.getInstance();
        playlistDuration.setTime(startDuration);


        for (int i = 0; i < songsCount; i++) {

            try {
                String[] songArgs = reader
                        .readLine()
                        .split(";");
                if (songArgs.length != 3) {
                    throw new InvalidSongException();
                }

                String artistName = songArgs[0];
                if (artistName.length() < 3 || artistName.length() > 20) {
                    throw new InvalidArtistNameException();
                }

                String songName = songArgs[1];
                if (songName.length() < 3 || songName.length() > 30) {
                    throw new InvalidSongNameException();
                }

                String[] duration = songArgs[2].split(":");
                if (duration.length != 2) {
                    throw new InvalidSongLengthException();
                }

                int minutes;
                int seconds;
                try {
                    minutes = Integer.parseInt(duration[0]);
                    seconds = Integer.parseInt(duration[1]);
                } catch (Exception e) {
                    throw new InvalidSongLengthException();
                }

                if (minutes < 0 || minutes > 14) {
                    throw new InvalidSongMinutesException();
                }

                if (seconds < 0 || seconds > 59) {
                    throw new InvalidSongSecondsException();
                }

                System.out.println("Song added.");

                songsAdded++;
                playlistDuration.add(Calendar.SECOND, seconds);
                playlistDuration.add(Calendar.MINUTE, minutes);

            } catch (InvalidArtistNameException e) {
                System.out.println("Artist name should be between 3 and 20 symbols.");

            } catch (InvalidSongNameException e) {
                System.out.println("Song name should be between 3 and 30 symbols.");

            } catch (InvalidSongMinutesException e) {
                System.out.println("Song minutes should be between 0 and 14.");

            } catch (InvalidSongSecondsException e) {
                System.out.println("Song seconds should be between 0 and 59.");

            } catch (InvalidSongLengthException e) {
                System.out.println("Invalid song length.");

            } catch (InvalidSongException e) {
                System.out.println("Invalid song.");
            }
        }

        System.out.println("Songs added: " + songsAdded);

        int h = playlistDuration.get(Calendar.HOUR);
        int m = playlistDuration.get(Calendar.MINUTE);
        int s = playlistDuration.get(Calendar.SECOND);
        System.out.printf("Playlist length: %sh %sm %ss%n", h, m, s);
    }
}
