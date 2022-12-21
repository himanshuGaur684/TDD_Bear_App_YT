package gaur.himanshu.tddbearapp.beer_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import gaur.himanshu.tddbearapp.MainActivity
import org.junit.Rule
import org.junit.Test

class BeerListFeature  {


    @get:Rule
    val composeRule= createAndroidComposeRule<MainActivity>()

    @Test
    fun validateTopAppBarBeerDetailsIsVisible(){

        composeRule.apply {
            onNodeWithText("Beer List").assertIsDisplayed()
        }
    }

    @Test
    fun validateBeerListIsVisible(){
        composeRule.apply {
            onNodeWithTag("list").assertIsDisplayed()
        }
    }
























}