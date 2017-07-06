package QCJSON_JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;


/**
 * Created by SFerrel on 7/6/2017. Found this example at--> https://www.tutorialspoint.com/json/json_java_example.htm
 * I rewrote this to understand what is happening
 */
public class JSON {
    public static void main(String[] args) throws IOException, ParseException {
        JSONObject obj = new JSONObject();

        obj.put("name", "finny");
        obj.put("num of fins", new Integer(2));
        obj.put("Species", "Catfish");
        obj.put("Swims upside down?", new Boolean(true));

        System.out.print(obj);

        //StringWriter
        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.print(jsonText);

        //Decoding JSON example with JSONObject and JSONArray
        JSONParser parser = new JSONParser();
        String list = "[ 0, {\"One\":{\"Two\":{\"Three\":{\"Four\":{\"Five\":{\"Six\":\"Seven\"}}}}}}]";

        try {
            Object obj2 = parser.parse(list);
            JSONArray array = (JSONArray) obj2;

            System.out.println();
            System.out.println("Second element");
            System.out.println(array.get(1));
            System.out.println();


            JSONObject obj3 = (JSONObject) array.get(1);
            System.out.println("Field \"1\"");
            System.out.println(obj3.get("One"));


            list = "{     }";
            obj2 = parser.parse(list);
            System.out.println(obj2);

            list = "[\"Five\", \" Oh \"]";
            obj2 = parser.parse(list);
            System.out.println(obj2);

            list = "[\"One\",\"Two\",\"Three\",\"Four\"]";
            obj2 = parser.parse(list);
            System.out.println(obj2);

        } catch (ParseException pe) {

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);


        }
    }
}
