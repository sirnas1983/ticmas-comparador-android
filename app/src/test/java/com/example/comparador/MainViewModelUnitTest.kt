package com.example.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.comparador.app.model.Texts
import com.example.comparador.app.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Test
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var mainViewModel : MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        mainViewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckTrue() = runTest{
        val text = Texts("","")
        var value = mainViewModel.compare(text)
        assertEquals(true, value)
    }

    @Test
    fun mainViewModel_CheckFalse() = runTest{
        val text = Texts("a","b")
        var value = mainViewModel.compare(text)
        assertEquals(false, value)
    }

}