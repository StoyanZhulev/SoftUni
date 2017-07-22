import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AccessMOdifier {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<Reflection> reflectionClass = Reflection.class;

        Field field = reflectionClass.getDeclaredField("nickName");
        field.setAccessible(true);

        Field modifierField = Field.class.getDeclaredField("modifiers");
        modifierField.setAccessible(true);
        modifierField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, 10);
        System.out.println(field.get(null));
    }
}
