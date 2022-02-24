package com.example.androidnetworking.network




data class ApiModel<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): ApiModel<T> = ApiModel(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ApiModel<T> =
            ApiModel(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ApiModel<T> = ApiModel(status = Status.LOADING, data = data, message = null)
    }
}