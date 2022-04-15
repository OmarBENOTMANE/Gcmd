//package org.backend.gdc.service;
//package vts.security.api.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.*;
//
//import vts.security.api.dto.AdvancedUserDTO;
//import vts.security.api.dto.ConfirmationAccountDTO;
//import vts.security.api.exception.*;
//import vts.security.api.model.ConfirmationTokenEntity;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import vts.security.api.dto.ProfileDTO;
//import vts.security.api.dto.UserDTO;
//import vts.security.api.dto.UserPasswordDTO;
//import vts.security.api.mapper.ProfileMapper;
//import vts.security.api.mapper.UserMapper;
//import vts.security.api.model.ClientEntity;
//import vts.security.api.model.ProfileEntity;
//import vts.security.api.model.UserEntity;
//import vts.security.api.repository.ClientRepository;
//import vts.security.api.repository.ConfirmationTokenRepository;
//import vts.security.api.repository.UserRepository;
//import org.springframework.test.context.jdbc.Sql;
//
//@SpringBootTest
//@Sql(scripts = "classpath:/fixtures/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = "classpath:/fixtures/user.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = "classpath:/fixtures/client.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
///**
// * created by lnaoui 02-07-2021 05-07-2021 modified 12-07-2021
// **/
//class UserServiceTest {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ProfileMapper profileMapper;
//
//    @Autowired
//    ProfileService profileService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    ClientRepository clientRepository;
//
//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    ConfirmationTokenRepository confirmationTokenRepository;
//
//    @Autowired
//    EmailSenderService emailSenderService;
//
//    String token = UUID.randomUUID().toString();
//
//    @Test
//    @BeforeEach
//    final void setUp() {
//        assertNotNull(userService);
//
//    }
//
//    @Test
//    final void test_FindById_OK() {
//        UserDTO userDTO = userService.findById(1L);
//        assertNotNull(userDTO);
//        assertEquals(1L, userDTO.getId());
//    }
//
//    @Test
//    void test_FindByIdNotFound() {
//
//        Assertions.assertThrows(ObjectNotFoundException.class, () -> userService.findById(5L),
//                "Expected findById() to throw ObjectNotFoundException, but it didn't");
//    }
//
//    @Test
//    final void test_FindById_ObjectNotFoundException_OK() {
//        assertThrows(ObjectNotFoundException.class, () -> {
//            userService.findById(12L);
//        });
//    }
//
//    @Test
//    final void test_FindByUsename_OK() {
//        UserDTO userDTO = userService.findByUsername("user1");
//        assertNotNull(userDTO);
//        assertEquals("user1", userDTO.getUsername());
//    }
//
//    @Test
//    final void test_FindByUsename_ObjectNotFoundException_OK() {
//        assertThrows(ObjectNotFoundException.class, () -> {
//            userService.findByUsername("user12");
//        });
//    }
//
//    @Test
//    final void test_FindAll_OK() {
//        Page<UserDTO> page = userService.findAll(PageRequest.of(0, 10));
//        assertNotNull(page);
//        assertEquals(4, page.getContent().size());
//        UserDTO userDTO = page.getContent().get(0);
//        assertEquals("user1", userDTO.getUsername());
//    }
//
//    @Test
//    final void test_Create_OK() {
//        UserDTO userDTO = createNewUserDTO();
//        UserDTO resultDTO = userService.create(userDTO);
//        assertNotNull(userDTO);
//        assertEquals("user4", resultDTO.getUsername());
//        assertEquals("user4@valueit.ma", resultDTO.getEmail());
//    }
//
//    @Test
//    final void test_Create_ObjectAlreadyExistException() {
//        UserDTO userDTO = createUserDTO();
//        assertThrows(ObjectAlreadyExistException.class, () -> {
//            userService.create(userDTO);
//        });
//    }
//
//    @Test
//    final void test_Update_OK() {
//        UserDTO dto = userService.findById(1L);
//        dto.setUsername("new username");
//        dto.setUsername("user10@valueit.ma");
//        dto.setPassword(passwordEncoder.encode("123456"));
//        userService.update(1L, dto);
//        UserDTO updated = userService.findById(1L);
//        assertNotNull(updated);
//        assertEquals(dto.getId(), updated.getId());
//        assertEquals(dto.getUsername(), updated.getUsername());
//        assertEquals(dto.getEmail(), updated.getEmail());
//    }
//
//    @Test
//    final void test_deleteById() {
//        final long ID = 1L;
//        userService.delete(ID);
//        test_FindByIdNotFound();
//    }
//
//    @Test
//    void test_LoadUserByUsernameUser() {
//        UserDetails userDTO = userService.loadUserByUsername("user1");
//        assertNotNull(userDTO);
//        assertEquals("user1", userDTO.getUsername(), "There should have been user1 in the Username");
//        assertEquals("12345", userDTO.getPassword(), "There should have been 123456 in the Password");
//    }
//
//    @Test
//    void test_LoadUserByUsernameUser_ObjectNotFoundException_OK() {
//        assertThrows(ObjectNotFoundException.class, () -> {
//            userService.loadUserByUsername("user12");
//        });
//    }
//
//    @Test
//    void test_ResetPassword_IllegalNullParam() {
//
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.resetPassword(null),
//                "Expected resetPassword() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_AffectProfilesToUser_llegalNullParam() {
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.affectProfilesToUser(1L, null),
//                "Expected affectProfilesToUser() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_AffectProfilesToUserDtosllegalNullParam() {
//        List<ProfileDTO> profiles = createListProfileDTO();
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.affectProfilesToUser(null, profiles),
//                "Expected affectProfilesToUser() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_AffectProfilesToUser() {
//        List<ProfileDTO> profiles = createListProfileDTO();
//        UserEntity result = userService.affectProfilesToUser(1L, profiles);
//
//        assertEquals(1L, result.getId(), "There should have been 1 in the ID");
//        assertNotNull(result.getProfiles(), "There should have been nor null in the Profiles");
//        assertEquals(2, result.getProfiles().size(), "There should have been 2 in the Profiles");
//
//    }
//
//    @Test
//    void test_GetUserProfilesIllegalNullParam() {
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.getUserProfiles(null),
//                "Expected getUserProfiles() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_GetUserProfiles_NotNull() {
//        List<ProfileDTO> results = userService.getUserProfiles(1L);
//
//        assertNotNull(results, "There should have been null in the list");
//    }
//
//    @Test
//    void test_FindDistinctByClientNameIllegalNullParam() {
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.findDistinctByClientName(null),
//                "Expected findDistinctByClientName() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_FindDistinctByClientName_NotNull() {
//
//        List<UserDTO> results = userService.findDistinctByClientName("client1");
//        assertNotNull(results, "There should have been null in the list");
//    }
//
//    @Test
//    void test_ConfirmAccountIllegalNullParamException() {
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.confirmAccount(null),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//    }
//
//    @Test
//    void test_ConfirmAccountTokenException() {
//        ConfirmationAccountDTO cf = createConfirmationAccountDTO();
//        Assertions.assertThrows(TokenException.class, () -> userService.confirmAccount(cf),
//                "Expected confirmAccount() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_VerifyClientByNameAndTokenObjectNotFoundException() {
//
//        Assertions.assertThrows(ObjectNotFoundException.class,
//                () -> userService.verifyClientByNameAndToken("client11", "token1234"),
//                "Expected ObjectNotFoundException() to throw ObjectNotFoundException, but it didn't");
//    }
//
//    @Test
//    void test_VerifyClientByNameAndTokenInvalidTokenException() {
//
//        Assertions.assertThrows(InvalidTokenException.class,
//                () -> userService.verifyClientByNameAndToken("client1", "token1234"),
//                "Expected InvalidTokenException() to throw InvalidTokenException, but it didn't");
//    }
//
//    @Test
//    void test_RegisterAccountByClientIllegalNullParamException() {
//        // input dto null
//        Assertions.assertThrows(IllegalNullParamException.class,
//                () -> userService.registerAccountByClient(null, "name", "1213131DAAZEARA"),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//
//    }
//
//    @Test
//    void test_RegisterAccountByClientIllegalNullParamExceptionName() {
//        // input name null
//        AdvancedUserDTO dto = createAdvancedUserDTO();
//        test_VerifyClientByNameAndTokenInvalidTokenException();
//        Assertions.assertThrows(IllegalNullParamException.class,
//                () -> userService.registerAccountByClient(dto, null, "tpken-1234"),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//    }
//
//    @Test
//    void test_RegisterAccountByClientIllegalNullParamExceptionToken() {
//        // input token null
//        AdvancedUserDTO dto = createAdvancedUserDTO();
//        test_VerifyClientByNameAndTokenInvalidTokenException();
//        Assertions.assertThrows(IllegalNullParamException.class,
//                () -> userService.registerAccountByClient(dto, "client1", null),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//    }
//
//    @Test
//    void test_RegisterAccountIllegalNullParamException() {
//        // input dto null
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.registerAccount(null),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//    }
//
//    @Test
//    void test_RegisterAccountIllegalNullParamExceptionUsers() {
//        // input user null
//        AdvancedUserDTO dto = new AdvancedUserDTO();
//
//        List<String> profiles = new ArrayList<>();
//
//        String codeP = "admin";
//        String codeP1 = "user";
//        profiles.add(codeP);
//        profiles.add(codeP1);
//
//        dto.setProfileCode(profiles);
//        dto.setUserDTO(null);
//
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.registerAccount(dto),
//                "Expected IllegalNullParamException() to throw IllegalNullException, but it didn't");
//    }
//
//    @Test
//    void test_RegisterAccountObjectAlreadyExistException() {
//        // ObjectAlreadyExistException
//        AdvancedUserDTO dto = new AdvancedUserDTO();
//
//        List<String> profiles = new ArrayList<>();
//
//        String codeP = "admin";
//        String codeP1 = "user";
//        profiles.add(codeP);
//        profiles.add(codeP1);
//
//        dto.setProfileCode(profiles);
//        dto.setUserDTO(createUserDTO());
//        Assertions.assertThrows(ObjectAlreadyExistException.class, () -> userService.registerAccount(dto),
//                "Expected ObjectAlreadyExistException() to throw ObjectAlreadyExistException, but it didn't");
//
//    }
//
//    @Test
//    void testRegisterAccount() {
//        // ok
//        AdvancedUserDTO dto = new AdvancedUserDTO();
//
//        List<String> profiles = new ArrayList<>();
//
//        String codeP = "admin";
//        String codeP1 = "user";
//        profiles.add(codeP);
//        profiles.add(codeP1);
//
//        dto.setProfileCode(profiles);
//        UserDTO user = new UserDTO();
//        user.setId(5L);
//        user.setEmail("user-test@valueit.ma");
//        user.setUsername("user-test");
//        user.setAttributes(null);
//        user.setPassword("12345678");
//        dto.setUserDTO(user);
//
//        UserDTO result = userService.registerAccount(dto);
//
//        assertEquals(5L, result.getId(), "There should have been 1 in the ID");
//        assertEquals("user-test", result.getUsername(), "There should have been user-test in the username");
//
//    }
//
//    @Test
//    void test_ResetPasswordIllegalNullParam() {
//
//        Assertions.assertThrows(IllegalNullParamException.class, () -> userService.resetPassword(null),
//                "Expected resetPassword() to throw IllegalNullParamException, but it didn't");
//    }
//
//    @Test
//    void test_ResetPasswordNotFound() {
//
//        Assertions.assertThrows(ObjectNotFoundException.class, () -> userService.resetPassword("user11@valueit.ma"),
//                "Expected resetPassword() to throw ObjectNotFoundException, but it didn't");
//    }
//
//    @Test
//    void test_ResetPassword() {
//        userService.resetPassword("user1@valueit.ma");
//        Collection collection = new ArrayList();
//        assertEquals(0, collection.size());
//    }
//
//    @Test
//    void test_UpdatePassword() {
//        UserPasswordDTO dto = new UserPasswordDTO();
//        dto.setNewPassword("stahiri");
//        dto.setOldPassword("admin");
//
//        UserDTO result = userService.updatePassword("stahiri", dto);
//
//        assertEquals(4L, result.getId(), "There should have been 4 in the ID");
//
//        assertTrue(passwordEncoder.matches(dto.getNewPassword(),result.getPassword()),"There should have been TRUE");
//    }
//
//    @Test
//    void test_UpdatePassword_ObjectNotFoundException() {
//        UserPasswordDTO dto = new UserPasswordDTO();
//        dto.setNewPassword("stahiri");
//        dto.setOldPassword("admin");
//        Assertions.assertThrows(ObjectNotFoundException.class, () -> 	userService.updatePassword("notfound",dto),
//                "Expected updatePassword() to throw ObjectNotFoundException, but it didn't");
//    }
//
//    @Test
//    void test_UpdatePassword_InvalidPasswordException() {
//        UserPasswordDTO dto = new UserPasswordDTO();
//        dto.setNewPassword("stahiri");
//        dto.setOldPassword("invalid//");
//        Assertions.assertThrows(InvalidPasswordException.class, () -> 	userService.updatePassword("stahiri",dto),
//                "Expected updatePassword() to throw InvalidPasswordException, but it didn't");
//    }
//
//    AdvancedUserDTO createAdvancedUserDTO() {
//        AdvancedUserDTO dto = new AdvancedUserDTO();
//
//        List<String> profiles = new ArrayList<>();
//
//        String codeP = "admin";
//        String codeP1 = "user";
//        profiles.add(codeP);
//        profiles.add(codeP1);
//
//        dto.setUserDTO(createUserDTO());
//        dto.setProfileCode(profiles);
//        return dto;
//    }
//
//    ConfirmationAccountDTO createConfirmationAccountDTO() {
//        ConfirmationAccountDTO dto = new ConfirmationAccountDTO();
//        dto.setConfirmationToken("confirmation-token");
//        dto.setUserPassword("12345");
//        return dto;
//    }
//
//    ConfirmationTokenEntity createConfirmationTokenEntity() {
//        ConfirmationTokenEntity entity = new ConfirmationTokenEntity();
//        entity.setUser(createUserEntity());
//        entity.setConfirmationToken(token);
//        entity.setTokenid(1);
//        return entity;
//    }
//
//    ClientEntity createClientEntity() {
//        ClientEntity entity = new ClientEntity();
//        entity.setId(1L);
//        entity.setName("client1");
//        return entity;
//    }
//
//    ProfileDTO createProfileDTO() {
//        ProfileDTO dto = new ProfileDTO();
//        dto.setId(1L);
//        dto.setCode("admin");
//        dto.setIsSuspended(false);
//        dto.setName("admin");
//        return dto;
//    }
//
//    ProfileDTO createProfileDTO1() {
//        ProfileDTO dto = new ProfileDTO();
//        dto.setId(2L);
//        dto.setCode("admin-2");
//        dto.setIsSuspended(false);
//        dto.setName("admin-2");
//        return dto;
//    }
//
//    List<ProfileDTO> createListProfileDTO() {
//        List<ProfileDTO> profileDTOS = new ArrayList<>();
//
//        profileDTOS.add(createProfileDTO());
//        profileDTOS.add(createProfileDTO1());
//
//        return profileDTOS;
//    }
//
//    ProfileEntity createProfileEntity() {
//        ProfileEntity entity = new ProfileEntity();
//        entity.setId(1L);
//        entity.setCode("admin");
//        entity.setIsSuspended(false);
//        entity.setName("admin");
//        return entity;
//    }
//
//    UserEntity createUserEntity() {
//        UserEntity user = new UserEntity();
//        user.setId(1L);
//        user.setEmail("user1@valueit.ma");
//        user.setUsername("user1");
//        user.setEnabled(true);
//        user.setPassword("12345");
//        return user;
//    }
//
//    UserDTO createUserDTO() {
//        UserDTO user = new UserDTO();
//        user.setId(1L);
//        user.setEmail("user1@valueit.ma");
//        user.setUsername("user1");
//        user.setAttributes(null);
//        user.setPassword("12345");
//        return user;
//    }
//
//    UserDTO createNewUserDTO() {
//        UserDTO user = new UserDTO();
//        user.setId(4L);
//        user.setEmail("user4@valueit.ma");
//        user.setUsername("user4");
//        user.setAttributes(null);
//        user.setPassword("12345");
//        return user;
//    }
//
//}
