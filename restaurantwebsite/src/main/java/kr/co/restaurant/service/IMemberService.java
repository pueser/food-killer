package kr.co.restaurant.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.domain.MemberDTO;

public interface IMemberService {
	public MemberDTO loginCheck(MemberDTO loginDto)throws Exception;
	public int nickNameChk(String nickName) throws Exception;
	public int emailChk(String email) throws Exception;
	public void updatePwd(String ranPwd, String email)throws Exception;
	public String memberSave(MemberDTO member, MemberAttachDTO memberAttachDTO, int reJoinResult) throws Exception;
	public MemberAttachDTO selectProfile(MemberDTO memInfo)throws Exception;
	public int updateProfile(MemberAttachDTO uploadResultArr, MemberDTO memInfo)throws Exception;
	public int deleteMember(MemberDTO memInfo, String widthdrawalAgree)throws Exception;
	public int selectMemberState(MemberDTO member)throws Exception;
	public void upadateDate(Object memInfo)throws Exception;
}
