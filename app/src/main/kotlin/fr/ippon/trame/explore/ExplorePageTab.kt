package fr.ippon.trame.explore

import androidx.annotation.StringRes
import fr.ippon.trame.R

enum class ExplorePageTab(@StringRes val title: Int) {
    CHARACTERS(R.string.explore_text_tab_characters),
    EPISODES(R.string.explore_text_tab_episodes),
    LOCATIONS(R.string.explore_text_tab_locations)
}