package inkapplications.android.layoutinjector

/**
 * Designates a menu to be loaded into the actionbar.
 *
 * @author Renee Vandervelde (Renee@ReneeVandervelde.com)
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class AutoMenu(val value: Int)
