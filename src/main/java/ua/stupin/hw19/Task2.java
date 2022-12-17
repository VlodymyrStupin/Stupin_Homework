package ua.stupin.hw19;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/*
Прочитать json файл и на его основе построить экземпляр класса Box (класс должен быть создан предварительно)
Пример box.json
{
“from”:”China”,
“material”:”steel”,
“color”:”black”,
“max-lifting-capacity”:{
“unit”: “kg”,
“value”: 150 }, “cargo”: { “name” : “electronics”, “class”: “C-1” }, “delivery-date” : “2021-09-20T11:07:00”
}
 */
public class Task2 {

    static class Box {
        String from;
        String material;
        String deliveryDate;
        Cargo cargo;
        MaxLiftingCapacity maxLiftingCapacity;

        @Override
        public String toString() {
            return "Box{" +
                    "from='" + from + '\'' +
                    ", material='" + material + '\'' +
                    ", deliveryDate='" + deliveryDate + '\'' +
                    ", " + cargo +
                    ", " + maxLiftingCapacity +
                    '}';
        }
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\Java study\\Homework_Stupin\\Homework\\src\\main\\resources\\box.json"));
            JSONObject jsonObject = (JSONObject) obj;
            Box box = new Box();
            box.from = (String) jsonObject.get("from");
            box.material = (String) jsonObject.get("material");
            box.maxLiftingCapacity =  parseMaxLiftingCapacityObject(jsonObject);
            box.cargo = parseCargoObject(jsonObject);
            box.deliveryDate = (String) jsonObject.get("delivery-date");
            System.out.println(box);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cargo parseCargoObject(JSONObject jsonCargo){
        Cargo cargo = new Cargo();
        JSONObject cargoObject = (JSONObject) jsonCargo.get("cargo");
        cargo.clazz = (String) cargoObject.get("class");
        cargo.name = (String) cargoObject.get("name");
        return cargo;
    }
    public static MaxLiftingCapacity parseMaxLiftingCapacityObject(JSONObject jsonMaxLiftingCapacity){
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        JSONObject maxLiftingCapacityObject = (JSONObject) jsonMaxLiftingCapacity.get("max-lifting-capacity");
        maxLiftingCapacity.unit = (String) maxLiftingCapacityObject.get("unit");
        maxLiftingCapacity.value = (long) maxLiftingCapacityObject.get("value");
        return maxLiftingCapacity;
    }
}