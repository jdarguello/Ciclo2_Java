import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Ejemplo ej = new Ejemplo();

        Field[] fields = ej.getClass().getDeclaredFields();

        System.out.println(Arrays.toString(fields));
        System.out.println((fields[0].getName()));
    }
}
