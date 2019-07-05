package com.android.kotlinmall.common

import com.orhanobut.logger.Logger
import io.reactivex.Observable

/**
 ** Create by 对方已经拉黑你
 **
 ** Time at 2019-07-03
 **
 ** Description is
 **/

abstract class ListPage<DataType> : DataProvider<DataType> {

    private val relMap = HashMap<String, String?>()


    companion object {
        const val PAGE_SIZE = 20
    }

    var currentPage = 1
        private set
    val data = ArrayList<DataType>()

    /**
     * 加载更多
     */
    fun loadMore() = getData(currentPage + 1)
        .doOnNext {
            currentPage + 1 //成功的时候页面+1
        }.doOnError { Logger.e("loadMore Error", it) }
        .map {
            data.addAll(it)
            data
        }

    fun loadFromfirst(pageCount: Int = currentPage) =
        Observable.range(1, pageCount)
            .concatMap {
                getData(it)
            }.doOnError {
                Logger.e("loadFromfirst ,pageCount=$pageCount", it)
            }/*.reduce { acc, page ->
                acc += page

            }*/
            .doOnNext {
                data.clear()
                data.addAll(it)
            }

}