package inkapplications.android.layoutinjector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Designates a content view to be displayed when running the specified ui class.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layout
{
    /**
     * The resource ID to be displayed.
     */
    int value();
}
