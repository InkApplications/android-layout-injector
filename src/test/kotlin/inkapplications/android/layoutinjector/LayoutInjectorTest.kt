package inkapplications.android.layoutinjector

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.junit.Test
import org.mockito.Mockito

import org.junit.Assert.*

class LayoutInjectorTest {

    @AutoLayout(42)
    open class TestLayoutActivity : Activity()

    @SuppressLint("ValidFragment")
    @AutoLayout(42)
    open class TestLayoutFragment : Fragment()

    @Test fun injectContentView() {
        val mockActivity = Mockito.mock(Activity::class.java)
        val mockLayoutActivity = Mockito.mock(TestLayoutActivity::class.java)

        mockActivity.autoInjectContentView()
        mockLayoutActivity.autoInjectContentView()

        Mockito.verify(mockLayoutActivity, Mockito.times(1)).setContentView(42)
        Mockito.verify(mockActivity, Mockito.never()).setContentView(Mockito.anyInt())
    }

    @Test(expected = LayoutNotSpecifiedException::class)
    @Throws(Exception::class)
    fun inflateContentViewNotSpecified() {
        val mockFragment = Mockito.mock(Fragment::class.java)
        val mockInflater = Mockito.mock(LayoutInflater::class.java)
        val mockContainer = Mockito.mock(ViewGroup::class.java)

        mockFragment.autoInflateContentView(mockInflater, mockContainer)
    }

    @Test
    @Throws(Exception::class)
    fun inflateContentView() {
        val mockFragment = Mockito.mock(TestLayoutFragment::class.java)
        val mockContainer = Mockito.mock(ViewGroup::class.java)
        val mockView = Mockito.mock(View::class.java)
        val mockInflater = Mockito.mock(LayoutInflater::class.java)
        Mockito.`when`(mockInflater.inflate(42, mockContainer, false)).thenReturn(mockView)

        val view = mockFragment.autoInflateContentView(mockInflater, mockContainer)

        assertSame(mockView, view)
        Mockito.verify(mockInflater, Mockito.times(1)).inflate(42, mockContainer, false)
    }
}
