package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by zoomout on 11/3/16.
 */

@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int id() default 1;
}
