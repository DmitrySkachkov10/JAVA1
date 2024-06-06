package by.dmitry.pars;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Document doc =  Jsoup.connect("https://realt.by").get();

    }

}
