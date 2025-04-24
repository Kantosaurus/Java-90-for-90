public class User {
    private String userId;
    private String name;
    private int points;
    private String membershipTier;
    private static final int BRONZE_THRESHOLD = 0;
    private static final int SILVER_THRESHOLD = 1000;
    private static final int GOLD_THRESHOLD = 5000;
    private static final int PLATINUM_THRESHOLD = 10000;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.points = 0;
        this.membershipTier = "Bronze";
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    public void addPoints(int points) {
        this.points += points;
        updateMembershipTier();
    }

    public boolean redeemPoints(int points) {
        if (this.points >= points) {
            this.points -= points;
            updateMembershipTier();
            return true;
        }
        return false;
    }

    private void updateMembershipTier() {
        if (points >= PLATINUM_THRESHOLD) {
            membershipTier = "Platinum";
        } else if (points >= GOLD_THRESHOLD) {
            membershipTier = "Gold";
        } else if (points >= SILVER_THRESHOLD) {
            membershipTier = "Silver";
        } else {
            membershipTier = "Bronze";
        }
    }

    public int getPointsToNextTier() {
        switch (membershipTier) {
            case "Bronze":
                return SILVER_THRESHOLD - points;
            case "Silver":
                return GOLD_THRESHOLD - points;
            case "Gold":
                return PLATINUM_THRESHOLD - points;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("User ID: %s, Name: %s, Points: %d, Tier: %s, Points to next tier: %d",
            userId, name, points, membershipTier, getPointsToNextTier());
    }
} 