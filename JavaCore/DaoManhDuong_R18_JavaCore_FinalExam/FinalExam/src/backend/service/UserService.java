package backend.service;

import backend.repository.IUserRepository;

public class UserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
