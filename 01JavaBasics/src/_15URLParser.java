/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.3.2018 г.
 * Time: 18:09 ч.
 */

import java.util.Scanner;

public class _15URLParser {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();


        String protocol;
        String server;
        String resource;

        if (input.contains("://")) {
            String[] protocolServer = input.split("://");

            protocol = protocolServer[0];

            if (protocolServer[1].contains("/")) {
                String[] serverResource = protocolServer[1].split("/", 2);

                server = serverResource[0];
                resource = serverResource[1];
            } else {
                server = protocolServer[1];
                resource = "";
            }

        } else {
            protocol = "";
            server = input;
            resource = "";
        }

        System.out.printf("[protocol] = \"%s\"%n", protocol);
        System.out.printf("[server] = \"%s\"%n", server);
        System.out.printf("[resource] = \"%s\"%n", resource);
    }
}