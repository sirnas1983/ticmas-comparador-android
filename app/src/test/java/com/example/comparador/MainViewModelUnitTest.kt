package com.example.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.comparador.app.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.junit.Test
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

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
    fun mainViewModel_CheckInitialValue() = runTest{
        var text1 = mainViewModel.text1.value?.text
        var text2 = mainViewModel.text2.value?.text
        assertEquals("", text1)
        assertEquals("", text2)
    }

    @Test
    fun mainViewModel_CheckTrue() = runTest{
        var value = mainViewModel.compare()
        assertEquals(true, value)
    }

    @Test
    fun mainViewModel_CheckFalse() = runTest{
        mainViewModel.text2.value?.text = "a"
        var value = mainViewModel.compare()
        assertEquals(false, value)
    }

}