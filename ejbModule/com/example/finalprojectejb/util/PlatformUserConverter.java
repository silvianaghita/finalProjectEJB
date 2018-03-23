package com.example.finalprojectejb.util;

import com.example.finalprojectejb.dto.PlatformUserDTO;
import com.example.finalprojectejb.model.PlatformUser;

public class PlatformUserConverter {

	public static void dtoToPlatformUser(PlatformUserDTO platformUserDTO, PlatformUser platformUser) {
		platformUser.setId(platformUserDTO.getId())
		.setAddress(platformUserDTO.getAddress())
		.setEmail(platformUserDTO.getEmail())
		.setPassword(platformUserDTO.getPassword())
		.setUsername(platformUserDTO.getUsername());
	}

	public static void platformUserToDTO( PlatformUser platformUser,PlatformUserDTO platformUserDTO) {
		platformUserDTO.setId(platformUser.getId())
		.setAddress(platformUser.getAddress())
		.setEmail(platformUser.getEmail())
		.setPassword(platformUser.getPassword())
		.setUsername(platformUser.getUsername());
	}

}
