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
        user.setPasssword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
    public UserGetUser(Long id){
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    public User findByEmail(String email){
        return repo.findByEmail(email);
    }
    
}