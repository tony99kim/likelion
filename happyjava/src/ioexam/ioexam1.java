package ioexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ioexam1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.youtube.com/");
        InputStream in  = url.openStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);

        String msg = null;
    }

}
