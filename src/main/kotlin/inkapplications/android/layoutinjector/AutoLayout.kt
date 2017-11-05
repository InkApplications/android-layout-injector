package inkapplications.android.layoutinjector

/**
 * Designates a content view to be displayed when running the specified ui class.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class AutoLayout(val value: Int)
