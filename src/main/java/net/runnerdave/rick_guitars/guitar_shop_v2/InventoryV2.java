package net.runnerdave.rick_guitars.guitar_shop_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by davidajimenez on 27/11/2016.
 */
public class InventoryV2 {
    List<Instrument> instruments;

    public InventoryV2() {
        this.instruments = new ArrayList();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument =  new Instrument(serialNumber, price, spec);
        instruments.add(instrument);
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        return instruments.stream().filter(s->s.getSpec().equals(searchSpec)).collect(Collectors.toList());
    }
}
