package com.travel.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.Profile;
import com.travel.repository.ProfileRepository;

@SpringBootTest
class ProfileServiceImplTest {
	@Mock

	ProfileRepository profileRepository;

	@InjectMocks

	ProfileServiceImpl profileService;

	@Test
	@DisplayName("Test - to verify the add operation")

	void testAddProfile() {
		Profile sampleInput = new Profile("Swasthika", 769872341, "swasthi@gmail.com", 76, "Townhall Street",
				"Alappuzha", 625001, "Thiruvanthapuram", "Kerala", "India");
		Profile expectedOutput = new Profile("Swasthika", 769872341, "swasthi@gmail.com", 76, "Townhall Street",
				"Alappuzha", 625003, "Thiruvanthapuram", "Kerala", "India");
		BDDMockito.given(profileService.addProfile(sampleInput)).willReturn(expectedOutput);

		// when
		Profile actualOutput = profileService.addProfile(sampleInput);

		// verify
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	@DisplayName("Test to verify the method getUser by Id should return AppUser or not")

	void testGetProfileByProfileId() throws Exception {
		Profile sampleOutput = new Profile("Swasthika", 769872341, "swasthi@gmail.com", 76, "Townhall Street",
				"Alappuzha", 625001, "Thiruvanthapuram", "Kerala", "India");
		sampleOutput.setProfileId(5);

		int sampleInput = 5;

		BDDMockito.given(profileService.getProfileByProfileId(sampleInput)).willReturn(sampleOutput);

		// when
		Profile actualOutput = profileService.getProfileByProfileId(sampleInput);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getProfileId(), actualOutput.getProfileId());
		assertThat(actualOutput.getProfileId()).isGreaterThan(0);
	}

	@Test
	@DisplayName("Get all profiles between id")

	void testGetProfileBetweenProfileIds() throws Exception {
		Profile profile1 = new Profile("Swasthika", 769872341, "swasthi@gmail.com", 76, "Townhall Street", "Alappuzha",
				625001, "Thiruvanthapuram", "Kerala", "India");
		Profile profile2 = new Profile("Karthik Krishnan", 952486145, "karthik@gmail.com", 79, "Gandhi street",
				"Siruseri", 625003, "Chennai", "Tamilnadu", "India");

		List<Profile> sampleOutput = new ArrayList<>();
		sampleOutput.add(profile1);
		sampleOutput.add(profile2);

		int sampleInput1 = 1;
		int sampleInput2 = 20;

		BDDMockito.given(profileService.getProfileBetweenProfileIds(sampleInput1, sampleInput2))
				.willReturn(sampleOutput);
		/// when
		List<Profile> actualOutput = profileService.getProfileBetweenProfileIds(sampleInput1, sampleInput2);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);
	}

	@Test
	@DisplayName("Get all the profiles")
	void testGetAllProfiless() throws Exception {
		Profile profile1 = new Profile("Swasthika", 769872341, "swasthi@gmail.com", 76, "Townhall Street", "Alappuzha",
				625001, "Thiruvanthapuram", "Kerala", "India");
		Profile profile2 = new Profile("Karthik Krishnan", 952486145, "karthik@gmail.com", 79, "Gandhi street",
				"Siruseri", 625003, "Chennai", "Tamilnadu", "India");

		List<Profile> sampleOutput = new ArrayList<>();
		sampleOutput.add(profile1);
		sampleOutput.add(profile2);

		BDDMockito.given(profileService.getAllProfiless()).willReturn(sampleOutput);

		List<Profile> actualOutput = profileService.getAllProfiless();

		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull(); // or
		assertNotNull(actualOutput);
		// assertThat(actualOutput.size()).isGreaterThan(0);

		assertIterableEquals(sampleOutput, actualOutput);

	}

}
