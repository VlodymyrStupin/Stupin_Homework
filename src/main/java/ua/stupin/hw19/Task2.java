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
    static class Box{
        String from;
        String material;
        JSONObject maxLiftingCapacity;
        JSONObject cargo;
        String deliveryDate;

        @Override
        public String toString() {
            return "Box{" +
                    "from='" + from + '\'' +
                    ", material='" + material + '\'' +
                    ", max-lifting-capacity=" + maxLiftingCapacity +
                    ", cargo=" + cargo +
                    ", delivery-date='" + deliveryDate + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("D:\\Java study\\Homework_Stupin\\Homework\\src\\main\\resources\\box.json"));
            JSONObject jsonObject = (JSONObject)obj;
            Box box = new Box();
            box.from = (String)jsonObject.get("from");
            box.material = (String)jsonObject.get("material");
            box.maxLiftingCapacity = (JSONObject) jsonObject.get("max-lifting-capacity");
            box.cargo = (JSONObject) jsonObject.get("cargo");
            box.deliveryDate = (String) jsonObject.get("delivery-date");
            System.out.println(box);
            System.out.println(box.maxLiftingCapacity.get("unit"));
            System.out.println(box.maxLiftingCapacity.get("value"));
            System.out.println(box.cargo.get("name"));
            System.out.println(box.cargo.get("class"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
