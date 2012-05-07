package be.ebit.git.demo

class DefaultUserService implements UserService {
    private Set<User> registeredUsers = new HashSet<User>()
    @Override
    User createUser(String login, String password) {
        assert login, 'login is required'
        assert login.trim().length() > 0, 'login should not be blank'
        assert password, 'password is required'

        registeredUsers += new User(login, password)
        return null
    }
}
