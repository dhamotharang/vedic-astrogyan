package com.vedic.astro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.UserInfo;
import com.vedic.astro.dto.UserCredentialsDTO;
import com.vedic.astro.dto.UserDTO;
import com.vedic.astro.dto.UserInfoDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.repository.UserInfoRepository;
import com.vedic.astro.util.EncryptionUtil;

@Service("authService")
@Transactional
public class AuthService {

	@Autowired
	@Qualifier("userInfoRepository")
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	@Qualifier("encryptionUtil")
	private EncryptionUtil encryptionUtil;
	
	@Value("${error.msg.auth.failed}") 
	public String AUTH_FAILED_MSG;
	

	public UserDTO login(UserCredentialsDTO userCredentials) throws BusinessException{

		userCredentials.setPassword(
				encryptionUtil.encrypt(
						userCredentials.getPassword()));
		
		Optional<List<UserInfo>> userList = this.userInfoRepository.getUserInfoByEmailAndPwd(
				userCredentials.getEmail(), 
				userCredentials.getPassword());

		UserInfo userInfo = null;
		
		if (userList.isPresent() && !userList.get().isEmpty()) {
			userInfo = userList.get().get(0);
		}

		if(userInfo == null){
			throw new BusinessException(Constants.AUTH_FAILED, AUTH_FAILED_MSG);
		}
		
		userInfo.setLastLoginTS(new Date());
		userInfo.setLoggedIn(true);
		
		userInfoRepository.save(userInfo);
		
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userInfo, userDTO);

		return userDTO;
	}
	
	public String save(UserInfoDTO userInfoDTO) {

		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(userInfoDTO, userInfo);
		
		userInfo.setPassword(encryptionUtil.encrypt(userInfoDTO.getPassword()));
		userInfo = this.userInfoRepository.save(userInfo);

		return userInfo.getId();
	}
}