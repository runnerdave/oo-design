package net.runnerdave.rick_guitars.guitar_shop_v2;

import net.runnerdave.rick_guitars.guitar_shop_types.Builder;
import net.runnerdave.rick_guitars.guitar_shop_types.InstrumentType;
import net.runnerdave.rick_guitars.guitar_shop_types.Type;
import net.runnerdave.rick_guitars.guitar_shop_types.Wood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davidajimenez on 27/11/2016.
 */
public class FindInstrumentTester {

    public static void main(String[] args) {
        System.out.println("==Welcome to the guitar show V2");
        InventoryV2 inventoryV2 = new InventoryV2();
        initializeInventory(inventoryV2);

        Map<String, Object> properties = new HashMap();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec whatBryanLikes = new InstrumentSpec(properties);

        List<Instrument> matchingInstruments = inventoryV2.search(whatBryanLikes);

        if (!matchingInstruments.isEmpty()) {
            System.out.println("Bryan, you might like these instruments:");
            matchingInstruments.stream().forEach(s -> {
                System.out.println("We have a " + s.getSpec().getProperty("instrumentType") +
                        " with the following properties:");
                System.out.println(s.getSpec().toString());
                System.out.println("  You can have this " +
                        s.getSpec().getProperty("instrumentType") + " for $" +
                        s.getPrice() + "\n---");
            });
        } else {
            System.out.println("Sorry, Bryan, we have nothing for you.");
        }


    }

    public static void initializeInventory(InventoryV2 inventory) {
        Map<String, Object> properties = new HashMap<>();

        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.SITKA);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.MARTIN);
        properties.put("model", "D-18");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.ADIRONDACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.ALDER);
        properties.put("backWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Les Paul");
        properties.put("topWood", Wood.MAPLE);
        properties.put("backWood", Wood.MAPLE);
        inventory.addInstrument("70108276", 2295.95,
                new InstrumentSpec(properties));

        properties.put("model", "SG '61 Reissue");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.MAHOGANY);
        inventory.addInstrument("82765501", 1890.95,
                new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("type", Type.ACOUSTIC);
        properties.put("model", "F-5G");
        properties.put("backWood", Wood.MAPLE);
        properties.put("topWood", Wood.MAPLE);
        properties.remove("numStrings");
        inventory.addInstrument("9019920", 5495.99, new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("model", "RB-3 Wreath");
        properties.remove("topWood");
        properties.put("numStrings", 5);
        inventory.addInstrument("8900231", 2945.95, new InstrumentSpec(properties));
    }
}
