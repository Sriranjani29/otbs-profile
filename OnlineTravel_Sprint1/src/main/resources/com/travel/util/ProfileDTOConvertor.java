package com.travel.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.travel.dto.ProfileDefaultResponseDTO;
import com.travel.entity.Profile;

@Component
@Scope("singleton")
public class ProfileDTOConvertor {
public static ProfileDefaultResponseDTO getProfileDefaultDTO(Profile profile)
{
	ProfileDefaultResponseDTO dto=new ProfileDefaultResponseDTO(
		profile.getFullName(),
		profile.getPhoneNo(),
		profile.getEmail(),
		profile.getFlatNo(),
		profile.getStreetName(),
		profile.getLandMark(),
		profile.getPinCode(),
		profile.getCity(),
		profile.getState(),
		profile.getCountry());
	return dto;
}
}
