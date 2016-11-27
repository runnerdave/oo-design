package net.runnerdave.rick_guitars.guitar_shop;

import net.runnerdave.rick_guitars.guitar_shop_types.Builder;
import net.runnerdave.rick_guitars.guitar_shop_types.Type;
import net.runnerdave.rick_guitars.guitar_shop_types.Wood;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 23/11/2016.
 */
public class Inventory {
    private List<Guitar> guitars;

    public Inventory() {
        guitars = new LinkedList();
    }

    public void addGuitar(String serialNumber, double price,
                          Builder builder, String model,
                          Type type, Wood backWood, Wood topWood, int numStrings) {
        GuitarSpec spec = new GuitarSpec(builder, model,type, backWood, topWood, numStrings);
        Guitar guitar = new Guitar(serialNumber, price, spec);
        guitars.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

//    public List search(GuitarSpec searchSpec) {
//        List<Guitar> matchingGuitars = new LinkedList<>();
//        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
//            Guitar guitar = (Guitar)i.next();
//            GuitarSpec guitarSpec = guitar.getSpec();
//            if (searchSpec.getBuilder() != guitarSpec.getBuilder())
//                continue;
//            String model = searchSpec.getModel().toLowerCase();
//            if ((model != null) && (!model.equals("")) &&
//                    (!model.equals(guitarSpec.getModel().toLowerCase())))
//                continue;
//            if (searchSpec.getType() != guitarSpec.getType())
//                continue;
//            if (searchSpec.getBackWood() != guitarSpec.getBackWood())
//                continue;
//            if (searchSpec.getTopWood() != guitarSpec.getTopWood())
//                continue;
//            matchingGuitars.add(guitar);
//        }
//        return matchingGuitars;
//    }

    public List search(GuitarSpec searchSpec) {
        List<Guitar> matchingGuitars = new LinkedList<>();
        for (Iterator i = guitars.iterator(); i.hasNext(); ) {
            Guitar guitar = (Guitar)i.next();
            GuitarSpec guitarSpec = guitar.getSpec();
            if (guitarSpec.equals(searchSpec)) {
                matchingGuitars.add(guitar);
            }
        }
        return matchingGuitars;
    }

    public List searchStream(GuitarSpec searchSpec) {

        return guitars.stream().filter(s->s.getSpec().equals(searchSpec)).peek(s-> System.out.println("peek:"+s)).collect(Collectors.toList());
    }

}
