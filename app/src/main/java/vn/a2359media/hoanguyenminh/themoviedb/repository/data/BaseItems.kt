package vn.a2359media.hoanguyenminh.themoviedb.repository.data

/**
 * Created by Hoa Nguyen on 2018 November 29.
 *
 */
abstract class BaseItems<Item> {
    abstract fun getListItems(): List<Item>
}