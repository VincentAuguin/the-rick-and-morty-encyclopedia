package fr.ippon.trame.explore.character

import fr.ippon.trame.character.Character
import javax.inject.Inject

interface CharacterToCharactersListItemDataTransformer {
    operator fun invoke(character: Character): CharactersListItemData
}

class CharacterToCharactersListItemDataTransformerImpl @Inject constructor() :
    CharacterToCharactersListItemDataTransformer {
    override fun invoke(character: Character): CharactersListItemData {
        return CharactersListItemData(
            id = character.id,
            name = character.name,
            imageUrl = character.imageUrl,
            favorite = character.isFavorite
        )
    }
}