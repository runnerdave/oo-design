package net.runnerdave.rick_guitars.guitar_shop_v2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidajimenez on 27/11/2016.
 */
public class InstrumentSpec {

    private Map<String, Object> properties;


    public InstrumentSpec(Map<String, Object> properties) {
        if (properties == null) {
            this.properties = new HashMap<>();
        } else {
            this.properties = new HashMap<>(properties);
        }
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        properties.forEach((k, v) -> {
            sb.append(k).append(":").append(v.toString()).append("\n");
        });
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        boolean match = true;
        if (o instanceof InstrumentSpec) {
            InstrumentSpec otherSpec = (InstrumentSpec) o;
//            for (Iterator i = otherSpec.getProperties().keySet().iterator();
//                 i.hasNext(); ) {
//                String propertyName = (String)i.next();
//                if (!properties.get(propertyName).equals(
//                        otherSpec.getProperty(propertyName))) {
//                    return false;
//                }
//            }

            boolean result = otherSpec.getProperties()
                    .keySet()
                    .stream()
                    .anyMatch(k -> !properties.get(k).equals(otherSpec.getProperty(k)));
            match = !result;
        }
        return match;
    }
}
