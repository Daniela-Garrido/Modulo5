package com.aumentarte.modulo5.modelo.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WalletRetrofit {
    companion object {
        private const val BASE_URL = "http://wallet-main.eba-ccwdurgr.us-east-1.elasticbeanstalk.com/"
        private var walletRetrofitInstance: Retrofit? = null

        fun retrofitInstance(): Api {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}
