package fr.ippon.trame.explore.character

import fr.ippon.trame.character.Character
import javax.inject.Inject

interface CharactersToCharactersListDataTransformer {
    operator fun invoke(characters: List<Character>): CharactersListData
}

class CharactersToCharactersListDataTransformerImpl @Inject constructor(private val transformToCharactersListItemData: CharacterToCharactersListItemDataTransformer) :
    CharactersToCharactersListDataTransformer {
    override fun invoke(characters: List<Character>): CharactersListData {
        return CharactersListData(characters = characters.map(transformToCharactersListItemData::invoke))
    }
}