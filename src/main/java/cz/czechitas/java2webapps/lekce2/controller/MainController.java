package cz.czechitas.java2webapps.lekce2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class MainController {

    final Locale LOCALE = Locale.forLanguageTag("cs-CZ");
    final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d. MMMM yyyy", LOCALE);
    final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm", LOCALE);

    @GetMapping("/datum")
    public ModelAndView getDatePage() {
        ModelAndView result = new ModelAndView("datum");
        String datum = LocalDate.now().format(DATE_FORMATTER);
        result.addObject("datum", datum);
        return result;
    }

    @GetMapping("/cas")
    public ModelAndView getTimePage() {
        ModelAndView result = new ModelAndView("cas");
        String cas = LocalTime.now().format(TIME_FORMATTER);
        result.addObject("cas", cas);
        return result;
    }
}
