package com.moaimar.app.data

class MemDataStore <T> {
    private val dataStore: MutableMap<String, T> = mutableMapOf()

    fun save(id:String,model:T){
        dataStore[id] = model
    }

    fun getDetail(id: String) = dataStore[id]

    fun getFeed()=
        dataStore.map{
            it.value
        }
}