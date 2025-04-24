import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RewardSystem {
    private List<User> users;

    public RewardSystem() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUser(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public void removeUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }

    public boolean addPoints(String userId, int points) {
        User user = findUser(userId);
        if (user != null) {
            user.addPoints(points);
            return true;
        }
        return false;
    }

    public boolean redeemPoints(String userId, int points) {
        User user = findUser(userId);
        if (user != null) {
            return user.redeemPoints(points);
        }
        return false;
    }

    public List<User> getUsersByTier(String tier) {
        return users.stream()
                .filter(user -> user.getMembershipTier().equalsIgnoreCase(tier))
                .collect(Collectors.toList());
    }

    public List<User> getTopUsers(int count) {
        return users.stream()
                .sorted((u1, u2) -> Integer.compare(u2.getPoints(), u1.getPoints()))
                .limit(count)
                .collect(Collectors.toList());
    }

    public void displayAllUsers() {
        System.out.println("\n=== All Users ===");
        users.forEach(System.out::println);
    }

    public void displayUsersByTier(String tier) {
        System.out.println("\n=== " + tier + " Tier Users ===");
        getUsersByTier(tier).forEach(System.out::println);
    }

    public void displayTopUsers(int count) {
        System.out.println("\n=== Top " + count + " Users ===");
        getTopUsers(count).forEach(System.out::println);
    }

    public int getTotalUsers() {
        return users.size();
    }

    public int getUsersInTier(String tier) {
        return (int) users.stream()
                .filter(user -> user.getMembershipTier().equalsIgnoreCase(tier))
                .count();
    }
} 