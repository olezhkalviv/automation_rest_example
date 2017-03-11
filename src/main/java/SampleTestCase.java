import controlers.UserController;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class SampleTestCase {
    UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse() {
        // Expected Data
        String login = "olezhkalviv";
        Integer id = 25117767;
        String htmlUrl = "https://github.com/olezhkalviv";
        String type = "User";
        String name = "Olezhka";
        // Actions
        User user = userController.getUserByUsername("olezhkalviv");
        // Assertions
        Assert.assertEquals(login, user.getLogin());
        Assert.assertEquals(id, user.getId());
        Assert.assertEquals(htmlUrl, user.getHtmlUrl());
        Assert.assertEquals(type, user.getType());
        Assert.assertEquals(name, user.getName());
    }

    @Test
    public void testNoFollowers() {
        // Actions
        User[] followers = userController.getFollowersByUsername("olezhkalviv");
        // Assertions
        Assert.assertTrue("You shoudln't have followers :-)", followers.length == 0);
    }
}
