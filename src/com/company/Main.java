package com.company;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.net.URI;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;


public abstract class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        boolean isFound = url.contains("http://"); // true
        if (isFound) {
            url = "http://" + url;
        }

        Document document = Jsoup.connect(url).get();
        System.out.println(document.text());

    }
}


//          Elements elements = document.select("text");

