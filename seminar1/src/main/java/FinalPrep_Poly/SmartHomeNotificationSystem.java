package FinalPrep_Poly;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

interface SecurityObserver {
    void update(Map<String, String> rates);
}

interface SecuritySubject {
    void registerObserver(SecurityObserver o);
    void deleteObserver(SecurityObserver o);
    void notifyObservers();
}

class SmartHomeSecurity implements SecuritySubject {
    private List<SecurityObserver> observers;
    private Map<String, String> rates;

    public SmartHomeSecurity() {
        observers = new ArrayList<>();
        rates = new LinkedHashMap<>();
    }

    @Override
    public void registerObserver(SecurityObserver o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(SecurityObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (SecurityObserver o : observers) {
            o.update(rates);
        }
    }

    public void updateRates(String sensorName, String status) {
        rates.put(sensorName, status);
        notifyObservers();
    }
}

class ConsoleAlerter implements SecurityObserver {
    @Override
    public void update(Map<String, String> sensorStatuses) {
        System.out.println("--- Console Security Log ---");
        for (Map.Entry<String, String> entry : sensorStatuses.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }
}

/// kide daamateb tu rame mominda

public class SmartHomeNotificationSystem {
}
