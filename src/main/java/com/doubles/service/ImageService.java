package com.doubles.service;

/**
 * @时间: 2018/4/23
 * @描述：用户对图片、相册的各种操作
 */
public interface ImageService {
    //新建相册
    boolean addAlbum(Album album);
    //修改相册
    boolean updateAlbum(Album album);
    //删除相册
    boolean deleteAlbum(String albumId);


}
