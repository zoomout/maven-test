package injectionOfValueByFieldAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zoomout on 12/27/16.
 */
public class Injector {
    public static void setDefaults(Object object) {
        Method[] methods = object.getClass().getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(SetDefault.class)) {
                try {
                    final String fieldName = method.getAnnotation(SetDefault.class).value();

                    Field field = object.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);

                    if (isFieldInitializedToDefault(object, field)) {
                        method.invoke(object, null);
                    }
                } catch (InvocationTargetException | NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isFieldInitializedToDefault(Object object, Field field)
      throws IllegalAccessException {
        boolean initializedToDefault = false;
        Class<?> clazz = field.getType();
        if (clazz.equals(int.class)) {
            if (field.getInt(object) == 0) {
                initializedToDefault = true;
            }

        } else if (clazz.equals(double.class)) {
            if (field.getDouble(object) == 0) {
                initializedToDefault = true;
            }
        } else if (clazz.equals(boolean.class)) {
            if (!field.getBoolean(object)) {
                initializedToDefault = true;
            }
        } else if (clazz.equals(float.class)) {
            if (field.getFloat(object) == 0) {
                initializedToDefault = true;
            }
        } else if (clazz.equals(char.class)) {
            if (field.getChar(object) == 0) {
                initializedToDefault = true;
            }
        } else if (clazz.equals(byte.class)) {
            if (field.getByte(object) == 0) {
                initializedToDefault = true;
            }
        } else if (clazz.equals(long.class)) {
            if (field.getLong(object) == 0) {
                initializedToDefault = true;
            }
        } else if (field.get(object) == null) {
            initializedToDefault = true;
        }
        return initializedToDefault;
    }

}
