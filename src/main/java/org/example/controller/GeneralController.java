package org.example.controller;

import org.example.model.Address;
import org.example.model.Street;
import org.example.service.AddressService;
import org.example.service.StreetService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneralController {
    private final AddressService addressService = new AddressService();
    private final StreetService streetService = new StreetService();
    private final List<Street> streets = streetService.getList();
    private final List<Address> addresses = addressService.getList();

    public void getIndexName(String date, String indexes) throws IOException {
        List<Long> indexesList = Arrays.stream(indexes.split(", ")).map(Long::parseLong).collect(Collectors.toList());
        List<Address> resultA = addresses.stream().filter(address -> address.getUpdateDate().equals(date) && indexesList.contains(address.getObjectId())).collect(Collectors.toList());
        List<Street> resultS = streets.stream().filter(street -> indexesList.contains(street.getObjectId())).collect(Collectors.toList());

        FileWriter file = new FileWriter("info.txt", false);

        Map<Long, String> indexStreet = new HashMap<>();
        for (int i = 0; i < resultS.size(); i++) {
            indexStreet.put(resultA.get(i).getObjectId(), resultS.get(i).getTypeName() + " " + resultS.get(i).getName());
        }

        for (Map.Entry<Long, String> entry : indexStreet.entrySet()) {
            file.write(entry.getKey() + ":" + entry.getValue() + "\n");
        }
    }

    //Не совсем понял задачу. Написано, что надо вывести цепочкой все адреса со словом проезд, но в примере указаны несколько улиц,
    //в которых как раз не встречается это слово.
    public void getAllProezd() throws IOException {
        for (Street street : streets) {
            FileWriter file = new FileWriter("proezd.txt", false);
            if (street.getTypeName().equals("проезд")) {
                file.write(street.getTypeName() + " " + street.getName() + " ");
            }
        }
    }
}
