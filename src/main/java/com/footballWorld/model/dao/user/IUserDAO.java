package com.footballWorld.model.dao.user;

import java.util.Map;

import com.footballWorld.controller.exceptions.DataBaseException;
import com.footballWorld.controller.exceptions.IllegalInputException;
import com.footballWorld.pojo.User;



public interface IUserDAO {

	boolean checkUsername(String username) throws IllegalInputException,DataBaseException;

	boolean checkEmail(String email) throws IllegalInputException,DataBaseException;

	User addNewUserToDB(User user) throws DataBaseException, IllegalInputException;

	User loginUser(User user) throws IllegalInputException,DataBaseException;

//	User getUserById(int userId) throws DataBaseException, IllegalInputException;
//
//	int addNewUserToDB(User user) throws DataBaseException, IllegalInputException;
//
//	Map<String, User> getAllUsers() throws IllegalInputException, DataBaseException;
//
//	User getUserByUserName(String username) throws IllegalInputException, DataBaseException;
//
//	User getUserByEmail(String email) throws IllegalInputException, DataBaseException;
//
//	boolean updatePassword(int user_id, String oldPassword, String newPassword) throws DataBaseException, IllegalInputException;
//
//	boolean updateProfilePicture(String pictureURL, int userId) throws IllegalInputException, DataBaseException;
//
//	boolean deleteProfilePicture(int userId) throws IllegalInputException, DataBaseException;
//
//	boolean deleteUser(int userId) throws IllegalInputException, DataBaseException;
//  
//	int loginUser(User user)throws IllegalInputException, DataBaseException;

}