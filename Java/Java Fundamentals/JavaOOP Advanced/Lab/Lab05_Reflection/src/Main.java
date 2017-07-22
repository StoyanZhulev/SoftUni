import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Field[] fields = Reflection.class.getDeclaredFields();

        Method[] methods = Reflection.class.getDeclaredMethods();

        Method[] getters = Arrays.stream(methods).filter(e -> e.getName().startsWith("get")).toArray(Method[]::new);
        Method[] setters = Arrays.stream(methods).filter(e -> e.getName().startsWith("set")).toArray(Method[]::new);

        Arrays.sort(fields, Comparator.comparing(Field::getName));
        Arrays.sort(getters, Comparator.comparing(Method::getName));
        Arrays.sort(setters, Comparator.comparing(Method::getName));

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())) {
                System.out.printf("%s have to be public!%n", getter.getName());
            }
        }

        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())) {
                if ("void".equals(setter.getReturnType().getName())) {
                    if (setter.getParameterCount() == 1) {
                        System.out.printf("%s have to be private!%n", setter.getName());
                    }
                }
            }
        }

//        2 task
//        Class reflectionClass = Reflection.class;
//        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
//
//        Map<String, String> getters = new TreeMap<>();
//        Map<String, String> setters = new TreeMap<>();
//
//        for (Method declaredMethod : declaredMethods) {
//            if(declaredMethod.getName().startsWith("get") && declaredMethod.getParameters().length == 0){
//                getters.put(declaredMethod.getName(), String.valueOf(declaredMethod.getReturnType()));
//            }else if(declaredMethod.getName().startsWith("set") && declaredMethod.getParameterCount() == 1){
//                setters.put(declaredMethod.getName(), String.valueOf(declaredMethod.getParameterTypes()[0]));
//            }
//        }
//
//        for (String s : getters.keySet()) {
//            System.out.printf("%s will return %s%n",s, getters.get(s));
//        }
//
//        for (String s : setters.keySet()) {
//            System.out.printf("%s and will set field of %s%n", s, setters.get(s));
//        }

//=======================================================

//        1 task
//        Class reflectionClass = Reflection.class;
//        System.out.println(reflectionClass);
//
//        Class superClass = reflectionClass.getSuperclass();
//        System.out.println(superClass);
//
//        System.out.println(Arrays.toString(reflectionClass.getSigners()));
//        Class[] intefraces = reflectionClass.getInterfaces();
//        for (Class intefrace : intefraces) {
//            System.out.println(intefrace);
//        }
//
//        Reflection ref = (Reflection) reflectionClass.newInstance();
//        System.out.println(ref);
    }
}
