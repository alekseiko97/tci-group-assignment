public interface BetTokenAuthority {

    String getUniqueToken(String betID);
    Integer getRandomWholeNumber(String token);

}
