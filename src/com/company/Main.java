package com.company;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.annotation.ElementType;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;


public abstract class Main {

    public static void main(String[] args) throws IOException {



        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        boolean isFoundHttp = url.contains("http://"); // true
        boolean isFoundHttps = url.contains("https://"); // true

        if (!isFoundHttp && !isFoundHttps) {
            url = "http://" + url;
        }

        try {
            Document document = Jsoup.connect(url).get().ownerDocument();
            Charset charset = document.charset();
            String html = Jsoup.connect(url).get().outerHtml();
            Writer out = new BufferedWriter( new OutputStreamWriter(new FileOutputStream("site.html"),charset));
            out.write(html);
            out.close();
            String text = document.text();
            String [] words = text.split(" ");
            System.out.println(Arrays.toString(words));




        } catch (IllegalArgumentException | UnknownHostException | MalformedURLException e) {
            System.err.println("Incorrect URL");
        } catch (HttpStatusException e){
            System.err.println("Error 404 page not found");
        }


//        Document document = Jsoup.connect(url).get().ownerDocument();
//        System.out.println(document.charset());


    }
}


//          Elements elements = document.select("text");


