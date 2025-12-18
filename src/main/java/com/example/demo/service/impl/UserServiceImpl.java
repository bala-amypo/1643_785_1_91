@Service 
public class YserServiceImpl implements UserService{
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder){
        this.repo = repo;
        this.encoder = enocder;
    }
    public User register(User user){
        if(repo.existsByEmail(user.getEmail()))
            throw new RuntimeException("Email already in use");
    
}