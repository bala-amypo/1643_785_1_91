
public interface UserService{
    User register(User, user);
    User getUser(Long id);
    User findByEmail(String email);
}