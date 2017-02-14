package inkapplications.android.layoutinjector;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Injects the Content View for the activity using the `@Layout` Annotation.
 *
 * @see Layout
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
public class LayoutInjector
{
    public LayoutInjector() {}

    /**
     * Injects the content view into an activity based on the Layout annotation.
     *
     * If the activity does not contain a layout annotation, this method will
     * do nothing.
     *
     * @param activity The activity to set the content view on
     */
    public void injectContentView(Activity activity)
    {
        Layout annotation = activity.getClass().getAnnotation(Layout.class);

        if (null == annotation) {
            return;
        }

        activity.setContentView(annotation.value());
    }

    /**
     * Inflates the content view based on the Layout Annotation of the class.
     *
     * If the fragment does not contain a layout annotation, this method will
     * throw a `LayoutNotSpecifiedException` – this is to ensure that you do
     * not attempt to return null. Typically, the exception should be handled
     * by returning the default call super, causing no effect.
     *
     * @param fragment The activity to set the content view on
     * @throws LayoutNotSpecifiedException when the implementing class does not
     *         specify a Layout annotation.
     */
    public View inflateContentView(
        Fragment fragment,
        LayoutInflater inflater,
        ViewGroup container
    ) throws LayoutNotSpecifiedException {
        Layout annotation = fragment.getClass().getAnnotation(Layout.class);

        if (null == annotation) {
            throw new LayoutNotSpecifiedException();
        }

        int layoutId = annotation.value();
        return inflater.inflate(layoutId, container, false);
    }
}
