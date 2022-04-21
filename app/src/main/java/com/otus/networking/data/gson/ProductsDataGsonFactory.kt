package com.otus.networking.data.gson

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.alfabank.mobile.android.widgetuserproducts.data.model.UserProductCreditDto
import ru.alfabank.mobile.android.widgetuserproducts.data.model.UserProductExternalCardDto
import ru.alfabank.mobile.android.widgetuserproducts.data.model.UserProductInvestDto

private const val TYPE_FIELD_NAME = "type"

private val actionTypes = mapOf(
    UserProductsInfoType.EXTERNAL_CARD.name to UserProductExternalCardDto::class.java,
    UserProductsInfoType.CREDIT.name to UserProductCreditDto::class.java,
    UserProductsInfoType.BROKERAGE.name to UserProductInvestDto::class.java,
    UserProductsInfoType.IIA.name to UserProductInvestDto::class.java,
    UserProductsInfoType.FIDUCIARY.name to UserProductInvestDto::class.java,
    UserProductsInfoType.INVESTBOX.name to UserProductInvestDto::class.java
)

object ProductsDataGsonFactory {

    @JvmStatic fun createProductsGson(): TypeAdapterFactory {
        val typeFactory = PrefillerRuntimeTypeAdapterFactory(
            UserProductsData::class.java,
            TYPE_FIELD_NAME,
            UnknownDto()
        )

        actionTypes.forEach { (type, javaClass) ->
            typeFactory.registerSubtype(javaClass, type)
        }
        return typeFactory
    }

    val deserializer = GsonBuilder()
        .registerTypeAdapterFactory(ProductsDataGsonFactory.createProductsGson())
        .create()
    val factory = GsonConverterFactory.create(deserializer)

    //retrofitBuilder().addConverterFactory(gsonConverterFactory)
}