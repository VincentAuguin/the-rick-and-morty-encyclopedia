package fr.ippon.trame.explore

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class ExploreViewModelTest {

    private lateinit var viewModel: ExploreViewModel

    @Before
    internal fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = ExploreViewModel()
    }

    @Test
    fun `should toggle favorite`() = runTest {
        val displayOnlyFavorite = viewModel.displayOnlyFavorite
        Assert.assertEquals(false, displayOnlyFavorite.first())
        viewModel.toggleFavoriteDisplay()
        Assert.assertEquals(true, displayOnlyFavorite.first())
        viewModel.toggleFavoriteDisplay()
        Assert.assertEquals(false, displayOnlyFavorite.first())
    }
}