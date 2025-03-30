package com.javilesaca.ranking.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WebScrapingService {

    public String ObtenerDescripcionJuego(String juego) {
        try {
            String url = "https://www.metacritic.com/search/game/" + juego.replace(" ", "%20") + "/results";
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            Element firstResult = doc.selectFirst(".result .summary");
            return firstResult != null ? firstResult.text() : "Descripción del juego no encontrada";
        } catch (IOException e) {
            return "Error al obtener la información de " + juego;
        }
    }
}
