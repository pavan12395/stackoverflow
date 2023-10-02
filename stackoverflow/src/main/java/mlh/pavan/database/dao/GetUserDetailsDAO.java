package mlh.pavan.database.dao;


public class GetUserDetailsDAO
{
    private final String username;

    private final Double rating;

    public Double getRating(){return rating;}

    public String getUserName(){return username;}

    public GetUserDetailsDAO(String username,double rating)
    {
        this.username = username;
        this.rating = rating;
    }
}