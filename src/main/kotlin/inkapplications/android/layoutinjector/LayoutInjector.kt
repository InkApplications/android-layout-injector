package inkapplications.android.layoutinjector

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Injects the content view into an activity based on the Layout annotation.
 *
 * If the activity does not contain a layout annotation, this method will
 * do nothing.
 *
 * @receiver The activity to set the content view on
 */
fun Activity.autoInjectContentView() {
    val annotation = javaClass.getAnnotation(AutoLayout::class.java) ?: return

    setContentView(annotation.value)
}


/**
 * Inflates the content view based on the Layout Annotation of the class.
 *
 * If the fragment does not contain a layout annotation, this method will
 * throw a `LayoutNotSpecifiedException` – this is to ensure that you do
 * not attempt to return null. Typically, the exception should be handled
 * by returning the default call super, causing no effect.
 *
 * @receiver activity to set the content view on
 * @throws LayoutNotSpecifiedException when the implementing class does not
 * specify a Layout annotation.
 */
@Throws(LayoutNotSpecifiedException::class)
fun Fragment.autoInflateContentView(inflater: LayoutInflater, container: ViewGroup?): View {
    val annotation = javaClass.getAnnotation(AutoLayout::class.java) ?: throw LayoutNotSpecifiedException()

    val layoutId = annotation.value
    return inflater.inflate(layoutId, container, false)
}

fun Activity.autoInflateMenu(menu: android.view.Menu) {
    val annotation = javaClass.getAnnotation(AutoMenu::class.java) ?: return

    menuInflater.inflate(annotation.value, menu)
}
