package gaur.himanshu.tddbearapp.beer_list

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.espresso.IdlingRegistry
import gaur.himanshu.tddbearapp.MainActivity
import gaur.himanshu.tddbearapp.di.clientResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BeerListFeature  {

    @get:Rule
    val composeRule= createAndroidComposeRule<MainActivity>()

    @Before
    fun setup(){
        IdlingRegistry.getInstance().register(clientResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(clientResource)
    }

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

    @Test
    fun validateProgressBarIsVisible(){
        IdlingRegistry.getInstance().unregister(clientResource)
        composeRule.apply{
            onNodeWithTag("progress").assertIsDisplayed()
        }
    }

    @Test
    fun validateNavigationFromBeerScreenTOBeerDetailsScreen(){
        composeRule.apply {
            onNodeWithTag("list").onChildAt(0).assertIsDisplayed().performClick()
            onNodeWithText("Beer Details").assertIsDisplayed()
        }
    }


}