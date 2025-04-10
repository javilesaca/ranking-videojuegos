package com.javilesaca.ranking.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Servicio para realizar web scraping y obtener información de videojuegos.
 */
@Service
public class WebScrapingService {

    /**
     * Obtiene la descripción de un videojuego desde Metacritic.
     *
     * @param juego Nombre del videojuego a buscar.
     * @return Descripción del juego o un mensaje de error si no se encuentra.
     */
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
