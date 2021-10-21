package com.example.cryptoprojectjetpackcompose.db.dao

import androidx.room.*
import com.example.cryptoprojectjetpackcompose.db.entity.UserEntity
import com.example.cryptoprojectjetpackcompose.db.entity.UserWithCryptos

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    suspend fun getUsers(): List<UserEntity>

    @Transaction
    @Query("SELECT * FROM UserEntity")
    suspend fun getUserWithCrypto(): List<UserWithCryptos>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)


}