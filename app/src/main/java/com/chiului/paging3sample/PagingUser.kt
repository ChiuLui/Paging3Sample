package com.chiului.paging3sample

/**
 * 分页用户实体类$
 * @author    神经大条蕾弟
 * @date      2020/09/15 10:55
 */
data class PagingUser (
    val results: List<User>,
    var nextPageNumber : Int)