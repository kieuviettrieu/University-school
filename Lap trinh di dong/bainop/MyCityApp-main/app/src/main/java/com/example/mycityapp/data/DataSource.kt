package com.example.mycityapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import com.example.mycityapp.R
import com.example.mycityapp.model.Category
import com.example.mycityapp.model.Recommendation

object DataSource {
    val defaultRecommendation: Recommendation = getRestaurantData()[0]

    fun getRestaurantData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                titleResourceId = R.string.yasmines_title,
                addressResourceId = R.string.yasmines_address,
                descriptionResourceId = R.string.yasmines_description,
                imageResourceId = R.drawable.restaurant1
            ),
            Recommendation(
                id = 2,
                titleResourceId = R.string._168_title,
                addressResourceId = R.string._168_address,
                descriptionResourceId = R.string._168_description,
                imageResourceId = R.drawable.restaurant2,
            ),
            Recommendation(
                id = 3,
                titleResourceId = R.string.beertown_title,
                addressResourceId = R.string.beertown_address,
                descriptionResourceId = R.string.beertown_description,
                imageResourceId = R.drawable.restaurant3
            ),
            Recommendation(
                id = 4,
                titleResourceId = R.string.spageddy_title,
                addressResourceId = R.string.spageddy_address,
                descriptionResourceId = R.string.spageddy_description,
                imageResourceId = R.drawable.restaurant4,
            )
        )
    }

    fun getGroceryData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 5,
                titleResourceId = R.string.loblaws_title,
                addressResourceId = R.string.loblaws_address,
                descriptionResourceId = R.string.loblaws_description,
                imageResourceId = R.drawable.grocery1
            ),
            Recommendation(
                id = 6,
                titleResourceId = R.string.costco_title,
                addressResourceId = R.string.costco_address,
                descriptionResourceId = R.string.costco_description,
                imageResourceId = R.drawable.costco,
            ),
            Recommendation(
                id = 7,
                titleResourceId = R.string.nofrills_title,
                addressResourceId = R.string.nofrills_address,
                descriptionResourceId = R.string.nofrills_description,
                imageResourceId = R.drawable.grocery3
            ),
            Recommendation(
                id = 8,
                titleResourceId = R.string.my_kitchen_title,
                addressResourceId = R.string.my_kitchen_address,
                descriptionResourceId = R.string.my_kitchen_description,
                imageResourceId = R.drawable.kitchen,
            )
        )
    }

    fun getWesternData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 9,
                titleResourceId = R.string.med_hall_title,
                addressResourceId = R.string.med_hall_address,
                descriptionResourceId = R.string.med_hall_description,
                imageResourceId = R.drawable.med_hall
            ),
            Recommendation(
                id = 10,
                titleResourceId = R.string.uc_hill_title,
                addressResourceId = R.string.uc_hill_address,
                descriptionResourceId = R.string.uc_hill_description,
                imageResourceId = R.drawable.uc_hill,
            ),
            Recommendation(
                id = 11,
                titleResourceId = R.string.taylor_title,
                addressResourceId = R.string.taylor_address,
                descriptionResourceId = R.string.taylor_description,
                imageResourceId = R.drawable.library
            ),
            Recommendation(
                id = 12,
                titleResourceId = R.string.rec_title,
                addressResourceId = R.string.rec_address,
                descriptionResourceId = R.string.rec_description,
                imageResourceId = R.drawable.gym,
            )
        )
    }

    fun getMustSeeData(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 13,
                titleResourceId = R.string.transit_title,
                addressResourceId = R.string.transit_address,
                descriptionResourceId = R.string.transit_description,
                imageResourceId = R.drawable.bus
            ),
            Recommendation(
                id = 14,
                titleResourceId = R.string.trail_title,
                addressResourceId = R.string.trail_address,
                descriptionResourceId = R.string.trail_description,
                imageResourceId = R.drawable.trail,
            ),
            Recommendation(
                id = 15,
                titleResourceId = R.string.bg_title,
                addressResourceId = R.string.bg_address,
                descriptionResourceId = R.string.bg_description,
                imageResourceId = R.drawable.budweiser
            ),
            Recommendation(
                id = 16,
                titleResourceId = R.string.tin_title,
                addressResourceId = R.string.tin_address,
                descriptionResourceId = R.string.tin_description,
                imageResourceId = R.drawable.minigolf,
            )
        )
    }

    val defaultCategory: Category = getCategoryData()[0]
    fun getCategoryData(): List<Category> {
        return listOf(
            Category(
                titleResourceId = R.string.restaurant_category,
                icon = R.drawable.restaurant_icon
            ),
            Category(
                titleResourceId = R.string.grocery_category,
                icon = R.drawable.grocery_icon
            ),
            Category(
                titleResourceId = R.string.western_category,
                icon = R.drawable.school_icon
            ),
            Category(
                titleResourceId = R.string.must_see_category,
                icon = R.drawable.must_see_icon
            )
        )
    }
}