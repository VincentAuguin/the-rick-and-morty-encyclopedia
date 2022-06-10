package fr.ippon.trame.character.network.rest

import fr.ippon.trame.character.Character

fun CharacterDto.toModel() = Character(
    id = id.toString(),
    name = name.orEmpty(),
    imageUrl = image.orEmpty(),
    isFavorite = false
)