package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        String returnedType = "";
        // Итерируем все методы класса
        for (Method method : Address.class.getDeclaredMethods()) {
            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {
                returnedType = method.getReturnType().getName();
                if (returnedType.equals("java.lang.String")) {
                returnedType = "String";
                }
                System.out.println("Method " + method.getName()
                + " returns a value of type " + returnedType);
            }
        }
        // END
    }
}
