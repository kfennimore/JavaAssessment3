package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ElementCollection extends ArrayList <Element> {

    public Element findByAtomicNumber(int atomic_number) {

        Iterator findAtomicNum = iterator();

        //while there are more items in the array...go to the next one
        while (findAtomicNum.hasNext()) {
            //cast this to element
            Element individualElement = (Element) findAtomicNum.next();
            //if the atomic number matches the arguments number then return that element
            if (individualElement.getNumber() == atomic_number) {
                return individualElement;
            }
        }
        return null;
    }

    public Element findByName(String name) {

        Iterator findAtomicName = iterator();

        //while there are more items in the array...go to the next one
        while (findAtomicName.hasNext()) {
            //cast this to element
            Element individualElement = (Element) findAtomicName.next();
            //if the elements name matches the arguments name then return that element
            if (individualElement.getName().equalsIgnoreCase(name)) {
                return individualElement;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {

        ElementCollection ecollection = new ElementCollection();
        Iterator whereElement = iterator();
        Field elementField = null;


        //while there are more items in the array...go to the next one
        while (whereElement.hasNext()) {
            //cast to element
            Element element = (Element) whereElement.next();

            try {
                //use reflection to find fieldName
                //All the fields, regardless of their accessibility but only for the current class,
                //not any base classes that the current class might be inheriting from.
                elementField = element.getClass().getDeclaredField(fieldName);
                //if the field doesnt exist
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            //change the behavior of the AccessibleObject, i.e. the Field instance, but not the actual field of the class!
            //let this object become accessible so you can access value
            elementField.setAccessible(true);

            try {
                //use fieldName to get value
                if (elementField.get(element).equals(value)) {
                    ecollection.add(element);
                }
                //if you cant get in catch it!
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return ecollection;
    }
}
