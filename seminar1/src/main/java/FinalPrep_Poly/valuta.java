package FinalPrep_Poly;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

interface ExchangeRateObserver {
    void update(Map<String, Double> rates);
}

interface Subject {
    void registerObserver(ExchangeRateObserver o);
    void removeObserver(ExchangeRateObserver o);
    void notifyObservers();
}

class CurrencyExchangeManager implements Subject {
    private final List<ExchangeRateObserver> observers;
    private final Map<String, Double> exchangeRates;

    public CurrencyExchangeManager() {
        this.observers = new ArrayList<>();
        this.exchangeRates = new LinkedHashMap<>();
    }

    @Override
    public void registerObserver(ExchangeRateObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ExchangeRateObserver o) {
        observers.remove(o);
    }


    @Override
    public void notifyObservers() {
        for (ExchangeRateObserver observer : observers) {
            observer.update(exchangeRates);
        }
    }

    public void setRate(String currencyPair, double rate) {
        exchangeRates.put(currencyPair, rate);
        notifyObservers();
    }
}
class TextDisplay implements ExchangeRateObserver {
    @Override
    public void update(Map<String, Double> rates) {
        System.out.println("--- Text Format Update ---");
        for (Map.Entry<String, Double> entry : rates.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
}
class HtmlDisplay implements ExchangeRateObserver {
    @Override
    public void update(Map<String, Double> rates) {
        System.out.println("--- HTML Format Update ---");
        System.out.println("<ul>");
        for (Map.Entry<String, Double> entry : rates.entrySet()) {
            System.out.println("  <li>" + entry.getKey() + " " + entry.getValue() + "</li>");
        }
        System.out.println("</ul>\n");
    }
}

public class valuta {
    public static void main(String[] args) {
        CurrencyExchangeManager manager = new CurrencyExchangeManager();

        ExchangeRateObserver textDisplay = new TextDisplay();
        ExchangeRateObserver htmlDisplay = new HtmlDisplay();

        manager.registerObserver(textDisplay);
        manager.registerObserver(htmlDisplay);
        System.out.println(">>> პირველი ვალუტის დამატება:");
        manager.setRate("USD -> GEL", 3.12);

        System.out.println(">>> მეორე ვალუტის დამატება:");
        manager.setRate("EUR -> GEL", 3.69);

        System.out.println(">>> მესამე ვალუტის დამატება (ცვლილება):");
        manager.setRate("USD -> EUR", 0.85);
        System.out.println(">>> არსებული კურსის განახლება (მაგ: USD -> GEL გახდა 3.15):");
        manager.setRate("USD -> GEL", 3.15);
    }
}