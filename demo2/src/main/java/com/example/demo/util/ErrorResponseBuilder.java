package com.example.demo.util;

public class ErrorResponseBuilder {
	/**
	 * success 
	 */
	public static int SUCCESS=0;
	
	
	/*
	 * user service error prefix 500
	 */
	public static int InvalidLoginAccountType = 50001;
	
	public static String InvalidLoginAccountType_Message()
	{
		return String.format("{retCode:%d,uid:null}",InvalidLoginAccountType);
	}
	
	public static int InvalidPhoneNumberformat = 50002;
	
	public static String InvalidPhoneNumberformat_Message()
	{
		return String.format("{retCode:%d,uid:null}", InvalidPhoneNumberformat);
	}
	
	public static int AccountTypeNotProvided = 50003;
	
	public static String AccountTypeNotProvided_Message()
	{
		return String.format("{retCode:%d,uid:null}", AccountTypeNotProvided);
	}
	
	public static int AccountNotProvided = 50004;
	
	public static String AccountNotProvided_Message()
	{
		return String.format("{retCode:%d,uid:null}", AccountNotProvided);
	}
	
	public static int PasswordNotProvided = 50005;
	
	public static String PasswordNotProvided_Message()
	{
		return String.format("{retCode:%d,uid:null}", PasswordNotProvided);
	}
	
	public static int PasswordOrUserNameNotMatch = 50006;
	
	public static int DBError = 50007;
	
	public static int CacheLimitReached = 50008;
	
	public static int UserAlreadyExist = 50009;
	
	/**
	 * health service error prefix 600
	 */
	public static int ParameterNotProvided = 60001;
	
	/**
	 * sport data error prefix 600
	 */
	public static int InvalidUidOrTokenType = 60001;

	public static String InvalidUidOrTokenType_message() {
		return String.format("{retcode:%d,msg:invalid token}", InvalidUidOrTokenType);
	}
	
	public static int UploadDatasIsEmpty = 60002;
	
	public static String UploadDatasIsEmpty_message() {
		return String.format("retcode:%d,msg:upload empty data", UploadDatasIsEmpty);
	}
	
	public static int InvalidParams = 60003;
	
	public static String InvalidParamsHadSend() {
		return String.format("{retcode:%d,msg:InvalidParamsHadSend}", InvalidParams);
	}
	
	public static int InsertOrUpdateError = 60004;
	public static int NoData = 60404;
	public static String InsertOrUpdateTryCatch() {
		return String.format("retcode:%d,msg:InsertOrUpdateTryCatch}", InsertOrUpdateError);
	}
	
	
}
