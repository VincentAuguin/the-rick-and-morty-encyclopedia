package fr.ippon.trame.explore.character

import fr.ippon.trame.character.GetAllCharactersUseCase
import fr.ippon.trame.character.GetAllFavoriteCharactersUseCase
import fr.ippon.trame.character.SetCharacterFavoriteUseCase
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before

internal class ExploreCharactersViewModelTest {

    private lateinit var viewModel: ExploreCharactersViewModel

    @RelaxedMockK
    lateinit var getAllCharacters: GetAllCharactersUseCase

    @RelaxedMockK
    lateinit var getAllFavoriteCharactersUseCase: GetAllFavoriteCharactersUseCase

    @Before
    fun setup() {

    }
}