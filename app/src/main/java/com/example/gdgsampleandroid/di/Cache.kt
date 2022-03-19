package com.example.gdgsampleandroid.di

import androidx.collection.LruCache

class Cache :LruCache<Int, Any>((Runtime.getRuntime().totalMemory()/1024).toInt()/8
){
    fun <T> writeToCache(k:T,v:Any){
        this.put(k.hashCode(),v)
    }

    fun <T> removeFromCache(k:T){
        this.remove(k.hashCode())
    }

    fun clearCache(){
        this.evictAll()
    }

    fun <T> getFromCache(k:T): Any? {
        return this.get(k.hashCode())
    }

    fun <T>writeOrUpdate(k:T, v: Any){
        this.put(k.hashCode(), v)
    }


}