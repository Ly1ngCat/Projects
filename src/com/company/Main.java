package com.company;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

import java.io.*;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.*;
import java.net.MalformedURLException;


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
            Writer writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream("site.html"),charset));
            writer.write(html);
            writer.close();

            String text = "asdasdas? sadsa: sadasdasdasd\" asdasda; asdasd?? asdasdas";
            text = text.toLowerCase();
            text = text.replaceAll("[-\r\n\t,;.?!:\\[\\]()\"]", " ");


            Map<String, Integer> map = new HashMap<>();
            for(String word: text.split(" ")) {
                if(map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
                else {
                    map.put(word, 1);
                }
            }
            map.remove("");
            System.out.println(map);


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


