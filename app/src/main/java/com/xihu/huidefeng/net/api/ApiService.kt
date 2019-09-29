package com.xihu.huidefeng.net.api

import com.xihu.huidefeng.net.beans.*
import retrofit2.http.*

interface ApiService {
	
	@POST("register")
	suspend fun register(@Field("phone") phone:String, @Field("pwd") pwd:String, @Field("team_code") team_code:String="", client_id:String):ResponseData<LoginResponse>
	
	@POST("login")
	suspend fun login(@Field("phone") phone:String, @Field("pwd") pwd: String, @Field("client_id") client_id:String):ResponseData<LoginResponse>
	
	@POST("login")
	suspend fun login(@Field("phone") phone:String, @Field("token") token: String):ResponseData<LoginResponse>

	@POST("set_user")
	suspend fun setUser(@Body request:UserInfoRequest):ResponseData<Any>
	
	@GET("get_user")
	suspend fun getUser(@Path("token") token: String):ResponseData<UserInfoResponse>
	
	@POST("set_pwd")
	suspend fun setPwd(@Path("token") token: String, @Field("flag") flag:Int, @Field("new_pwd") new_pwd:String, @Field("old_pwd") old_pwd:String): ResponseData<Any>
	
	@POST("set_security")
	suspend fun setSecurity(@Field("token") token: String, @Field("question") question:String, @Field("answer") answer:String): ResponseData<Any>
	
	@GET("get_security")
	suspend fun getSecurity(@Path("token") token: String): ResponseData<SecurityResponse>
	
	@GET("get_team_info")
	suspend fun getTeamInfo(@Path("token") token: String): ResponseData<TeamInfo>
	
	@POST("recharge")
	suspend fun recharge(@Field("token") token: String, @Field("money") money:Float): ResponseData<ScoreBean>
	
	@POST("withdraw")
	suspend fun withdraw(@Field("token") token: String, @Field("money") money:Float, @Field("flag") flag:Int): ResponseData<ScoreBean>
	
	@POST("double_throw")
	suspend fun doubleThrow(@Field("token") token: String, @Field("score") score:Float, @Field("flag") flag:Int): ResponseData<ScoreBean>
	
	@GET("score_history")
	suspend fun score_history(@Path("token") token: String): ResponseData<ScoreHistory>
}