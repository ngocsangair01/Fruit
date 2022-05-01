package com.fruits.congtyhoaqua.services.imp;

import com.cloudinary.api.exceptions.BadRequest;
import com.fruits.congtyhoaqua.dtos.UserDTO;
import com.fruits.congtyhoaqua.exceptions.BadRequestException;
import com.fruits.congtyhoaqua.exceptions.NotFoundException;
import com.fruits.congtyhoaqua.models.User;
import com.fruits.congtyhoaqua.repositories.UserRepository;
import com.fruits.congtyhoaqua.services.IUserService;
import com.fruits.congtyhoaqua.utils.Convert;
import com.fruits.congtyhoaqua.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class UserServiceImp implements IUserService {
    @Autowired private UserRepository userRepository;
    @Autowired private UploadFile uploadFile;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDTO userDTO) {
        User oldUser = userRepository.findByAccount(userDTO.getAccount());
        if(oldUser != null){
            throw new BadRequestException("Duplicate user");
        }
        User user = new User();
        Convert.fromUserDTOToUser(userDTO,user);
        return userRepository.save(user);
    }

    @Override
    public User editUser(Integer idUser, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user");
        }
        user.get().setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(Convert.fromUserDTOToUser(userDTO, user.get()));
    }

    @Override
    public User deleteUser(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user");
        }
        userRepository.delete(user.get());
        return user.get();
    }

    @Override
    public Set<User> findAllByName(String name) {
        Set<User> users = userRepository.findAllByNameContaining(name);
        if(users.isEmpty()){
            throw new NotFoundException("No user");
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw  new NotFoundException("No user");
        }
        return user.get();
    }

    @Override
    public User editPassWord(Integer idUser, String password) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user");
        }
        user.get().setPassword(password);
        return userRepository.save(user.get());
    }

    @Override
    public User editAvatar(Integer idUser, MultipartFile avatar) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()){
            throw new NotFoundException("No user");
        }
        user.get().setAvatar(uploadFile.getUrlFromFile(avatar));
        return userRepository.save(user.get());
    }

    @Override
    public Set<User> getAllUser() {
        Set<User> users = new HashSet<>(userRepository.findAll());
        if (users.isEmpty()){
            throw new NotFoundException("No user.");
        }
        return users;
    }
}
